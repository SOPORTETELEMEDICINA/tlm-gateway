package net.amentum.niomedic.niogateway.api.rest.fallback.pacientes;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.pacientes.TutoresRest;
import net.amentum.niomedic.pacientes.views.TutoresView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TutoresRestImpl extends BaseController implements TutoresRest {

    private Logger logger = LoggerFactory.getLogger(TutoresRestImpl.class);

    @Override
    public TutoresView createTutores(TutoresView tutoresView) {
        logger.error("Error al accesar al servicio para agregar un tutor");
        return null;
    }

    @Override
    public List<TutoresView> findAll() {
        logger.error("Error al accesar al servicio para obtener tutores");
        return null;
    }
}
