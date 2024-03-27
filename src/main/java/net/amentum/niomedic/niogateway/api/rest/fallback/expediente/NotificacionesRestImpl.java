package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;

import lombok.extern.slf4j.Slf4j;
import net.amentum.niomedic.expediente.views.NotificacionesView;
import net.amentum.niomedic.niogateway.api.rest.expediente.NotificacionesRest;

import java.util.List;

@Slf4j
public class NotificacionesRestImpl implements NotificacionesRest {

   @Override
   public NotificacionesView createNotificaciones(NotificacionesView notificacionesView) {
      log.error("Error al Crear una notificación: {}", notificacionesView);
      return null;
   }

   @Override
   public NotificacionesView updateNotificaciones(Long idNotificaciones, NotificacionesView notificacionesView) {
      log.error("Error al Actualizar una notificación: {} para el idNotificaciones: {}", notificacionesView, idNotificaciones);
      return null;
   }

   @Override
   public NotificacionesView getDetailsByIdNotificaciones(Long idNotificaciones) {
      log.error("Error al Obtener los detalles de una notificación para el idNotificaciones: {}", idNotificaciones);
      return null;
   }

   @Override
   public List<NotificacionesView> getNotificacionesSearch(Long idUsuario,
                                                           Integer estatus) {
      log.error("Error al Buscar las notificaciones de - idUsuario: {} - estatus: {}", idUsuario, estatus);
      return null;
   }


   @Override
   public void deleteNotificaciones(Long idNotificaciones) {
      log.error("Error al Eliminar una notificación  con el idNotificaciones: {}", idNotificaciones);
   }

   @Override
   public void readedNotificaciones(Long idNotificaciones) {
      log.error("Error al Marcar como Leida una notificación  con el idNotificaciones: {}", idNotificaciones);
   }
}
