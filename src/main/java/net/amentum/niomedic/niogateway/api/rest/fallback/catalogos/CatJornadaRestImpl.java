package net.amentum.niomedic.niogateway.api.rest.fallback.catalogos;

import net.amentum.niomedic.catalogos.views.CatJornadaView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.catalogos.CatJornadaRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CatJornadaRestImpl extends BaseController implements CatJornadaRest {

    private Logger logger = LoggerFactory.getLogger(CatJornadaRestImpl.class);

    public CatJornadaView getDetailsByjorid(Integer jorid) {
        logger.error("Error al accesar al servicio para OBTENER POR ID CatJornada {}", jorid);
        return null;
    }

    public List<CatJornadaView> findAll() {
        logger.error("Error al accesar al servicio para OBTENER TODOS los CatJornada");
        return null;
    }

    public Page<CatJornadaView> getCatJornadaSearch(String datosBusqueda,
                                                        Integer page,
                                                        Integer size,
                                                        String orderColumn,
                                                        String orderType) {
        logger.error("Error al OBTENER PÁGINA de CatJornada - datosBusqueda: {} - page: {} - size: {} - orderColumn: {} - orderType: {}",
                datosBusqueda, page, size, orderColumn, orderType);
        return null;
    }
}
