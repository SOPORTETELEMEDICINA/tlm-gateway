package net.amentum.niomedic.niogateway.api.rest;

import net.amentum.niomedic.niogateway.api.rest.pacientes.PacienteRest;
import net.amentum.niomedic.niogateway.api.rest.pacientes.ServiciosRest;
import net.amentum.niomedic.niogateway.api.rest.security.NewUserRest;
import net.amentum.niomedic.niogateway.api.rest.security.UserAppRest;
import net.amentum.niomedic.niogateway.api.rest.views.security.*;
import net.amentum.niomedic.niogateway.exception.ApiErrorDecoder;
import net.amentum.niomedic.niogateway.exception.MedicoCompositeException;
import net.amentum.niomedic.niogateway.exception.RestException;
import net.amentum.niomedic.niogateway.views.PacienteUserView;
import net.amentum.niomedic.pacientes.views.PacienteView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("create-new-user")
public class NewUserCompositeRest {

    private final Logger logger = LoggerFactory.getLogger(NewUserCompositeRest.class);

    @Autowired
    private ApiErrorDecoder apiErrorDecoder;

    @Autowired
    private PacienteRest pacienteRest;

    @Autowired
    private UserAppRest userAppRest;

    @Autowired
    private NewUserRest newUserRest;

    @Autowired
    private ServiciosRest serviciosRest;

    @GetMapping(value = "link")
    public NewUserView verifyLink(@RequestParam(name = "hash") String hash) throws MedicoCompositeException {
        NewUserView view = null;
        logger.info("Hash recibido - {}", hash);
        if(newUserRest.verifyLink(hash)) {
            NewUser newUser = newUserRest.findByHash(hash);
            logger.info("Usuario por hash - {}", newUser.toString());
            view = new NewUserView();
            view.setIdUsuario(newUser.getidUsuario());
            view.setIdGroup(newUser.getIdGroup());
            view.setNombre(newUser.getName());
            return view;
        } else {
            logger.error("El link ha expirado");
            MedicoCompositeException mcE = new MedicoCompositeException("Link no valido", MedicoCompositeException.LAYER_REST, MedicoCompositeException.ACTION_SELECT);
            mcE.addError("El link ha expirado");
            throw mcE;
        }
    }

    @PostMapping
    public PacienteView createNewUser(@RequestBody @Validated PacienteUserView pacienteUserVIew) throws MedicoCompositeException {
        boolean bandera = true;
        PacienteView pacienteView = pacienteUserVIew.getPacienteVIew();
        UserAppView userAppView = pacienteUserVIew.getUserAppView();
        userAppView.setUsername(pacienteView.getUserName());
        userAppView.setEmail(pacienteView.getEmail());
        userAppView.setName(pacienteView.getNombre() + " " + pacienteView.getApellidoPaterno() + " " + pacienteView.getApellidoMaterno());
        userAppView.setStatus("ACTIVO");
        userAppView.setProfileId(27L);
        userAppView.setIdTipoUsuario(3);
        logger.info("View del user - {}", userAppView);
        List<Long> tempo = new ArrayList<>();
        if (pacienteUserVIew.getSelectedGroup() != null && pacienteUserVIew.getSelectedGroup() > 0L)
            tempo.add(pacienteUserVIew.getSelectedGroup());
        else
            tempo.add(2L);
        userAppView.setGroupList(tempo);
        try {
            logger.info("===>>>createNewUser() -  Obteniendo lista de permisos para el perfil PACIENTE");
            List<Long> idPermissionsList = new ArrayList<>();
            idPermissionsList.add(49L);
            idPermissionsList.add(105L);
            logger.info("===>>>createNewUser() - Asignando permisos:{}", idPermissionsList);
            userAppView.setPermissionsList(idPermissionsList);
            logger.info("===>>>createNewUser() - Guardando nuevo USUARIO: {}", userAppView);
            UserAppPageView userAppPageView = userAppRest.createUserApp(userAppView);
            pacienteView.setIdUsuario(userAppPageView.getIdUserApp());
            pacienteView.setUserName(userAppPageView.getUsername());
            logger.info("===>>>createNewUser() - El nuevo USUARIO es: {}", userAppPageView);
        } catch (Exception ex) {
            String messageError = "Error en nuevo PACIENTE: " + ex.getCause();
            logger.error("===>>>createNewUser() - No se pudo insertar el nuevo USUARIO: {} - Error - {}", userAppView, ex);
            logger.error("===>>>createNewUser() " + messageError);
            if(ex.getCause() instanceof RestException) {
                RestException exception = (RestException) ex.getCause();
                messageError = "Error - " + exception.getErrorList().toString();
                logger.error("===>>>createNewUser() " + messageError);
            }
            bandera = false;
            MedicoCompositeException mcE = new MedicoCompositeException(messageError, MedicoCompositeException.LAYER_REST, MedicoCompositeException.ACTION_INSERT);
            mcE.addError("No se pudo insertar el nuevo USUARIO: " + ex.getCause());
            throw mcE;
        }
        if (bandera) {
            PacienteView resultado;
            try {
                if(pacienteView.getFechaNacimiento() == null)
                    pacienteView.setFechaNacimiento(new Date());
                logger.info("===>>>createNewUser() - Guardando nuevo PACIENTE: {}", pacienteView);
                resultado = pacienteRest.createPaciente(pacienteView);
                logger.info("===>>>createNewUser() - Resultado de PACIENTE: {}", resultado);
                pacienteRest.updatePacienteGroups(pacienteView.getIdUsuario(), userAppView.getGroupList());
                logger.info("TERMINADO");
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
                String messageError = "Error en nuevo PACIENTE: " + ex.getCause();
                logger.error("===>>>createNewUser() - No se pudo crear el PACIENTE, idUsuario: " + pacienteView.getIdUsuario() + " - Error: " + ex);
                logger.error("===>>>createNewUser() " + messageError);
                if(ex.getCause() instanceof RestException) {
                    RestException exception = (RestException) ex.getCause();
                    messageError = "Error - " + exception.getErrorList().toString();
                    logger.error("===>>>createNewUser() " + messageError);
                }
                userAppRest.deleteRollBack(pacienteView.getIdUsuario());
                MedicoCompositeException mcE = new MedicoCompositeException(messageError, MedicoCompositeException.LAYER_REST, MedicoCompositeException.ACTION_INSERT);
                mcE.addError("No se pudo insertar el nuevo PACIENTE: " + ex.getCause());
                throw mcE;
            }
            return resultado;
        } else {
            return null;
        }
    }
}