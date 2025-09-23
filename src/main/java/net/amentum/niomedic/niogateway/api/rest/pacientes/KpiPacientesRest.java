package net.amentum.niomedic.niogateway.api.rest.pacientes;

import net.amentum.niomedic.niogateway.api.rest.fallback.pacientes.KpiPacientesRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@RestController
@FeignClient(value = "http://nio-pacientes", fallback = KpiPacientesRestImpl.class)
@RequestMapping("kpi/pacientes/grupo")
public interface KpiPacientesRest {

    @GetMapping("/{idGroup}")
    String getKpisByGroup(@PathVariable("idGroup") Long idGroup);

}
