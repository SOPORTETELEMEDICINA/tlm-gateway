package net.amentum.niomedic.niogateway.api.rest.pacientes;

import net.amentum.niomedic.niogateway.api.rest.fallback.pacientes.ControlNotificacionRestImpl;
import net.amentum.niomedic.pacientes.views.ControlNotificacionView;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@FeignClient(value = "http://nio-pacientes", fallback = ControlNotificacionRestImpl.class)
public interface ControlNotificacionRest {

    @PostMapping("notificaciones-paciente")
    void createControlNotificacion(@RequestBody @Validated ControlNotificacionView view);

    @GetMapping("notificaciones-paciente/one")
    List<ControlNotificacionView> getByUserAndDeviceAndTipoNotificacion(@RequestParam("idUserApp") Long idUserApp, @RequestParam("idDevice") String idDevice, @RequestParam("tipoNotificacion") Long tipoNotificacion);

    @DeleteMapping("notificaciones-paciente")
    void deleteByUserAndDevice(@RequestParam("idUserApp") Long idUserApp, @RequestParam("idDevice") String idDevice, @RequestParam("tipoNotificacion") Long tipoNotificacion);

    @DeleteMapping("notificaciones-paciente/deleteAll")
    void deleteAll();
}
