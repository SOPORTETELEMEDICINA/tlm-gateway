package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;

import net.amentum.niomedic.expediente.views.CatCuestionarioView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.expediente.CatCuestionarioRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CatCuestionarioRestImpl extends BaseController implements CatCuestionarioRest {

    Logger logger = LoggerFactory.getLogger(CatCuestionarioRestImpl.class);

    @Override
    public void createCuestionario(CatCuestionarioView view) {
        logger.error("Error al acceder al servicio para AGREGAR un cuestionario");
    }

    @Override
    public void updateCuestionario(Integer idCuestionario, CatCuestionarioView view) {
        logger.error("Error al acceder al servicio para MODIFICAR un cuestionario");
    }

    @Override
    public CatCuestionarioView getCuestionario(Integer idCuestionario) {
        logger.error("Error al acceder al servicio para BUSCAR un cuestionario");
        return null;
    }

    @Override
    public Page<CatCuestionarioView> getCuestionarioSearch(Integer page, Integer size, String orderColumn, String orderType) {
        logger.error("Error al acceder al servicio para OBTENER un cuestionario");
        return null;
    }
}
