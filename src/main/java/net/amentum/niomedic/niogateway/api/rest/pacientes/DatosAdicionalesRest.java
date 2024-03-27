package net.amentum.niomedic.niogateway.api.rest.pacientes;


import net.amentum.niomedic.niogateway.api.rest.fallback.pacientes.DatosAdicionalesRestImpl;
import net.amentum.niomedic.pacientes.views.DatosAdicionalesView;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@FeignClient(value = "http://nio-pacientes", fallback = DatosAdicionalesRestImpl.class)
public interface DatosAdicionalesRest {

   @PostMapping("pacientes/{idPaciente}/datos-adicionales")
   void createdDatosAdicionales(@PathVariable("idPaciente") String idPaciente, @RequestBody @Validated DatosAdicionalesView datosAdicionalesView);

   @PutMapping("pacientes/{idPaciente}/datos-adicionales")
   void updateDatosAdicionales(@PathVariable("idPaciente") String idPaciente, @RequestBody @Validated DatosAdicionalesView datosAdicionalesView);

}
