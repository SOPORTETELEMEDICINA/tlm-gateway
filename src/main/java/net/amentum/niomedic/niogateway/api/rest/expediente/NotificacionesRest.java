package net.amentum.niomedic.niogateway.api.rest.expediente;


import net.amentum.niomedic.expediente.views.NotificacionesView;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.NotificacionesRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
@FeignClient(value = "http://nio-expediente", fallback = NotificacionesRestImpl.class)
public interface NotificacionesRest {

   @PostMapping("notificaciones")
   NotificacionesView createNotificaciones(@RequestBody @Validated NotificacionesView notificacionesView);

   @PutMapping("notificaciones/{idNotificaciones}")
   NotificacionesView updateNotificaciones(@PathVariable("idNotificaciones") Long idNotificaciones, @RequestBody @Validated NotificacionesView notificacionesView);

   @GetMapping("notificaciones/{idNotificaciones}")
   NotificacionesView getDetailsByIdNotificaciones(@PathVariable("idNotificaciones") Long idNotificaciones);

   @GetMapping("notificaciones/search")
   List<NotificacionesView> getNotificacionesSearch(@RequestParam(required = true, value = "idUsuario") Long idUsuario,
                                                    @RequestParam(required = true, value = "estatus") Integer estatus);


   @DeleteMapping("notificaciones/{idNotificaciones}")
   void deleteNotificaciones(@PathVariable("idNotificaciones") Long idNotificaciones);

   @PutMapping("notificaciones/leido/{idNotificaciones}")
   void readedNotificaciones(@PathVariable("idNotificaciones") Long idNotificaciones);


}
