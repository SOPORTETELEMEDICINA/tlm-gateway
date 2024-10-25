package net.amentum.niomedic.niogateway.api.rest.fallback.pacientes;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.pacientes.PacientesGruposRest;
import net.amentum.niomedic.pacientes.views.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PacientesGruposRestImpl extends BaseController implements PacientesGruposRest {

    private Logger logger = LoggerFactory.getLogger(PacientesGruposRestImpl.class);

    @Override
    public PacientesGruposView findFirstByIdPaciente(String idPaciente) {
        logger.error("Error al obtener el grupo del paciente: {}", idPaciente);
        return null;
    }
}

