package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;

import net.amentum.niomedic.expediente.views.EventosView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.expediente.EventosRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class EventosRestImpl extends BaseController implements EventosRest {

   private Logger logger = LoggerFactory.getLogger(EventosRestImpl.class);

   public EventosView createEventos(EventosView eventosView) {
      logger.error("Error al accesar al servicio para AGREGAR eventos: {}", eventosView);
      return null;
   }

   public EventosView updateEventos(Long idEventos, EventosView eventosView) {
      logger.error("Error al accesar el servicio para MODIFICAR eventos {} al idEventos {}", eventosView, idEventos);
      return null;
   }

   public void rescheduleEventos(Long idEventos, Long nuevaFecha, Long nuevaFechaFin) {
      logger.error("Error al accesar el servicio para REAGENDAR idEventos {} al NuevaFecha {}", idEventos, nuevaFecha);
   }

   public EventosView getDetailsByIdEventos(Long idEventos) {
      logger.error("Error al accesar al servicio para OBTENER POR ID eventos {}", idEventos);
      return null;
   }

   @Override
   public Page<EventosView> getEventosPage(List<Long> idUsuario, List<Integer> idTipoEvento, String titulo, Long startDate,
                                             Long endDate, List<Long> idUsuarioRecibe, List<String> idPaciente, List<Long> regionSanitaria, List<String> unidadMedica,
                                             List<String> especialidad, List<Integer> status, Integer page, Integer size, String orderColumn, String orderType) {
      logger.error("Error al OBTENER PÁGINA de eventos - idUsuario: {} - idTipoEvento: {} - titulo:{} - startDate: {} - endDate: {} - page: {} - size: {} - orderColumn: {} - orderType: {}",
              idUsuario, idTipoEvento, titulo, startDate, endDate, page, size, orderColumn, orderType);
      return null;
   }

   @Override
   public List<EventosView> getEventosSearch(List<Long> idUsuario, List<Integer> idTipoEvento, String titulo,
                                             Long startDate, Long endDate, List<Long> idUsuarioRecibe, List<String> idPaciente,
                                             List<Long> regionSanitaria, List<String> unidadMedica, List<String> especialidad,
                                             List<Integer> status, String orderColumn, String orderType) {
      return null;
   }

   public void deleteEventos(Long idEventos) {
      logger.error("Error al accesar al servicio para BORRAR eventos {}", idEventos);
   }

   public EventosView getDetailsByIdConsulta(Long idConsulta) {
      logger.error("Error al accesar al servicio para OBTENER POR ID consulta {}", idConsulta);
      return null;
   }

   @Override
   public void updateEstatusEvento(Long idEvento, Integer status) {
      logger.error("Error al accesar al servicio para ACTUALIZAR eventos {}", idEvento);
   }

   @Override
   public Long getEventosValue() {
      logger.error("Error al obtener el evento");
      return null;
   }

}
