package net.amentum.niomedic.niogateway.api.rest.expediente;

import net.amentum.niomedic.expediente.views.TurnosLaboralesView;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.TurnosLaboralesRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@FeignClient(value = "http://nio-expediente", fallback = TurnosLaboralesRestImpl.class)
public interface TurnosLaboralesRest {

   @PostMapping("turnos-laborales")
   void createTurnosLaborales(@RequestBody @Validated TurnosLaboralesView turnosLaboralesView);

   @PutMapping("turnos-laborales/{idTurnosLaborales}")
   void updateTurnosLaborales(@PathVariable("idTurnosLaborales") Long idTurnosLaborales, @RequestBody @Validated TurnosLaboralesView turnosLaboralesView);

   @GetMapping("turnos-laborales/{idUsuario}")
   TurnosLaboralesView getDetailsByIdUsuario(@PathVariable("idUsuario") Long idUsuario);
}
