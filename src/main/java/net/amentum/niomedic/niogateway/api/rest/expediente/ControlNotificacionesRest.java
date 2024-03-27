package net.amentum.niomedic.niogateway.api.rest.expediente;

import net.amentum.niomedic.expediente.views.ControlNotificacionSimpView;
import net.amentum.niomedic.expediente.views.ControlNotificacionViewList;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.ControlNotificacionesRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@FeignClient(value = "http://nio-expediente", fallback = ControlNotificacionesRestImpl.class)
public interface ControlNotificacionesRest {

    @GetMapping("notificaciones-paciente")
    HashMap<String, List<ControlNotificacionSimpView>> getNotificationsByDay();

    @GetMapping("notificaciones-paciente/{idPaciente}")
    HashMap<String, List<ControlNotificacionViewList>> getNotificationsByIdPaciente(@PathVariable("idPaciente") String idPaciente);
}
