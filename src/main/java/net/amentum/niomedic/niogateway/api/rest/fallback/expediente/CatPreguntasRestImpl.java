package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;

import net.amentum.niomedic.expediente.views.CatCuestionarioHeader;
import net.amentum.niomedic.expediente.views.CatPreguntaView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.expediente.CatPreguntasRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CatPreguntasRestImpl extends BaseController implements CatPreguntasRest {

    Logger logger = LoggerFactory.getLogger(CatPreguntasRestImpl.class);

    @Override
    public void createPregunta(CatPreguntaView view) {
        logger.error("Error al acceder al servicio para AGREGAR una pregunta");
    }

    @Override
    public void updatePregunta(Integer idPregunta, CatPreguntaView view) {
        logger.error("Error al acceder al servicio para MODIFICAR una pregunta");
    }

    @Override
    public CatPreguntaView getPregunta(Integer idPregunta) {
        logger.error("Error al acceder al servicio para BUSCAR una pregunta");
        return null;
    }

    @Override
    public Page<CatCuestionarioHeader> getPreguntaSearch(Integer idCuestionario, Integer page, Integer size, String orderColumn, String orderType) {
        logger.error("Error al acceder al servicio para BUSCAR una lista de preguntas");
        return null;
    }

    @Override
    public Page<CatPreguntaView> getPreguntaSearchPage(Integer page, Integer size, String orderColumn, String orderType) {
        logger.error("Error al acceder al servicio para BUSCAR una lista de preguntas");
        return null;
    }
}
