package net.amentum.niomedic.niogateway.api.rest.fallback.security;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.security.ModuleRest;
import net.amentum.niomedic.niogateway.api.rest.views.security.ModuleView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Component
public class ModuleRestFallback extends BaseController implements ModuleRest {

   private final Logger logger = LoggerFactory.getLogger(ModuleRestFallback.class);

   @Override
   public void addModule(ModuleView moduleView) {
      logger.error("Error al acceder a servicio para agregar módulo - {}", moduleView);
   }

   @Override
   public void updateModule(ModuleView moduleView, Long moduleId) {
      logger.error("Error al acceder a servicio para actualizar módulo - {}", moduleView);
   }

   @Override
   public void deleteModule(Long moduleId) {
      logger.error("Error al acceder a servicio para eliminar módulo - {}", moduleId);
   }

   @Override
   public ModuleView findModuleById(Long moduleId) {
      logger.error("Error al acceder a servicio para obtener módulo - {}", moduleId);
      return null;
   }

   @Override
   public Page<ModuleView> getPage(String name, Integer page, Integer size, String orderColumn, String orderType) {
      logger.error("Error al acceder a servicio para obtener módulos - name: {} - page: {} - size: {} - orderColumn: {} - orderType_ {}",
         name, page, size, orderColumn, orderType);
      return new Page<>();
//      return null;
   }
}
