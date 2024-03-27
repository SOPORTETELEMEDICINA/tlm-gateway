package net.amentum.niomedic.niogateway.api.rest.fallback.security;

//import net.amentum.intouch.gateway.api.rest.BaseController;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.security.OauthDetailRest;
import net.amentum.niomedic.niogateway.api.rest.views.security.OauthClientDetailsView;

//@Component
public class OauthDetailRestFallback extends BaseController implements OauthDetailRest {

   @Override
   public void addCredential(OauthClientDetailsView detailsView) {

   }

   @Override
   public void updateCredential(Long id, OauthClientDetailsView detailsView) {

   }

   @Override
   public OauthClientDetailsView findById(Long id) {
      return null;
   }

   @Override
   public Page<OauthClientDetailsView> findPage(String name, Integer page, Integer size, String orderColumn, String orderType) {
      return new Page<>();
//      return null;
   }

   @Override
   public void deleteCredential(Long id) {

   }
}