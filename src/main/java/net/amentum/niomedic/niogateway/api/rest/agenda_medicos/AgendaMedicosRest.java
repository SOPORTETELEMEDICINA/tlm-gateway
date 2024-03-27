package net.amentum.niomedic.niogateway.api.rest.agenda_medicos;

import net.amentum.niomedic.catalogos.views.CatEspecialidadesView;
import net.amentum.niomedic.expediente.views.EventosView;
import net.amentum.niomedic.medicos.views.MedicoAgendaPageView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@FeignClient(value = "http://nio-agenda-medicos", fallback = AgendaMedicosRestImpl.class)
public interface AgendaMedicosRest {

    @GetMapping("medicos-auth/obtenerPorEspecialidad")
    Page<MedicoAgendaPageView> getDetailsByEspecialidad(@RequestParam(value = "nombreEspecialidad") String nombreEspecialidad,
                                                        @RequestParam(required = false, value = "page") Integer page,
                                                        @RequestParam(required = false, value = "size") Integer size,
                                                        @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                                        @RequestParam(required = false, value = "orderType") String orderType);

    @GetMapping("catalogo-especialidades-auth/findAll")
    List<CatEspecialidadesView> findAll();

    @PostMapping("eventos-auth")
    EventosView createEventos(@RequestBody @Validated EventosView eventosView);

    @GetMapping("eventos-auth/search")
    Page<EventosView> getEventosSearch(@RequestParam(required = false, value = "idUsuario") List<Long> idUsuario,
                                       @RequestParam(required = false, value = "idTipoEvento") List<Integer> idTipoEvento,
                                       @RequestParam(required = false, value = "titulo",defaultValue = "") String titulo,
                                       @RequestParam(required = false, value = "startDate") Long startDate,
                                       @RequestParam(required = false, value = "endDate") Long endDate,
                                       @RequestParam(required = false, value = "idUsuarioRecibe") List<Long> idUsuarioRecibe,
                                       @RequestParam(required = false, value = "idPaciente") List<String> idPaciente,
                                       @RequestParam(required = false, value = "regionSanitaria") List<Long> regionSanitaria,
                                       @RequestParam(required = false, value = "unidadMedica") List<String> unidadMedica,
                                       @RequestParam(required = false, value = "especialidad") List<String> especialidad,
                                       @RequestParam(required = false, value = "status") List<Integer> status,
                                       @RequestParam(required = false, value = "page", defaultValue = "0") Integer page,
                                       @RequestParam(required = false, value = "size", defaultValue = "10") Integer size,
                                       @RequestParam(required = false, value = "orderColumn", defaultValue = "titulo") String orderColumn,
                                       @RequestParam(required = false, value = "orderType", defaultValue = "asc") String orderType);

}
