package net.amentum.niomedic.niogateway.api.rest;

import net.amentum.niomedic.niogateway.api.rest.pacientes.PacienteRest;
import net.amentum.niomedic.niogateway.api.rest.security.ProfileRest;
import net.amentum.niomedic.niogateway.api.rest.security.UserAppRest;
import net.amentum.niomedic.niogateway.api.rest.views.security.NodeTree;
import net.amentum.niomedic.niogateway.api.rest.views.security.ProfileView;
import net.amentum.niomedic.niogateway.api.rest.views.security.UserAppPageView;
import net.amentum.niomedic.niogateway.api.rest.views.security.UserAppView;
import net.amentum.niomedic.niogateway.exception.ApiErrorDecoder;
import net.amentum.niomedic.niogateway.exception.MedicoCompositeException;
import net.amentum.niomedic.niogateway.views.PacienteUserView;
import net.amentum.niomedic.pacientes.exceptions.PacienteException;
import net.amentum.niomedic.pacientes.views.PacienteView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.springframework.transaction.annotation.Transactional;

//@Transactional(readOnly = true)
@RestController
@RequestMapping("paciente-usuario")
public class PacienteCompositeRest {
   private final Logger logger = LoggerFactory.getLogger(PacienteCompositeRest.class);
   @Autowired
   private ApiErrorDecoder apiErrorDecoder;

   @Autowired
   private PacienteRest pacienteRest;

   @Autowired
   private UserAppRest userAppRest;

   @Autowired
   private ProfileRest profileRest;

   @PostMapping
   public PacienteView createPacienteUsuario(@RequestBody @Validated PacienteUserView pacienteUserVIew) throws MedicoCompositeException, PacienteException {
      boolean bandera = true;
      PacienteView pacienteView = pacienteUserVIew.getPacienteVIew();
      UserAppView userAppView = pacienteUserVIew.getUserAppView();
      userAppView.setUsername(pacienteView.getUserName());
      userAppView.setEmail(pacienteView.getEmail());
      userAppView.setName(pacienteView.getNombre() + " " + pacienteView.getApellidoPaterno() + " " + pacienteView.getApellidoMaterno());
      userAppView.setStatus("ACTIVO");
      userAppView.setProfileId(27L);
      userAppView.setIdTipoUsuario(3);
      // Sre03072020 Inicia En vez de grupo Pacientes(2), uso el seleccionado por el médico si es que viene
      List<Long> tempo = new ArrayList<>();
      if (pacienteUserVIew.getSelectedGroup() != null && pacienteUserVIew.getSelectedGroup().longValue() > 0L) {
          tempo.add(pacienteUserVIew.getSelectedGroup());
      } else { // Lo dejamos en Pacientes(2)
        tempo.add(2L);
      }
      // Sre03072020 Termina
      userAppView.setGroupList(tempo);
      try {
         logger.info("===>>>createPacienteUsuario() -  Obteniendo lista de permisos para el perfil PACIENTE");
         ProfileView profileView = profileRest.findProfile(27L);
         List<Long> idPermissionsList = new ArrayList<>();
         for (NodeTree node : profileView.getTree()) {
            for (NodeTree children : node.getChildren()) {
               if (children.getActive()) {
                  idPermissionsList.add(children.getId());
               }
            }
         }
         logger.info("===>>>createPacienteUsuario() - Asignando permisos:{}", idPermissionsList);
         userAppView.setPermissionsList(idPermissionsList);
         logger.info("===>>>createPacienteUsuario() - Guardando nuevo USUARIO: {}", userAppView);
         UserAppPageView userAppPageView = userAppRest.createUserApp(userAppView);
         pacienteView.setIdUsuario(userAppPageView.getIdUserApp());
         pacienteView.setUserName(userAppPageView.getUsername());
         logger.info("===>>>createPacienteUsuario() - El nuevo USUARIO es: {}", userAppPageView);
      } catch (Exception ex) {
         logger.error("===>>>createPacienteUsuario() - No se pudo insertar el nuevo USUARIO: {}", userAppView);
         bandera = false;
         MedicoCompositeException mcE = new MedicoCompositeException("Error en nuevo USUARIO", MedicoCompositeException.LAYER_REST, MedicoCompositeException.ACTION_INSERT);
         mcE.addError("No se pudo insertar el nuevo USUARIO: " + apiErrorDecoder.toString().replace('\"', ' ').replace('\n', ' '));
         throw mcE;
      }
      if (bandera) {
         PacienteView resultado = null;
         try {
            logger.info("===>>>createPacienteUsuario() - Guardando nuevo PACIENTE: {}", pacienteView);
            resultado = pacienteRest.createPaciente(pacienteView);
            // Sre03072020 Inicia Ahora tengo que actualizar los grupos del paciente
            pacienteRest.updatePacienteGroups(pacienteView.getIdUsuario(), userAppView.getGroupList());
            // Sre03072020 Termina
            try {
               if(pacienteUserVIew.getCode() != null && !pacienteUserVIew.getCode().isEmpty()) {
                  Map<String,String> replacements = new HashMap<>();
                  replacements.put("username",userAppView.getUsername().toUpperCase());
                  replacements.put("code",pacienteUserVIew.getCode());
                  replacements.put("email",userAppView.getEmail().toUpperCase());
                  logger.info("Email destinatario - {} ", userAppView.getEmail());
                  logger.info("Envio de email - {}", new Email()
                          .sendEmail("Generación de nuevo usuario", userAppView.getEmail(), replacements));
               } else
                  logger.info("Code no encontrado en la vista");
            } catch (Exception ex) {
               logger.error("Error enviando correo de registro: {}", ex.toString());
            }
         } catch (Exception ex) {
            logger.error("===>>>createPacienteUsuario() - No se pudo crear el PACIENTE, idUsuario: {}", pacienteView.getIdUsuario());
            logger.error("Error: {}", ex.toString());
            logger.info("Haciendo rollback en usuarios");
            userAppRest.deleteRollBack(pacienteView.getIdUsuario());
            logger.info("Rollback terminado");
            MedicoCompositeException mcE = new MedicoCompositeException("Error en nuevo PACIENTE", MedicoCompositeException.LAYER_REST, MedicoCompositeException.ACTION_INSERT);
            mcE.addError("No se pudo insertar el nuevo PACIENTE: " + apiErrorDecoder.toString().replace('\"', ' ').replace('\n', ' '));
            throw mcE;
         }
         return resultado;
      } else {
         return null;
      }
   }

   @GetMapping("{idUsuario}")
   public PacienteUserView getPacienteUserView(@PathVariable("idUsuario") Integer idUsuario, @RequestParam(required = false, name = "image") Boolean image) {
      try {
         logger.info("===>>>getPacienteUserView() - Obteniendo PACIENTE y su Usuario con el idUsuario {}" + idUsuario);
         PacienteUserView pacienteUserView = new PacienteUserView();
         pacienteUserView.setUserAppView(userAppRest.findById(idUsuario.longValue(), image));
         pacienteUserView.setPacienteVIew(pacienteRest.getPacienteByIdUsuario(idUsuario));
         pacienteUserView.setSelectedGroup(new Long(0L)); // Sre03072020 Es sólo para agregar, asi que va en cero al leer
         return pacienteUserView;
      } catch (Exception ex) {
         logger.error("===>>>getPacienteUserView() - ocurrio un error al OBTENER al PACIENTE y el USUARIO -{}", ex);
         return null;
      }
   }

   @PutMapping()
   public PacienteView updatePacienteUserView(@RequestBody @Validated PacienteUserView pacienteUserView) throws MedicoCompositeException {
      try {
         if (pacienteUserView.getUserAppView().getIdUserApp() != null) {
            System.out.println(pacienteUserView.getPacienteVIew().getIdUsuario() + "-" + pacienteUserView.getUserAppView().getIdUserApp().longValue());
            if (pacienteUserView.getPacienteVIew().getIdUsuario() == pacienteUserView.getUserAppView().getIdUserApp().longValue() ?
               (pacienteUserView.getPacienteVIew().getIdPaciente() != null && !pacienteUserView.getPacienteVIew().getIdPaciente().isEmpty()) :
               false) {
               logger.info("===>>>updatePacienteUserView() - ACTUALIZANDO PACIENTE {} y USUARIO {}", pacienteUserView.getPacienteVIew().getIdPaciente(), pacienteUserView.getUserAppView().getIdUserApp());
               //////////////los datos por default
               PacienteView pacienteView = pacienteUserView.getPacienteVIew();
               UserAppView userAppView = pacienteUserView.getUserAppView();
               userAppView.setUsername(pacienteView.getUserName());
               userAppView.setEmail(pacienteView.getEmail());
               userAppView.setName(pacienteView.getNombre() + " " + pacienteView.getApellidoPaterno() + " "
                  + pacienteView.getApellidoMaterno());
               userAppView.setStatus("ACTIVO");
               userAppView.setProfileId(27L);
               userAppView.setIdTipoUsuario(3);
               List<Long> tempo = new ArrayList<>();
               tempo.add(2L);
               // Sre03072020 Inicia En update acá no tengo porqué cambiar los grupos del paciente!:
               //userAppView.setGroupList(tempo);
               // Sre03072020 Termina
               ProfileView profileView = profileRest.findProfile(27L);
               List<Long> idPermissionsList = new ArrayList<>();
               for (NodeTree node : profileView.getTree()) {
                  for (NodeTree children : node.getChildren()) {
                     if (children.getActive()) {
                        idPermissionsList.add(children.getId());
                     }
                  }
               }
               userAppView.setPermissionsList(idPermissionsList);
               pacienteView.setIdUsuario(userAppView.getIdUserApp());
               pacienteView.setUserName(userAppView.getUsername());
               //////////////los datos por default
               userAppRest.updateUserApp(pacienteUserView.getUserAppView().getIdUserApp(), pacienteUserView.getUserAppView());
               return pacienteRest.updatePaciente(pacienteUserView.getPacienteVIew().getIdPaciente(), pacienteUserView.getPacienteVIew());
            } else {
               return null;
            }
         } else {
            return null;
         }

      } catch (Exception ex) {
         logger.error("===>>>updatePacienteUserView() - ocurrio un error al Actualizar al PACIENTE y el USUARIO -{}", ex);
         MedicoCompositeException mcE = new MedicoCompositeException("Error en nuevo USUARIO", MedicoCompositeException.LAYER_REST, MedicoCompositeException.ACTION_INSERT);
         mcE.addError("No se pudo actualizar el  USUARIO: " + apiErrorDecoder.toString().replace('\"', ' '));
         throw mcE;
      }
   }

   @DeleteMapping("rollback/user")
   public void deletePaciente(@RequestParam Long idUsuario) throws PacienteException {
      logger.info("Haciendo rollback en usuarios");
      userAppRest.deleteRollBack(idUsuario);
      logger.info("Haciendo rollback en pacientes");
      pacienteRest.deleteRollback(idUsuario);
      logger.info("Rollback terminado");
   }
}