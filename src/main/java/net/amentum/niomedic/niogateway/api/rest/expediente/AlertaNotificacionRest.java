package net.amentum.niomedic.niogateway.api.rest.expediente;

import net.amentum.niomedic.expediente.views.AlertaNotificacionView;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.AlertaNotificacionRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@FeignClient(value = "http://nio-expediente", fallback = AlertaNotificacionRestImpl.class)
public interface AlertaNotificacionRest {

    // === EXISTENTES (por médico) ===
    @GetMapping("alertas/notificaciones/activas/{idMedico}")
    List<AlertaNotificacionView> listActivas(@PathVariable("idMedico") String idMedico);

    @GetMapping("alertas/notificaciones/activas/{idMedico}/count")
    Long countActivas(@PathVariable("idMedico") String idMedico);

    @PutMapping("alertas/notificaciones/{id}/visto")
    void markAsSeen(@PathVariable("id") Long id);

    // === NUEVOS (por grupo) ===
    @GetMapping("alertas/notificaciones/activas/group/{idGroup}")
    List<AlertaNotificacionView> listActivasPorGrupo(@PathVariable("idGroup") Integer idGroup);

    @GetMapping("alertas/notificaciones/activas/group/{idGroup}/count")
    Long countActivasPorGrupo(@PathVariable("idGroup") Integer idGroup);
}
