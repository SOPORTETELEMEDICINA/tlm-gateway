package net.amentum.niomedic.niogateway.api.rest.fallback.security;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.security.GroupCrudRest;
import net.amentum.niomedic.niogateway.api.rest.views.security.GroupCrudView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Collections;

public class GroupCrudRestFallback extends BaseController implements GroupCrudRest {

    private final Logger logger = LoggerFactory.getLogger(GroupCrudRestFallback.class);

    @Override
    public void addGroup(GroupCrudView group) {
        logger.error("Error al accesar a servicio para agregar grupo: {}", group
        );
    }

    @Override
    public void editGroup(GroupCrudView group, Long groupCrudId) {
        logger.error("Error al accesar a servicio para editar grupo: {}", group);
    }

    @Override
    public void deleteGroup(Long groupCrudId) {
        logger.error("Error al accesar a servicio para eliminar grupo: {}", groupCrudId);
    }

    @Override
    public Page<GroupCrudView> findPage(Integer gid, Integer page, Integer size, String orderColumn, String orderType) {
        logger.error("Error al obtener pagina de grupo - gid: {} - page: {} - size: {} order: {} - orderType: {}",
                gid, page, size, orderColumn, orderType);
        return new Page<GroupCrudView>();
    }

    @Override
    public Collection<GroupCrudView> findAll() {
        logger.error("Error al obtener lista de grupos");
        return Collections.emptyList();
    }

    @Override
    public String findImageGroupCrud(Integer gid, String color) {
        logger.error("Error al accesar a servicio para eliminar grupo: {}", gid);
        return "";
    }

    @Override
    public GroupCrudView findGroup(Long groupCrudId) {
        logger.error("Error al obtener grupo utilizando ID: {}", groupCrudId);
        return null;
    }
}
