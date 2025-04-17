package net.amentum.niomedic.niogateway.api.rest.pacientes;

import net.amentum.niomedic.niogateway.api.rest.fallback.pacientes.TutoresRestImpl;
import net.amentum.niomedic.pacientes.views.TutoresView;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@FeignClient(value = "http://nio-pacientes", fallback = TutoresRestImpl.class)
public interface TutoresRest {

    @PostMapping("Tutores")
    TutoresView createTutores(@RequestBody @Valid TutoresView tutoresView);

    @GetMapping("Tutores/findAll")
    List<TutoresView> findAll();

}
