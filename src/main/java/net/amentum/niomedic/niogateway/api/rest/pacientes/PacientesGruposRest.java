package net.amentum.niomedic.niogateway.api.rest.pacientes;

import net.amentum.niomedic.niogateway.api.rest.fallback.pacientes.PacientesGruposRestImpl;
import net.amentum.niomedic.pacientes.views.PacientesGruposView;
import net.amentum.niomedic.pacientes.exceptions.PacienteException;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;


@RestController
@FeignClient(value = "nio-pacientes", path = "pacientes_grupos", fallback = PacientesGruposRestImpl.class)
public interface PacientesGruposRest {

   @GetMapping("{idPaciente}")
   PacientesGruposView findFirstByIdPaciente(@PathVariable("idPaciente") String idPaciente) throws PacienteException;

}
