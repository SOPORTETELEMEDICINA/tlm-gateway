package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;

import net.amentum.niomedic.expediente.views.referencia_vs_referencia.ContraReferenciaView;
import net.amentum.niomedic.expediente.views.referencia_vs_referencia.ReferenciaView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.expediente.ContraReferenciaRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContraReferenciaRestImpl extends BaseController implements ContraReferenciaRest {

    private Logger logger = LoggerFactory.getLogger(ContraReferenciaRestImpl.class);

    @Override
    public void createReferencia(ContraReferenciaView view) {
        logger.error("Error al acceder al servicio para CREAR una contra-referencia");
    }

    @Override
    public Page<ContraReferenciaView> getReferencias(Integer searchColumn, String value, Integer page, Integer size) {
        logger.error("Error al acceder al servicio para OBTENER contra-referencias");
        return null;
    }
}
