package net.amentum.niomedic.niogateway.api.rest.agenda_medicos;

import net.amentum.niomedic.catalogos.views.CatEspecialidadesView;
import net.amentum.niomedic.expediente.views.EventosView;
import net.amentum.niomedic.medicos.views.MedicoAgendaPageView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;

import java.util.List;

public class AgendaMedicosRestImpl extends BaseController implements AgendaMedicosRest {
    @Override
    public Page<MedicoAgendaPageView> getDetailsByEspecialidad(String nombreEspecialidad, Integer page, Integer size, String orderColumn, String orderType) {
        return null;
    }

    @Override
    public List<CatEspecialidadesView> findAll() {
        return null;
    }

    @Override
    public EventosView createEventos(EventosView eventosView) {
        return null;
    }

    @Override
    public Page<EventosView> getEventosSearch(List<Long> idUsuario, List<Integer> idTipoEvento, String titulo, Long startDate, Long endDate, List<Long> idUsuarioRecibe, List<String> idPaciente, List<Long> regionSanitaria, List<String> unidadMedica, List<String> especialidad, List<Integer> status, Integer page, Integer size, String orderColumn, String orderType) {
        return null;
    }
}
