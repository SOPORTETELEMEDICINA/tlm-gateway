package net.amentum.niomedic.niogateway.api.rest.pacientes;

import net.amentum.niomedic.niogateway.api.rest.fallback.pacientes.ServicioAdicionalesRestImpl;
import net.amentum.niomedic.pacientes.views.ServicioAdicionalesView;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@FeignClient(value = "http://nio-pacientes", fallback = ServicioAdicionalesRestImpl.class)
public interface ServicioAdicionalesRest {

   @PostMapping("pacientes/{idPaciente}/servicio-adicionales")
   void createServicioAdicionales(@PathVariable("idPaciente") String idPaciente, @RequestBody @Validated ArrayList<ServicioAdicionalesView> servicioAdicionalesViewArrayList);

   @PutMapping("pacientes/{idPaciente}/servicio-adicionales")
   void updateServicioAdicionales(@PathVariable("idPaciente") String idPaciente, @RequestBody @Validated ArrayList<ServicioAdicionalesView> servicioAdicionalesViewArrayList);

   @DeleteMapping("pacientes/{idPaciente}/servicio-adicionales")
   void deleteServicioAdicionales(@PathVariable("idPaciente") String idPaciente, @RequestBody @Validated ArrayList<ServicioAdicionalesView> servicioAdicionalesViewArrayList);


}
