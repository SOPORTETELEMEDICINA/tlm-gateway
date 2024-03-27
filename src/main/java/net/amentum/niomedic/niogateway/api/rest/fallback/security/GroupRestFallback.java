package net.amentum.niomedic.niogateway.api.rest.fallback.security;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.security.GroupRest;
import net.amentum.niomedic.niogateway.api.rest.views.security.GroupView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Collections;

//@Component
public class GroupRestFallback extends BaseController implements GroupRest {

   private final Logger logger = LoggerFactory.getLogger(GroupRestFallback.class);

   @Override
   public GroupView findGroup(Long groupId) {
      logger.error("Error al obtener grupo utilizando ID: {}", groupId);
      return null;
   }

   @Override
   public Page<GroupView> findPage(Boolean active, String name, Integer page, Integer size, String orderColumn, String orderType) {
      logger.error("Error al obtener pagina de grupo - active: {} - name: {} - page: {} - size: {} order: {} - orderType: {}",
         active, name, page, size, orderColumn, orderType);
      return new Page<GroupView>();
//      return new PageImpl<GroupView>();
//      return null;
   }

   @Override
   public Collection<GroupView> findAll(Boolean active) {
      logger.error("Error al obtener lista de grupos - active: {} ", active);
      return Collections.EMPTY_LIST;
   }

   @Override
   public void addGroup(GroupView view) {
      logger.error("Error al accesar a servicio para agregar grupo: {}", view);
   }

   @Override
   public void updateGroup(GroupView view, Long groupId) {
      logger.error("Error al accesar a servicio para editar grupo: {}", view);
   }

   @Override
   public void deleteGroup(Long groupId) {
      logger.error("Error al accesar a servicio para eliminar grupo: {}", groupId);
   }
}
