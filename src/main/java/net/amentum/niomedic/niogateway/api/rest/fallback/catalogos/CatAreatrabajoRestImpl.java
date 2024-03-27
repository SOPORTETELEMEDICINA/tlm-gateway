package net.amentum.niomedic.niogateway.api.rest.fallback.catalogos;


import net.amentum.niomedic.catalogos.views.CatAreatrabajoView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.catalogos.CatAreatrabajoRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CatAreatrabajoRestImpl extends BaseController implements CatAreatrabajoRest {

    private Logger logger = LoggerFactory.getLogger(CatAreatrabajoRestImpl.class);

    public CatAreatrabajoView getDetailsByatrid(Integer atrid) {
        logger.error("Error al accesar al servicio para OBTENER POR ID CatAreatrabajo {}", atrid);
        return null;
    }

    public List<CatAreatrabajoView> findAll() {
        logger.error("Error al accesar al servicio para OBTENER TODOS los CatAreatrabajo");
        return null;
    }

    public Page<CatAreatrabajoView> getCatAreatrabajoSearch(String datosBusqueda,
                                                        Integer page,
                                                        Integer size,
                                                        String orderColumn,
                                                        String orderType) {
        logger.error("Error al OBTENER PÁGINA de CatAreatrabajo - datosBusqueda: {} - page: {} - size: {} - orderColumn: {} - orderType: {}",
                datosBusqueda, page, size, orderColumn, orderType);
        return null;
    }
}
