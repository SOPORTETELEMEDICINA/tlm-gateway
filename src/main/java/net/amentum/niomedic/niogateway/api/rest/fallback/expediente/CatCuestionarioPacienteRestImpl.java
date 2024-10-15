package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;

import net.amentum.niomedic.expediente.views.CatCuestionarioPacienteView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.expediente.CatCuestionarioPacienteRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CatCuestionarioPacienteRestImpl extends BaseController implements CatCuestionarioPacienteRest {

    Logger logger = LoggerFactory.getLogger(CatCuestionarioPacienteRestImpl.class);

    @Override
    public void createCuestionarioPaciente(CatCuestionarioPacienteView view) {
        logger.error("Error al acceder al servicio para AGREGAR un cuestionario a un paciente");
    }
}
