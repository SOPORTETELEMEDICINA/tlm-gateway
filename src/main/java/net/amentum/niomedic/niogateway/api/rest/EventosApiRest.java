package net.amentum.niomedic.niogateway.api.rest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import net.amentum.common.GenericException;
import net.amentum.niomedic.expediente.views.ConsultaView;
import net.amentum.niomedic.expediente.views.EventosView;
import net.amentum.niomedic.niogateway.api.rest.expediente.ConsultaRest;
import net.amentum.niomedic.niogateway.api.rest.expediente.EventosRest;

@RestController
@RequestMapping("eventos")
@Slf4j
public class EventosApiRest extends BaseController {
	@Autowired
	private ApiZoom apiZoom;

	@Autowired
	private ConsultaRest consultaRest;
	@Autowired
	private EventosRest eventosRest;


	@PostMapping
	EventosView createEventos(@RequestBody @Validated EventosView eventosView) {
		return this.eventosRest.createEventos(eventosView);
	}

	@PutMapping("/modificar/{idEventos}")
	EventosView updateEventos(@PathVariable("idEventos") Long idEventos, @RequestBody @Validated EventosView eventosView) {
		return this.eventosRest.updateEventos(idEventos, eventosView);
	}

	@PutMapping("/reagendar/{idEventos}")
	void rescheduleEventos(@PathVariable("idEventos") Long idEventos, @RequestParam(required = true, value = "nuevaFecha") Long nuevaFecha, @RequestParam(required = true, value = "nuevaFechaFin") Long nuevaFechaFin) throws GenericException, Exception {
		this.eventosRest.rescheduleEventos(idEventos, nuevaFecha, nuevaFechaFin);
		EventosView eView = this.getDetailsByIdEventos(idEventos);
		if(eView.getIdConsulta() != null) {
			ConsultaView cView = this.consultaRest.getConsultaById(eView.getIdConsulta());
			if(cView.getCanal().equalsIgnoreCase("Video consulta")){
				if(cView.getIdMeeting()!=null) {
					log.info("El evento es tipo cita y es una video consulta, reagendando evento en zoom");
					apiZoom.reagedarMeeting(cView.getIdMeeting(), new Date(nuevaFecha));
				}else {
					log.info("El evento es tipo cita y es una video consulta, pero no tiene asignado un evento en zoom");
				}
			}
		}
	}

	@GetMapping("/{idEventos}")
	EventosView getDetailsByIdEventos(@PathVariable("idEventos") Long idEventos) {
		return this.eventosRest.getDetailsByIdEventos(idEventos);
	}

	@GetMapping("/page")
	Page<EventosView> getEventosPage(@RequestParam(required = false, value = "idUsuario") List<Long> idUsuario,
									   @RequestParam(required = false, value = "idTipoEvento") List<Integer> idTipoEvento,
									   @RequestParam(required = false, value = "titulo", defaultValue = "") String titulo,
									   @RequestParam(required = false, value = "startDate") Long startDate,
									   @RequestParam(required = false, value = "endDate") Long endDate,
									   @RequestParam(required = false, value = "idUsuarioRecibe") List<Long> idUsuarioRecibe,
									   @RequestParam(required = false, value = "idPaciente") List<String> idPaciente,
									   @RequestParam(required = false, value = "regionSanitaria") List<Long> regionSanitaria,
									   @RequestParam(required = false, value = "unidadMedica") List<String> unidadMedica,
									   @RequestParam(required = false, value = "especialidad") List<String> especialidad,
									   @RequestParam(required = false, value = "status") List<Integer> status,
									   @RequestParam(required = false, value = "page") Integer page,
									   @RequestParam(required = false, value = "size") Integer size,
									   @RequestParam(required = false, value = "orderColumn") String orderColumn,
									   @RequestParam(required = false, value = "orderType") String orderType){
		return eventosRest.getEventosPage(idUsuario, idTipoEvento, titulo, startDate, endDate,
				idUsuarioRecibe, idPaciente, regionSanitaria, unidadMedica, especialidad, status, page, size, orderColumn, orderType);
	}

	@GetMapping("/search")
	List<EventosView> getEventosSearch(@RequestParam(required = false, value = "idUsuario") List<Long> idUsuario,
									   @RequestParam(required = false, value = "idTipoEvento") List<Integer> idTipoEvento,
									   @RequestParam(required = false, value = "titulo", defaultValue = "") String titulo,
									   @RequestParam(required = false, value = "startDate") Long startDate,
									   @RequestParam(required = false, value = "endDate") Long endDate,
									   @RequestParam(required = false, value = "idUsuarioRecibe") List<Long> idUsuarioRecibe,
									   @RequestParam(required = false, value = "idPaciente") List<String> idPaciente,
									   @RequestParam(required = false, value = "regionSanitaria") List<Long> regionSanitaria,
									   @RequestParam(required = false, value = "unidadMedica") List<String> unidadMedica,
									   @RequestParam(required = false, value = "especialidad") List<String> especialidad,
									   @RequestParam(required = false, value = "status") List<Integer> status,
									   @RequestParam(required = false, value = "orderColumn") String orderColumn,
									   @RequestParam(required = false, value = "orderType") String orderType){
		return eventosRest.getEventosSearch(idUsuario, idTipoEvento, titulo, startDate, endDate,
				idUsuarioRecibe, idPaciente, regionSanitaria, unidadMedica, especialidad, status, orderColumn, orderType);
	}

	@DeleteMapping("/cancelar/{idEventos}")
	void deleteEventos(@PathVariable("idEventos") Long idEventos) throws GenericException, Exception {
		EventosView eView = this.getDetailsByIdEventos(idEventos);
		eventosRest.deleteEventos(idEventos);
		if(eView.getIdConsulta() != null) {
			ConsultaView cView = this.consultaRest.getConsultaById(eView.getIdConsulta());
			if(cView.getCanal().equalsIgnoreCase("Video consulta")){
				if(cView.getIdMeeting()!=null) {
					log.info("El evento es tipo cita y es una video consulta, reagendando evento en zoom");
					apiZoom.cancelarMeeting(cView.getIdMeeting());
				}else {
					log.info("El evento es tipo cita y es una video consulta, pero no tiene asignado un evento en zoom");
				}
			}
		}
	}

	@GetMapping("/por-consulta/{idConsulta}")
	EventosView getDetailsByIdConsulta(@PathVariable("idConsulta") Long idConsulta) {
		return this.getDetailsByIdConsulta(idConsulta);
	}


	@PutMapping("/status")
	void updateEstatusEvento(@RequestParam(value = "idEvento") Long idEvento, @RequestParam(value = "status") Integer status) {
		eventosRest.updateEstatusEvento(idEvento, status);
	}

	@GetMapping("/getValue")
	Long getEventosValue() {
		return eventosRest.getEventosValue();
	}
}
