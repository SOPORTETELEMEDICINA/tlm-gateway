package net.amentum.niomedic.niogateway.api.rest.fallback.catalogos;

import net.amentum.niomedic.catalogos.views.CatInstitucionesView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.catalogos.CatInstitucionesRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CatInstitucionesRestImpl extends BaseController implements CatInstitucionesRest {

    private Logger logger = LoggerFactory.getLogger(CatInstitucionesRestImpl.class);

    public CatInstitucionesView getDetailsByidinstitucion(Integer idinstitucion) {
        logger.error("Error al accesar al servicio para OBTENER POR ID CatInstituciones {}", idinstitucion);
        return null;
    }

    public List<CatInstitucionesView> findAll() {
        logger.error("Error al accesar al servicio para OBTENER TODOS los CatInstituciones");
        return null;
    }

    public Page<CatInstitucionesView> getCatInstitucionesSearch(String datosBusqueda,
                                                        Integer page,
                                                        Integer size,
                                                        String orderColumn,
                                                        String orderType) {
        logger.error("Error al OBTENER PÁGINA de CatInstituciones - datosBusqueda: {} - page: {} - size: {} - orderColumn: {} - orderType: {}",
                datosBusqueda, page, size, orderColumn, orderType);
        return null;
    }

}
