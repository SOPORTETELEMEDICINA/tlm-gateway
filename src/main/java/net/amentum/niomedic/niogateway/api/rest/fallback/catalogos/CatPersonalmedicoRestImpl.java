package net.amentum.niomedic.niogateway.api.rest.fallback.catalogos;

import net.amentum.niomedic.catalogos.views.CatPersonalmedicoView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.catalogos.CatPersonalmedicoRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CatPersonalmedicoRestImpl extends BaseController implements CatPersonalmedicoRest {

    private Logger logger = LoggerFactory.getLogger(CatPersonalmedicoRestImpl.class);

    public CatPersonalmedicoView getDetailsByperid(Integer perid) {
        logger.error("Error al accesar al servicio para OBTENER POR ID CatPersonalmedico {}", perid);
        return null;
    }

    public List<CatPersonalmedicoView> findAll() {
        logger.error("Error al accesar al servicio para OBTENER TODOS los CatPersonalmedico");
        return null;
    }

    public Page<CatPersonalmedicoView> getCatPersonalmedicoSearch(String datosBusqueda,
                                                        Integer page,
                                                        Integer size,
                                                        String orderColumn,
                                                        String orderType) {
        logger.error("Error al OBTENER PÁGINA de CatPersonalmedico - datosBusqueda: {} - page: {} - size: {} - orderColumn: {} - orderType: {}",
                datosBusqueda, page, size, orderColumn, orderType);
        return null;
    }

}
