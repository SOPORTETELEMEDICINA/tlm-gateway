package net.amentum.niomedic.niogateway.api.rest.fallback.catalogos;

import net.amentum.niomedic.catalogos.views.CatCluesView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.catalogos.CatCluesRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CatCluesRestImpl extends BaseController implements CatCluesRest {

    private Logger logger = LoggerFactory.getLogger(CatCluesRestImpl.class);

    public CatCluesView getDetailsByidCatClues(Integer idCatClues) {
        logger.error("Error al accesar al servicio para OBTENER POR ID CatClues {}", idCatClues);
        return null;
    }

    public List<CatCluesView> findAll() {
        logger.error("Error al accesar al servicio para OBTENER TODOS los CatClues");
        return null;
    }

    public Page<CatCluesView> getCatCluesSearch(String datosBusqueda,
                                                        Integer page,
                                                        Integer size,
                                                        String orderColumn,
                                                        String orderType) {
        logger.error("Error al OBTENER PÁGINA de CatClues - datosBusqueda: {} - page: {} - size: {} - orderColumn: {} - orderType: {}",
                datosBusqueda, page, size, orderColumn, orderType);
        return null;
    }

}
