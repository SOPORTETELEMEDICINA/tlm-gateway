package net.amentum.niomedic.niogateway.api.rest.pacientes;

import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.pacientes.PacienteRestImpl;
import net.amentum.niomedic.pacientes.exceptions.PacienteException;
import net.amentum.niomedic.pacientes.views.*;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@FeignClient(value = "http://nio-pacientes", fallback = PacienteRestImpl.class)
public interface PacientesGruposRest {
    @GetMapping("pacientes_grupos/{idPaciente}")
    PacientesGruposView findFirstByIdPaciente(@PathVariable() String idPaciente);
}
