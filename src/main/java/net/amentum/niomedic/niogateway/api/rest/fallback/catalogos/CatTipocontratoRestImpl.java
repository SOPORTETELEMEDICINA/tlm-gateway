package net.amentum.niomedic.niogateway.api.rest.fallback.catalogos;

import net.amentum.niomedic.catalogos.views.CatTipocontratoView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.catalogos.CatTipocontratoRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CatTipocontratoRestImpl extends BaseController implements CatTipocontratoRest {

    private Logger logger = LoggerFactory.getLogger(CatTipocontratoRestImpl.class);

    public CatTipocontratoView getDetailsByconid(Integer conid) {
        logger.error("Error al accesar al servicio para OBTENER POR ID CatTipocontrato {}", conid);
        return null;
    }

    public List<CatTipocontratoView> findAll() {
        logger.error("Error al accesar al servicio para OBTENER TODOS los CatTipocontrato");
        return null;
    }

    public Page<CatTipocontratoView> getCatTipocontratoSearch(String datosBusqueda,
                                                        Integer page,
                                                        Integer size,
                                                        String orderColumn,
                                                        String orderType) {
        logger.error("Error al OBTENER PÁGINA de CatTipocontrato - datosBusqueda: {} - page: {} - size: {} - orderColumn: {} - orderType: {}",
                datosBusqueda, page, size, orderColumn, orderType);
        return null;
    }


}
