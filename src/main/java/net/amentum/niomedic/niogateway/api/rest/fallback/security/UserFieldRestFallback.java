package net.amentum.niomedic.niogateway.api.rest.fallback.security;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.security.UserFieldRest;
import net.amentum.niomedic.niogateway.api.rest.views.security.ExtraFieldView;

import java.util.Collection;
import java.util.Collections;

public class UserFieldRestFallback extends BaseController implements UserFieldRest {
   @Override
   public Page<ExtraFieldView> findPage(String search, Long profileId, String legend, String date1, String date2, Boolean general, String columnOrder, String order, Integer page, Integer size) {
      return null;
   }

   @Override
   public void addNewField(ExtraFieldView view) {

   }

   @Override
   public void updateField(ExtraFieldView view, Long fieldId) {

   }

   @Override
   public void deleteField(Long fieldId) {

   }

   @Override
   public ExtraFieldView findById(Long fieldId) {
      return null;
   }

   @Override
   public Collection<ExtraFieldView> findProfileAndActive(Long profileId, Boolean active) {
      return Collections.EMPTY_LIST;
   }
}

