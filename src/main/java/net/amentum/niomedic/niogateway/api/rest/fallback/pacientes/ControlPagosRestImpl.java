package net.amentum.niomedic.niogateway.api.rest.fallback.pacientes;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.pacientes.ControlPagosRest;
import net.amentum.niomedic.pacientes.views.ControlPagosView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ControlPagosRestImpl extends BaseController implements ControlPagosRest {

    private final Logger logger = LoggerFactory.getLogger(ControlPagosRestImpl.class);

    @Override
    public void addFolioVenta(ControlPagosView view) {
        logger.error("Error al accesar al servicio para AGREGAR Pago");
    }

    @Override
    public void atenderFolioVenta(String folioVenta, Long numeroSucursal) {
        logger.error("Error al accesar al servicio para ATENDER Pago");
    }

    @Override
    public void cancelarFolioVenta(String folioVenta, Long numeroSucursal) {
        logger.error("Error al accesar al servicio para CANCELAR Pago");
    }

    @Override
    public void finalizarFolioVenta(String folioVenta, Long numeroSucursal) {
        logger.error("Error al accesar al servicio para FINALIZAR Pago");
    }

    @Override
    public ControlPagosView getFolioVenta(String folioVenta, Long numeroSucursal) {
        logger.error("Error al accesar al servicio para OBTENER Pago");
        return null;
    }
}
