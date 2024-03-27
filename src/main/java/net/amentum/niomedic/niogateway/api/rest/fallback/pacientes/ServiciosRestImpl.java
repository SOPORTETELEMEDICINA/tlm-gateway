package net.amentum.niomedic.niogateway.api.rest.fallback.pacientes;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.pacientes.ServiciosRest;
import net.amentum.niomedic.pacientes.views.CatServicio;
import net.amentum.niomedic.pacientes.views.CatServicioView;
import net.amentum.niomedic.pacientes.views.ServiciosView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ServiciosRestImpl extends BaseController implements ServiciosRest {

    private Logger logger = LoggerFactory.getLogger(ServiciosRestImpl.class);

    @Override
    public void createService(ServiciosView view) {
        logger.error("Error al accesar al servicio para agregar");
    }

    @Override
    public CatServicio getServiciosByUsuario(String idPaciente) {
        logger.error("Error al accesar al servicio obtener");
        return null;
    }

    @Override
    public void addServiciosByUsuario(String idPaciente) {
        logger.error("Error al accesar al servicio para agregar varios permisos");
    }
}
