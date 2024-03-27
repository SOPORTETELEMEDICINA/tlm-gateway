package net.amentum.niomedic.niogateway.api.rest.pacientes;

import net.amentum.niomedic.niogateway.api.rest.fallback.pacientes.DomicilioRestImpl;
import net.amentum.niomedic.pacientes.views.DatosContactoView;
import net.amentum.niomedic.pacientes.views.DomicilioView;
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
@FeignClient(value = "http://nio-pacientes", fallback = DomicilioRestImpl.class)
public interface DomicilioRest {

   @PostMapping("pacientes/{idPaciente}/domicilio")
   void createDomicilio(@PathVariable("idPaciente") String idPaciente, @RequestBody @Validated ArrayList<DomicilioView> domicilioViewArrayList);

   @PutMapping("pacientes/{idPaciente}/domicilio")
   void updateDomicilio(@PathVariable("idPaciente") String idPaciente, @RequestBody @Validated ArrayList<DomicilioView> domicilioViewArrayList);

   @DeleteMapping("pacientes/{idPaciente}/domicilio")
   void deleteDomicilio(@PathVariable("idPaciente") String idPaciente, @RequestBody @Validated ArrayList<DomicilioView> domicilioViewArrayList);

}