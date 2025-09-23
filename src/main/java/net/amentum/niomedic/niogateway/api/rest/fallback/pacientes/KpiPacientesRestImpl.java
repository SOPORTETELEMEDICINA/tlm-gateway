package net.amentum.niomedic.niogateway.api.rest.fallback.pacientes;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.pacientes.KpiPacientesRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KpiPacientesRestImpl extends BaseController implements KpiPacientesRest {

    private static final Logger logger = LoggerFactory.getLogger(KpiPacientesRestImpl.class);

    @Override
    public String getKpisByGroup(Long idGroup) {
        logger.error("Fallback KpiPacientesRest.getKpisByGroup - nio-pacientes no disponible. idGroup={}", idGroup);
        // devolvemos JSON vacío para no romper al front
        return "{}";
    }
}
