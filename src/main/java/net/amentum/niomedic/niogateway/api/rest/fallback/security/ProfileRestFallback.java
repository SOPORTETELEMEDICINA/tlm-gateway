package net.amentum.niomedic.niogateway.api.rest.fallback.security;

//import net.amentum.intouch.gateway.api.rest.BaseController;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.security.ProfileRest;
import net.amentum.niomedic.niogateway.api.rest.views.security.NodeTree;
import net.amentum.niomedic.niogateway.api.rest.views.security.ProfileView;

import java.util.Collection;
import java.util.Collections;

//@Component
public class ProfileRestFallback extends BaseController implements ProfileRest {
   @Override
   public void addProfile(ProfileView profileView) {

   }

   @Override
   public void updateProfile(ProfileView profileView, Long profileId) {

   }

   @Override
   public void deleteProfile(Long profileId) {

   }

   @Override
   public ProfileView findProfile(Long profileId) {
      return null;
   }

   @Override
   public Page<ProfileView> getPage(String name, Integer page, Integer size, String orderColumn, String orderType) {
      return new Page<>();
//      return null;
   }

   @Override
   public Collection<NodeTree> findNodes() {
      return Collections.EMPTY_LIST;
   }

   @Override
   public Collection<ProfileView> findAll() {
      return Collections.EMPTY_LIST;
   }
}
