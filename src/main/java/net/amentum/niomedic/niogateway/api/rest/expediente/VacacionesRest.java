package net.amentum.niomedic.niogateway.api.rest.expediente;

import net.amentum.niomedic.expediente.views.VacacionesView;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.VacacionesRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@FeignClient(value = "http://nio-expediente", fallback = VacacionesRestImpl.class)
public interface VacacionesRest {

   @PostMapping("vacaciones")
   void createVacaciones(@RequestBody @Validated VacacionesView vacacionesView);

   @PutMapping("vacaciones/{idVacaciones}")
   void updateVacaciones(@PathVariable("idVacaciones") Long idVacaciones, @RequestBody @Validated VacacionesView vacacionesView);

   @GetMapping("vacaciones/{idUsuario}")
   List<VacacionesView> getDetailsByIdUsuario(@PathVariable("idUsuario") Long idUsuario);
}

