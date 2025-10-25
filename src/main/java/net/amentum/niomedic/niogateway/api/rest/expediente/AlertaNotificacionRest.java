package net.amentum.niomedic.niogateway.api.rest.expediente;

import net.amentum.niomedic.expediente.views.AlertaNotificacionView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.AlertaNotificacionRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "http://nio-expediente", fallback = AlertaNotificacionRestImpl.class)
public interface AlertaNotificacionRest {

    @GetMapping("alertas/notificaciones/activas/{idMedico}")
    List<AlertaNotificacionView> listActivas(@PathVariable("idMedico") String idMedico);

    @GetMapping("alertas/notificaciones/activas/{idMedico}/count")
    Long countActivas(@PathVariable("idMedico") String idMedico);

    @PutMapping("alertas/notificaciones/{id}/visto")
    void markAsSeen(@PathVariable("id") Long id);
}
