package net.amentum.niomedic.niogateway.api.rest.pacientes;

import net.amentum.niomedic.niogateway.api.rest.fallback.pacientes.PacienteRestImpl;
import net.amentum.niomedic.niogateway.api.rest.fallback.pacientes.RelacionTitularRestImpl;
import net.amentum.niomedic.pacientes.views.RelacionTitularView;
import net.amentum.niomedic.pacientes.views.RelacionTutoresView;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@FeignClient(value = "http://nio-pacientes", fallback = RelacionTitularRestImpl.class)
public interface RelacionTitularRest {
    @PostMapping("relacion-titular")
    List<RelacionTitularView> createRelacionTitular(@RequestBody @Valid RelacionTitularView relacionTitularView);

    @GetMapping("relacion-titular/beneficiarios/{idPacienteTitular}")
    List<RelacionTitularView> getBeneficiariosTitular(@PathVariable("idPacienteTitular") String idPacienteTitular);
}
