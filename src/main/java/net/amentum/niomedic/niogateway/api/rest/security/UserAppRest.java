package net.amentum.niomedic.niogateway.api.rest.security;

import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.security.UserAppRestFallback;
import net.amentum.niomedic.niogateway.api.rest.views.security.*;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

//@RestController
@FeignClient(value = "http://nio-security", fallback = UserAppRestFallback.class)
public interface UserAppRest {

//   @PostMapping("users")
//   void createUserApp(@RequestBody @Validated UserAppView userAppView);
   @PostMapping("users")
   UserAppPageView createUserApp(@RequestBody @Validated UserAppView userAppView);

   @PutMapping("users/{idUserApp}")
   void updateUserApp(@PathVariable("idUserApp") Long idUserApp, @RequestBody @Validated UserAppView userAppView);

   @PutMapping("users/{idUserApp}/movil")
   void updateUserAppFromMovil(@PathVariable("idUserApp") Long idUserApp, @RequestBody @Validated UserAppView userAppView);

   @PostMapping("users/list")
   Page<UserAppPageView> getPage(@RequestBody FindUsersView view);

   @GetMapping("users/{idUserApp}")
   UserAppView findById(@PathVariable("idUserApp") Long idUserApp, @RequestParam(required = false, name = "image") Boolean image);

   @DeleteMapping("users/{idUserApp}/{motivo}")
   void deleteUserApp(@PathVariable("idUserApp") Long idUserApp, @PathVariable("motivo") String motivo);

   @PostMapping("users/secure/logout")
   void logout();

   @PostMapping("users/findByGroups")
   List<UserAppView> findByGroups(@RequestBody() FindByGroupsView view);

   @PostMapping("users/search")
   Page<UserAppPageView> SearchUsersByGroups(@RequestBody @Validated UserRequestView view);

   @PostMapping(value = "users/assigned")
   List<UsersAssignedView> getUsersAssignedToBoss(@RequestBody UserAssignedRequestView view);

   @PostMapping(value = "users/infoBasicUsers")
   List<InfoBasicResponseView> getInfoBasicUsers(@RequestBody InfoBasicRequestView view);

   @DeleteMapping("users/rollback/{idUserApp}")
   void deleteRollBack(@PathVariable("idUserApp") Long idUserApp);
   
   // Sre22052020 Agrego método para buscar un usuario por username
   @GetMapping(value = "users/username/{username}")
   UserAppView getUserAppByUsername(@PathVariable("username") String username);

   // GGR20200709 Agrego método para buscar horario por idUser
   @GetMapping("users/horario/{idUserApp}")
   Map<String, Object> getHorarioByIdUser(@PathVariable("idUserApp") Long idUserApp);

}
