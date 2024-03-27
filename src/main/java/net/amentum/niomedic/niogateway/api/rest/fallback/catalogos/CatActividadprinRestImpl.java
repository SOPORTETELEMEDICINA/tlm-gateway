package net.amentum.niomedic.niogateway.api.rest.fallback.catalogos;

import net.amentum.niomedic.catalogos.views.CatActividadprinView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.catalogos.CatActividadprinRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class CatActividadprinRestImpl extends BaseController implements CatActividadprinRest {

    private Logger logger = LoggerFactory.getLogger(CatActividadprinRestImpl.class);

    public CatActividadprinView getDetailsByactid(Integer actid) {
        logger.error("Error al accesar al servicio para OBTENER POR ID CatActividadprin {}", actid);
        return null;
    }

    public List<CatActividadprinView> findAll() {
        logger.error("Error al accesar al servicio para OBTENER TODOS los CatActividadprin");
        return null;
    }

    public Page<CatActividadprinView> getCatActividadprinSearch(String datosBusqueda,
                                                        Integer page,
                                                        Integer size,
                                                        String orderColumn,
                                                        String orderType) {
        logger.error("Error al OBTENER PÁGINA de CatActividadprin - datosBusqueda: {} - page: {} - size: {} - orderColumn: {} - orderType: {}",
                datosBusqueda, page, size, orderColumn, orderType);
        return null;
    }
    
}
