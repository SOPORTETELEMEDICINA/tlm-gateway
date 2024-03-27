package net.amentum.niomedic.niogateway.api.rest.fallback.medicos;


import net.amentum.niomedic.medicos.views.AgendaMedicosView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.medicos.AgendamedicosRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class AgendamedicosRestImpl extends BaseController implements AgendamedicosRest {

    private Logger logger = LoggerFactory.getLogger(AgendamedicosRestImpl.class);

    public void createAgendamedicos(AgendaMedicosView AgendaMedicosView) {
        logger.error("Error al accesar al servicio para AGREGAR un niveles covid: {}", AgendaMedicosView);
    }


    public void updateAgendamedicos(Integer idagenda, AgendaMedicosView AgendaMedicosView) {
        logger.error("Error al accesar el servicio para MODIFICAR niveles covid {} al paciente {}", AgendaMedicosView, idagenda);
    }


    public void deleteAgendamedicos(Integer idagenda) {
        logger.error("Error al accesar al servicio para BORRAR niveles covid al paciente {}", idagenda);
    }


    public List<AgendaMedicosView> findAll() {
        logger.error("Error al accesar al servicio para OBTENER TODOS los niveles covid");
        return null;
    }

    @Override
    public Page<AgendaMedicosView> getAgendamedicosSearch(String idmedico, Integer page, Integer size, String orderColumn, String orderType) {
        logger.error("Error al OBTENER PÁGINA de NivelesPeso - idmedico: {}  - page: {} - size: {} - orderColumn: {} - orderType: {}",
                idmedico, page, size, orderColumn, orderType);
        return null;
    }
}
