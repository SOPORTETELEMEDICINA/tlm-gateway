package net.amentum.niomedic.niogateway.api.rest.pacientes;

import net.amentum.niomedic.niogateway.api.rest.fallback.pacientes.RelacionTutoresRestImpl;
import net.amentum.niomedic.pacientes.views.RelacionTutoresView;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@FeignClient(value = "http://nio-pacientes", fallback = RelacionTutoresRestImpl.class)
public interface RelacionTutoresRest {

    @PostMapping("relacion-tutores")
    void createRelacionTutores(@RequestBody @Valid RelacionTutoresView tutoresView);

    @GetMapping("relacion-tutores/findAll")
    List<RelacionTutoresView> findAll();

    @GetMapping("relacion-tutores/find")
    RelacionTutoresView getRelacionTutor(@RequestParam(value = "idPaciente") String idPaciente);

    @GetMapping("relacion-tutores/find-by-tutor/{idTutor}")
    RelacionTutoresView getRelacionTutorByTutor(@PathVariable("idTutor") String idTutor);
}
