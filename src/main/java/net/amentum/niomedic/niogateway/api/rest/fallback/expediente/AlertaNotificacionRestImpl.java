package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;

import net.amentum.niomedic.expediente.views.AlertaNotificacionView;
import net.amentum.niomedic.niogateway.api.rest.expediente.AlertaNotificacionRest;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

public class AlertaNotificacionRestImpl extends BaseController implements AlertaNotificacionRest {

    private final Logger logger = LoggerFactory.getLogger(AlertaNotificacionRestImpl.class);

    @Override
    public List<AlertaNotificacionView> listActivas(String idMedico) {
        logger.error("Error al acceder al servicio expediente para obtener notificaciones activas del médico {}", idMedico);
        return Collections.emptyList();
    }

    @Override
    public Long countActivas(String idMedico) {
        logger.error("Error al acceder al servicio expediente para obtener conteo de notificaciones activas del médico {}", idMedico);
        return 0L;
    }

    @Override
    public void markAsSeen(Long id) {
        logger.error("Error al acceder al servicio expediente para marcar notificación {} como vista", id);
    }
}
