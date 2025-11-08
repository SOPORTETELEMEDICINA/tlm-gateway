package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;

import net.amentum.niomedic.expediente.views.AlertaNotificacionView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.expediente.AlertaNotificacionRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

public class AlertaNotificacionRestImpl extends BaseController implements AlertaNotificacionRest {

    private final Logger logger = LoggerFactory.getLogger(AlertaNotificacionRestImpl.class);

    // === EXISTENTES (por médico) ===
    @Override
    public List<AlertaNotificacionView> listActivas(String idMedico) {
        logger.error("Gateway fallback: no se pudo obtener notificaciones activas del médico {}", idMedico);
        return Collections.emptyList();
    }

    @Override
    public Long countActivas(String idMedico) {
        logger.error("Gateway fallback: no se pudo obtener conteo de notificaciones activas del médico {}", idMedico);
        return 0L;
    }

    @Override
    public void markAsSeen(Long id) {
        logger.error("Gateway fallback: no se pudo marcar la notificación {} como vista", id);
    }

    // === NUEVOS (por grupo) ===
    @Override
    public List<AlertaNotificacionView> listActivasPorGrupo(Integer idGroup) {
        logger.error("Gateway fallback: no se pudo obtener notificaciones activas del grupo {}", idGroup);
        return Collections.emptyList();
    }

    @Override
    public Long countActivasPorGrupo(Integer idGroup) {
        logger.error("Gateway fallback: no se pudo obtener conteo de notificaciones activas del grupo {}", idGroup);
        return 0L;
    }
}
