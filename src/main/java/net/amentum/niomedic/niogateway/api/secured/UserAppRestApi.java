package net.amentum.niomedic.niogateway.api.secured;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.security.UserAppRest;
import net.amentum.niomedic.niogateway.api.rest.views.security.FindByGroupsView;
import net.amentum.niomedic.niogateway.api.rest.views.security.FindUsersView;
import net.amentum.niomedic.niogateway.api.rest.views.security.InfoBasicRequestView;
import net.amentum.niomedic.niogateway.api.rest.views.security.InfoBasicResponseView;
import net.amentum.niomedic.niogateway.api.rest.views.security.UserAppPageView;
import net.amentum.niomedic.niogateway.api.rest.views.security.UserAppView;
import net.amentum.niomedic.niogateway.api.rest.views.security.UserAssignedRequestView;
import net.amentum.niomedic.niogateway.api.rest.views.security.UserRequestView;
import net.amentum.niomedic.niogateway.api.rest.views.security.UsersAssignedView;
import net.amentum.niomedic.pacientes.exceptions.PacienteException;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Map;

import net.amentum.niomedic.niogateway.api.rest.medicos.MedicosRest; // Sre19062020 Nuevo
import net.amentum.niomedic.niogateway.api.rest.pacientes.PacienteRest; // Sre19062020 Nuevo

@RestController
@RequestMapping("users")
public class UserAppRestApi extends BaseController {

   @Autowired
   private UserAppRest userAppRest;

    // Sre19062020 Se agrega medicosRest para actualizar grupos:
   @Autowired
   private MedicosRest medicosRest;

    // Sre19062020 Se agrega pacientesRest para actualizar grupos
   @Autowired
   private PacienteRest pacienteRest;
   
   @Autowired
   private SecurityHandlerProvider securityHandlerProvider;

   private final Logger logger = LoggerFactory.getLogger(UserAppRestApi.class);

   @PostMapping
   void createUserApp(@RequestBody @Validated UserAppView userAppView) {
      this.userAppRest.createUserApp(userAppView);
   }

   @PutMapping("{idUserApp}")
   void updateUserApp(@PathVariable("idUserApp") Long idUserApp, @RequestBody @Validated UserAppView userAppView) throws PacienteException {
        this.userAppRest.updateUserApp(idUserApp, userAppView);
        // Sre19062020 Inicia ya que se actualizó el usuario, ahora propago a medicos y pacientes sus grupos
        // userAppView.getIdTipoUsuario().getIdTipoUsuario() me dice si es medico(2) o paciente(3)
        // userAppView.getGroupList List<Long> me da los grupos
        // ACA Si es medico, mando grabar sus grupos a nio-medicos
        // Si es paciente mando grabar sus grupos a nio-pacientes
        if (userAppView.getIdTipoUsuario() == 2) { // Medico
            medicosRest.updateMedicoGroups(idUserApp, userAppView.getGroupList());
        } else if (userAppView.getIdTipoUsuario() == 3) { // Paciente
            pacienteRest.updatePacienteGroups(idUserApp, userAppView.getGroupList());
        }
        // Sre19062020 Termina 
   }

   @PutMapping("{idUserApp}/movil")
   void updateUserAppFromMovil(@PathVariable("idUserApp") Long idUserApp, @RequestBody @Validated UserAppView userAppView){
      this.userAppRest.updateUserAppFromMovil(idUserApp, userAppView);
   }


   @PostMapping("list")
   Page<UserAppPageView> getPage(@RequestBody FindUsersView view, HttpServletRequest request) throws Exception {
      String decrypted = securityHandlerProvider.decryptHeader(request);
       // Sre22052020 Inicia Si el usuario es admin tipo_usuario=1 entonces mandamos lista en null
       String strTipoUser = securityHandlerProvider.getName("TU",decrypted);
       if ("1".equals(strTipoUser)) {
            view.setIdUsersList(null);
       } else {
            view.setIdUsersList(securityHandlerProvider.getHierarchy("UA",decrypted));
       }
       // Sre22052020 Termina
      return this.userAppRest.getPage(view);
   }

   @GetMapping("{idUserApp}")
   UserAppView findById(@PathVariable("idUserApp") Long idUserApp, @RequestParam(required = false, name = "image")Boolean image){
      return this.userAppRest.findById(idUserApp, image);
   }

   @DeleteMapping( "{idUserApp}")
   void deleteUserApp(@PathVariable("idUserApp") Long idUserApp){
      this.userAppRest.deleteUserApp(idUserApp);
   }

   @PostMapping( "secure/logout")
   void logout(){
      this.userAppRest.logout();
   }

   @PostMapping("findByGroups")
   List<UserAppView> findByGroups(HttpServletRequest request) throws Exception{
      FindByGroupsView view = new FindByGroupsView();
      String decrypted = securityHandlerProvider.decryptHeader(request);
      view.setGroups(securityHandlerProvider.getHierarchy("G",decrypted));
      view.setIdUsers(securityHandlerProvider.getHierarchy("UA",decrypted));
      return this.userAppRest.findByGroups(view);
   }

   @PostMapping("search")
   Page<UserAppPageView> SearchUsersByGroups(@RequestBody @Validated UserRequestView view, HttpServletRequest request) throws Exception{
      String decrypted = securityHandlerProvider.decryptHeader(request);
      view.setIdGroups(securityHandlerProvider.getHierarchy("G",decrypted));
      view.setUsers(securityHandlerProvider.getHierarchy("UA",decrypted));
      return this.userAppRest.SearchUsersByGroups(view);
   }

   @PostMapping(value = "assigned")
   List<UsersAssignedView> getUsersAssignedToBoss(@RequestBody UserAssignedRequestView view, HttpServletRequest request) throws Exception {
      String decrypted = securityHandlerProvider.decryptHeader(request);
      view.setIdGroups(securityHandlerProvider.getHierarchy("G",decrypted));
      return this.userAppRest.getUsersAssignedToBoss(view);
   }

   @PostMapping(value = "infoBasicUsers")
   List<InfoBasicResponseView> getInfoBasicUsers(@RequestBody InfoBasicRequestView view, HttpServletRequest request) throws Exception {
      String decrypted = securityHandlerProvider.decryptHeader(request);
      view.setIdUsers(securityHandlerProvider.getHierarchy("UA",decrypted));
      return this.userAppRest.getInfoBasicUsers(view);
   }
   
   // Sre22052020 Agrego método para buscar un usuario por username
   @GetMapping(value = "username/{username}")
   public UserAppView getUserAppByUsername(@PathVariable("username") String username) throws Exception {
       return this.userAppRest.getUserAppByUsername(username);
   }

   // GGR20200709 Agrego método para buscar horario por idUser
   @GetMapping(value = "horario/{idUserApp}")
   public Map<String, Object> getHorarioByIdUser(@PathVariable("idUserApp") Long idUserApp) throws Exception {
      return this.userAppRest.getHorarioByIdUser(idUserApp);
   }
}

