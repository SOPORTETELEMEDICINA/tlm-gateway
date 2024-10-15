package net.amentum.niomedic.niogateway.api.rest.expediente;

import net.amentum.niomedic.expediente.views.CatCuestionarioPacienteView;
import net.amentum.niomedic.expediente.views.CatCuestionarioView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.CatCuestionarioPacienteRestImpl;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.CatCuestionarioRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@FeignClient(value = "http://nio-expediente", fallback = CatCuestionarioPacienteRestImpl.class)
public interface CatCuestionarioPacienteRest {

    @PostMapping("cat_cuestionario_paciente")
    void createCuestionarioPaciente(@RequestBody @Validated CatCuestionarioPacienteView view);
}
