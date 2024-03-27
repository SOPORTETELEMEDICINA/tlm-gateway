package net.amentum.niomedic.niogateway.api.rest.pacientes;

import net.amentum.niomedic.niogateway.api.rest.fallback.pacientes.ServiciosRestImpl;
import net.amentum.niomedic.pacientes.views.CatServicio;
import net.amentum.niomedic.pacientes.views.ServiciosView;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@FeignClient(value = "http://nio-pacientes", fallback = ServiciosRestImpl.class)
public interface ServiciosRest {

    @PostMapping("paciente-servicios")
    void createService(@RequestBody @Valid ServiciosView view);

    @GetMapping("paciente-servicios/find")
    CatServicio getServiciosByUsuario(@RequestParam("idPaciente") String idPaciente);

    @GetMapping("paciente-servicios/add")
    void addServiciosByUsuario(@RequestParam("idPaciente") String idPaciente);
}
