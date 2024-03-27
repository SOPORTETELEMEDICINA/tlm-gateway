package net.amentum.niomedic.niogateway.api.rest;

import net.amentum.common.BaseController;
import net.amentum.niomedic.medicos.views.MedicoView;
import net.amentum.niomedic.niogateway.api.rest.medicos.MedicosRest;
import net.amentum.niomedic.niogateway.api.rest.security.ProfileRest;
import net.amentum.niomedic.niogateway.api.rest.security.UserAppRest;
import net.amentum.niomedic.niogateway.api.rest.views.security.NodeTree;
import net.amentum.niomedic.niogateway.api.rest.views.security.ProfileView;
import net.amentum.niomedic.niogateway.api.rest.views.security.UserAppPageView;
import net.amentum.niomedic.niogateway.api.rest.views.security.UserAppView;
import net.amentum.niomedic.niogateway.exception.ApiErrorDecoder;
import net.amentum.niomedic.niogateway.exception.MedicoCompositeException;
import net.amentum.niomedic.niogateway.views.MedicoUserView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("medico-usuario")
public class MedicoCompositeRest extends BaseController {
   private final Logger logger = LoggerFactory.getLogger(MedicoCompositeRest.class);

   @Autowired
   private ApiErrorDecoder apiErrorDecoder;

   @Autowired
   private MedicosRest medicosRest;

   @Autowired
   private UserAppRest userAppRest;

   @Autowired
   private ProfileRest profileRest;

   @PostMapping
   public MedicoView createMedicoUsuario(@RequestBody @Validated MedicoUserView medicoUserView) throws MedicoCompositeException {
      boolean bandera = true;
      MedicoView medicoView = medicoUserView.getMedicoView();
      UserAppView userAppView = medicoUserView.getUserAppView();
      userAppView.setUsername(medicoView.getUserName());
      userAppView.setEmail(medicoView.getEmail());
      userAppView.setName(medicoView.getNombre() + " " + medicoView.getApellidoPaterno() + " " + medicoView.getApellidoMaterno());
      userAppView.setStatus("ACTIVO");
      userAppView.setProfileId(26L);
      userAppView.setIdTipoUsuario(2);
      logger.info("Grupos recibidos - {}", userAppView.getGroupList());
      if(userAppView.getGroupList() == null || userAppView.getGroupList().isEmpty()) {
         List<Long> tempo = new ArrayList<>();
         tempo.add(1L);
         userAppView.setGroupList(tempo);
         logger.info("Se añade grupo por default - {}", userAppView.getGroupList());
      }
      try {
         logger.info("===>>>createMedicoUsuario() -  Obteniendo lista de permisos para el perfil MEDICO");
         ProfileView profileView = profileRest.findProfile(26L);
         List<Long> idPermissionsList = new ArrayList<>();
         for (NodeTree node : profileView.getTree()) {
            for (NodeTree children : node.getChildren()) {
               if (children.getActive()) {
                  idPermissionsList.add(children.getId());
               }
            }
         }
         logger.info("===>>>createMedicoUsuario() - Asignando permisos:{}", idPermissionsList);
         userAppView.setPermissionsList(idPermissionsList);
         logger.info("===>>>createMedicoUsuario() - Guardando nuevo USUARIO: {}", userAppView);
         UserAppPageView userAppPageView = userAppRest.createUserApp(userAppView);
         medicoView.setIdUsuario(userAppPageView.getIdUserApp());
         medicoView.setUserName(userAppPageView.getUsername());
         logger.info("===>>>createMedicoUsuario() - El nuevo USUARIO es: {}", userAppPageView);
      } catch (Exception ex) {
         logger.error("===>>>createMedicoUsuario() - No se pudo insertar el nuevo USUARIO: {}", userAppView);
         bandera = false;
         MedicoCompositeException mcE = new MedicoCompositeException("Error en nuevo USUARIO", MedicoCompositeException.LAYER_REST, MedicoCompositeException.ACTION_INSERT);
         mcE.addError("No se pudo insertar el nuevo USUARIO: " + apiErrorDecoder.toString().replace('\"', ' ').replace('\n', ' '));
         throw mcE;
      }
      if (bandera) {
         MedicoView resultado = null;
         try {
            logger.info("===>>>createMedicoUsuario() - Guardando nuevo MEDICO: {}", medicoView);
            resultado = medicosRest.createdMedico(medicoView);
            // Sre03072020 Inicia Ahora tengo que actualizar los grupos del medico
            medicosRest.updateMedicoGroups(medicoView.getIdUsuario(), userAppView.getGroupList());
            // Sre03072020 Termina
         } catch (Exception ex) {
            logger.error("===>>>createMedicoUsuario() - No se pudo crear el MEDICO, idUsuario: {}", medicoView.getIdUsuario());
            userAppRest.deleteRollBack(medicoView.getIdUsuario());
            MedicoCompositeException mcE = new MedicoCompositeException("Error en nuevo MEDICO", MedicoCompositeException.LAYER_REST, MedicoCompositeException.ACTION_INSERT);
            mcE.addError("No se pudo insertar el nuevo MEDICO: " + apiErrorDecoder.toString().replace('\"', ' ').replace('\n', ' '));
            throw mcE;
         }
         return resultado;
      } else {
         return null;
      }
   }

   @GetMapping("{idUsuario}")
   public MedicoUserView getMedicoUsuario(@PathVariable("idUsuario") Integer idUsuario, @RequestParam(required = false, name = "image") Boolean image) {
      try {
         logger.info("===>>>getMedicoUsuario() - OBTENIENDO la informacion del MEDICO y USUARIO con el IdUser {}", idUsuario);
         MedicoUserView medicoUserView = new MedicoUserView();
         medicoUserView.setMedicoView(medicosRest.getDetailsByIdUsuario(idUsuario));
         medicoUserView.setUserAppView(userAppRest.findById(idUsuario.longValue(), image));
         return medicoUserView;
      } catch (Exception ex) {
         logger.error("===>>>getMedicoUsuario() - ocurrio un error al obtener al MEDICO y el USUARIO -{}", ex);
         throw ex;
      }
   }

   @PutMapping()
   public void updateMedicoUsuario(@RequestBody @Validated MedicoUserView medicoUserView) {
      try {
         if (medicoUserView.getUserAppView().getIdUserApp() != null && medicoUserView.getMedicoView().getIdUsuario() != null) {
            if (medicoUserView.getMedicoView().getIdUsuario().longValue() == medicoUserView.getUserAppView().getIdUserApp().longValue() ?
               (medicoUserView.getMedicoView().getIdMedico() != null && !medicoUserView.getMedicoView().getIdMedico().isEmpty()) :
               false) {
               logger.info("===>>>updateMedicoUsuario() - actualizando MEDICO {} y USUARIO {}", medicoUserView.getMedicoView().getIdMedico(), medicoUserView.getUserAppView().getIdUserApp());
               ///////////////////////los datos por default
               MedicoView medicoView = medicoUserView.getMedicoView();
               UserAppView userAppView = medicoUserView.getUserAppView();

               userAppView.setUsername(medicoView.getUserName());
               userAppView.setEmail(medicoView.getEmail());
               userAppView.setName(medicoView.getNombre() + " " + medicoView.getApellidoPaterno() + " " + medicoView.getApellidoMaterno());
               userAppView.setStatus("ACTIVO");
               userAppView.setProfileId(26L);
               userAppView.setIdTipoUsuario(2);
               List<Long> tempo = new ArrayList<>();
               tempo.add(1L);
               // Sre03072020 Inicia En update acá no tengo porqué cambiar los grupos del paciente!:
               //userAppView.setGroupList(tempo);
               // Sre03072020 Termina
               ProfileView profileView = profileRest.findProfile(26L);
               List<Long> idPermissionsList = new ArrayList<>();
               for (NodeTree node : profileView.getTree()) {
                  for (NodeTree children : node.getChildren()) {
                     if (children.getActive()) {
                        idPermissionsList.add(children.getId());
                     }
                  }
               }
               userAppView.setPermissionsList(idPermissionsList);
               medicoView.setIdUsuario(userAppView.getIdUserApp());
               medicoView.setUserName(userAppView.getUsername());
               ///////////////////////los datos por default

               medicosRest.updateMedico(medicoUserView.getMedicoView().getIdMedico(), medicoUserView.getMedicoView());
               userAppRest.updateUserApp(medicoUserView.getUserAppView().getIdUserApp(), medicoUserView.getUserAppView());
            }
         }
      } catch (Exception ex) {
         logger.error("===>>>updateMedicoUsuario() - ocurrio un error al actualizar al MEDICO y el USUARIO - {}", ex);
         throw ex;
      }
   }
}
