package net.amentum.niomedic.niogateway.api.rest.pacientes;

import net.amentum.niomedic.niogateway.api.rest.fallback.pacientes.DatosContactoRestImpl;
import net.amentum.niomedic.pacientes.views.DatosContactoView;
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
@FeignClient(value = "http://nio-pacientes", fallback = DatosContactoRestImpl.class)
public interface DatosContactoRest {

   @PostMapping("pacientes/{idPaciente}/datos-contacto")
   void createDatosContacto(@PathVariable("idPaciente") String idPaciente, @RequestBody @Validated ArrayList<DatosContactoView> datosContactoViewArrayList);

   @DeleteMapping("pacientes/{idPaciente}/datos-contacto")
   void deleteDatosContacto(@PathVariable("idPaciente") String idPaciente, @RequestBody @Validated ArrayList<DatosContactoView> datosContactoViewArrayList);

   @PutMapping("pacientes/{idPaciente}/datos-contacto")
   void updateDatosContacto(@PathVariable("idPaciente") String idPaciente, @RequestBody @Validated ArrayList<DatosContactoView> datosContactoViewArrayList);

}