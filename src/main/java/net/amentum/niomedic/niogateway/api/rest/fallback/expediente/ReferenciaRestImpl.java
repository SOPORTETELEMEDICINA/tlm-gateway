package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;

import net.amentum.niomedic.expediente.views.referencia_vs_referencia.ReferenciaView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.expediente.ReferenciaRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class ReferenciaRestImpl extends BaseController implements ReferenciaRest {
    private Logger logger = LoggerFactory.getLogger(ReferenciaRestImpl.class);

    @Override
    public Map<String, Object> createReferencia(ReferenciaView view) {
        logger.error("Error al acceder al servicio para CREAR una referencia");
        return null;
    }

    @Override
    public Page<ReferenciaView> getReferencias(Integer searchColumn, Integer type, String value, Integer page, Integer size) {
        logger.error("Error al acceder al servicio para OBTENER referencias");
        return null;
    }
}
