package net.amentum.niomedic.niogateway.api.rest.fallback.security;

import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.security.UserAppRest;
import net.amentum.niomedic.niogateway.api.rest.views.security.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class UserAppRestFallback implements UserAppRest {

   private final Logger logger = LoggerFactory.getLogger(UserAppRestFallback.class);

   @Override
   public UserAppPageView createUserApp(UserAppView userAppView) {
      return null;
   }

   @Override
   public void updateUserApp(Long idUserApp, UserAppView userAppView) {

   }

   @Override
   public void updateUserAppFromMovil(Long idUserApp, UserAppView userAppView) {

   }

   @Override
   public Page<UserAppPageView> getPage(FindUsersView view) {
//      return new PageImpl<>();
      return null;
   }

   @Override
   public UserAppView findById(Long idUserApp, Boolean image) {
      logger.error("Error al seleccionar usuario: {}", idUserApp);
      return null;
   }

   @Override
   public void deleteUserApp(Long idUserApp) {

   }

   @Override
   public void logout() {

   }

   @Override
   public List<UserAppView> findByGroups(FindByGroupsView view) {
      return Collections.emptyList();
   }

   @Override
   public Page<UserAppPageView> SearchUsersByGroups(UserRequestView view) {
      return new Page<>();
//      return null;
   }

   @Override
   public List<UsersAssignedView> getUsersAssignedToBoss(UserAssignedRequestView view) {
      return null;
   }

   @Override
   public List<InfoBasicResponseView> getInfoBasicUsers(InfoBasicRequestView view) {
      return null;
   }

   @Override
   public void deleteRollBack(Long idUserApp) {

   }
   
   // Sre22052020 Agrego método para buscar un usuario por username
   @Override
   public UserAppView getUserAppByUsername(String username) {
       return null;
   }

   // GGR20200709 Agrego método para buscar horario por idUser
   @Override
   public Map<String, Object> getHorarioByIdUser(Long idUserApp) {
      logger.info("----- Estoy Fallando al pedir horario-----");
      return null;
   }
}

