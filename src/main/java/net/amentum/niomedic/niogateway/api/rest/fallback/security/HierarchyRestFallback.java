package net.amentum.niomedic.niogateway.api.rest.fallback.security;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.security.HierarchyRest;
import net.amentum.niomedic.niogateway.api.rest.views.security.HierarchyRequestView;
import net.amentum.niomedic.niogateway.api.rest.views.security.ProfileHierarchyView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class HierarchyRestFallback extends BaseController implements HierarchyRest {

   private final Logger logger = LoggerFactory.getLogger(HierarchyRestFallback.class);

   @Override
   public void addOrUpdateHierarchy(HierarchyRequestView hierarchyView) {

   }

   @Override
   public List<ProfileHierarchyView> getHierarchy(Long idPerfilBoss) {
      logger.error("Error la jerarquía: {}", idPerfilBoss);
      return null;
   }
}