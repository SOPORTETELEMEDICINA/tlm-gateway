package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;

import net.amentum.niomedic.expediente.views.ControlNotificacionSimpView;
import net.amentum.niomedic.expediente.views.ControlNotificacionViewList;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.expediente.ControlNotificacionesRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;

public class ControlNotificacionesRestImpl extends BaseController implements ControlNotificacionesRest {

    private Logger logger = LoggerFactory.getLogger(ControlNotificacionesRestImpl.class);

    @Override
    public HashMap<String, List<ControlNotificacionSimpView>> getNotificationsByDay() {
        logger.error("Error al accesar al servicio para OBTENER notificaciones por dia");
        return null;
    }

    @Override
    public HashMap<String, List<ControlNotificacionViewList>> getNotificationsByIdPaciente(String idPaciente) {
        logger.error("Error al accesar al servicio para OBTENER notificaciones por paciente");
        return null;
    }
}
