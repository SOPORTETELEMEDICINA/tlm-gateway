package net.amentum.niomedic.niogateway.api.rest.expediente;

import net.amentum.niomedic.expediente.views.EventosView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.EventosRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@FeignClient(value = "http://nio-expediente", fallback = EventosRestImpl.class)
public interface EventosRest {

   @PostMapping("eventos")
   EventosView createEventos(@RequestBody @Validated EventosView eventosView);

   @PutMapping("eventos/modificar/{idEventos}")
   EventosView updateEventos(@PathVariable("idEventos") Long idEventos, @RequestBody @Validated EventosView eventosView);

   @PutMapping("eventos/reagendar/{idEventos}")
   void rescheduleEventos(@PathVariable("idEventos") Long idEventos, @RequestParam(required = true, value = "nuevaFecha") Long nuevaFecha, @RequestParam(required = true, value = "nuevaFechaFin") Long nuevaFechaFin);

   @GetMapping("eventos/{idEventos}")
   EventosView getDetailsByIdEventos(@PathVariable("idEventos") Long idEventos);

   @GetMapping("eventos/page")
   Page<EventosView> getEventosPage(@RequestParam(required = false, value = "idUsuario") List<Long> idUsuario,
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

   @GetMapping("eventos/search")
   List<EventosView> getEventosSearch(@RequestParam(required = false, value = "idUsuario") List<Long> idUsuario,
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
                                      @RequestParam(required = false, value = "orderColumn", defaultValue = "titulo") String orderColumn,
                                      @RequestParam(required = false, value = "orderType", defaultValue = "asc") String orderType);

   @DeleteMapping("eventos/cancelar/{idEventos}")
   void deleteEventos(@PathVariable("idEventos") Long idEventos);

   @GetMapping("eventos/por-consulta/{idConsulta}")
   EventosView getDetailsByIdConsulta(@PathVariable("idConsulta") Long idConsulta);

   @PutMapping("eventos/status")
   void updateEstatusEvento(@RequestParam(value = "idEvento") Long idEvento, @RequestParam(value = "status") Integer status);

   @GetMapping("eventos/getValue")
   Long getEventosValue();
}
