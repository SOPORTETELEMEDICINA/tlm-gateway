package net.amentum.niomedic.niogateway.api.rest.fallback.pacientes;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.pacientes.RelacionTitularRest;
import net.amentum.niomedic.niogateway.api.rest.pacientes.RelacionTutoresRest;
import net.amentum.niomedic.pacientes.views.RelacionTitularView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class RelacionTitularRestImpl extends BaseController implements RelacionTitularRest {
    private Logger logger = LoggerFactory.getLogger(RelacionTitularRestImpl.class);

    @Override
    public List<RelacionTitularView> createRelacionTitular(RelacionTitularView relacionTitularView) {
        logger.error("Error al acceder al servicio para crear la relación del titular y beneficiario");

        return null;
    }

    @Override
    public List<RelacionTitularView> getBeneficiariosTitular(String idPacienteTitular) {
        logger.error("Error al acceder al servicios para obtener el listado de relaciones por titular");

        return null;
    }
}
