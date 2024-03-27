package net.amentum.niomedic.niogateway.api.rest.fallback.pacientes;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.pacientes.ControlNotificacionRest;
import net.amentum.niomedic.pacientes.views.ControlNotificacionView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ControlNotificacionRestImpl extends BaseController implements ControlNotificacionRest {

    private Logger logger = LoggerFactory.getLogger(ControlNotificacionRestImpl.class);

    @Override
    public void createControlNotificacion(ControlNotificacionView view) {
        logger.error("Error al accesar al servicio para AGREGAR notificaciones");
    }

    @Override
    public List<ControlNotificacionView> getByUserAndDeviceAndTipoNotificacion(Long idUserApp, String idDevice, Long tipoNotificacion) {
        logger.error("Error al accesar al servicio para BUSCAR notificaciones por usuario-dispositivo-tipo");
        return null;
    }

    @Override
    public void deleteByUserAndDevice(Long idUserApp, String idDevice, Long tipoNotificacion) {
        logger.error("Error al accesar al servicio para BORRAR notificaciones por usuario-dispositivo-tipo");
    }

    @Override
    public void deleteAll() {
        logger.error("Error al accesar al servicio para BORRAR todas las notificaciones");
    }
}
