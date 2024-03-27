package net.amentum.niomedic.niogateway.api.rest;

import net.amentum.common.v2.RestBaseController;
import net.amentum.niomedic.expediente.views.NotificacionesView;
import net.amentum.niomedic.niogateway.api.rest.expediente.NotificacionesRest;
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

import java.util.List;

@RestController
@RequestMapping("notificaciones")
public class NotificacionesRestApi extends RestBaseController {

   @Autowired
   private NotificacionesRest notificacionesRest;

   @PostMapping
   NotificacionesView createNotificaciones(@RequestBody @Validated NotificacionesView notificacionesView) {
      return this.notificacionesRest.createNotificaciones(notificacionesView);
   }

   @PutMapping("{idNotificaciones}")
   NotificacionesView updateNotificaciones(@PathVariable("idNotificaciones") Long idNotificaciones, @RequestBody @Validated NotificacionesView notificacionesView) {
      return this.notificacionesRest.updateNotificaciones(idNotificaciones, notificacionesView);
   }

   @GetMapping("{idNotificaciones}")
   NotificacionesView getDetailsByIdNotificaciones(@PathVariable("idNotificaciones") Long idNotificaciones) {
      return this.notificacionesRest.getDetailsByIdNotificaciones(idNotificaciones);
   }

   @GetMapping("search")
   List<NotificacionesView> getNotificacionesSearch(@RequestParam(required = true, value = "idUsuario") Long idUsuario,
                                                    @RequestParam(required = true, value = "estatus") Integer estatus) {
      return this.notificacionesRest.getNotificacionesSearch(idUsuario, estatus);
   }

   @DeleteMapping("{idNotificaciones}")
   void deleteNotificaciones(@PathVariable("idNotificaciones") Long idNotificaciones) {
      this.notificacionesRest.deleteNotificaciones(idNotificaciones);
   }

   @PutMapping("leido/{idNotificaciones}")
   void readedNotificaciones(@PathVariable("idNotificaciones") Long idNotificaciones) {
      this.notificacionesRest.readedNotificaciones(idNotificaciones);
   }

}
