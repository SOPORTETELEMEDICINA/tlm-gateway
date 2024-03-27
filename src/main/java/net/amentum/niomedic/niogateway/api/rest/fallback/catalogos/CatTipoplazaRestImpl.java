package net.amentum.niomedic.niogateway.api.rest.fallback.catalogos;

import net.amentum.niomedic.catalogos.views.CatTipoplazaView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.catalogos.CatTipoplazaRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CatTipoplazaRestImpl extends BaseController implements CatTipoplazaRest {

    private Logger logger = LoggerFactory.getLogger(CatTipoplazaRestImpl.class);

    public CatTipoplazaView getDetailsByplaid(Integer plaid) {
        logger.error("Error al accesar al servicio para OBTENER POR ID CatTipoplaza {}", plaid);
        return null;
    }

    public List<CatTipoplazaView> findAll() {
        logger.error("Error al accesar al servicio para OBTENER TODOS los CatTipoplaza");
        return null;
    }

    public Page<CatTipoplazaView> getCatTipoplazaSearch(String datosBusqueda,
                                                        Integer page,
                                                        Integer size,
                                                        String orderColumn,
                                                        String orderType) {
        logger.error("Error al OBTENER PÁGINA de CatTipoplaza - datosBusqueda: {} - page: {} - size: {} - orderColumn: {} - orderType: {}",
                datosBusqueda, page, size, orderColumn, orderType);
        return null;
    }
}
