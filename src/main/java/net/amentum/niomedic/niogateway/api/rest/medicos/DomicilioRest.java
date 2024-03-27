package net.amentum.niomedic.niogateway.api.rest.medicos;

import net.amentum.niomedic.medicos.views.DomicilioView;
import net.amentum.niomedic.niogateway.api.rest.fallback.medicos.DomicilioRestImpl;
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
@FeignClient(value = "http://nio-medicos", fallback = DomicilioRestImpl.class)
public interface DomicilioRest {

   @PostMapping("medicos/{idMedico}/domicilio")
   void createDomicilio(@PathVariable("idMedico") String idMedico, @RequestBody @Validated ArrayList<DomicilioView> domicilioViewArrayList);

   @PutMapping("medicos/{idMedico}/domicilio")
   void updateDomicilio(@PathVariable("idMedico") String idMedico, @RequestBody @Validated ArrayList<DomicilioView> domicilioViewArrayList);

   @DeleteMapping("medicos/{idMedico}/domicilio")
   void deleteDomicilio(@PathVariable("idMedico") String idMedico, @RequestBody @Validated ArrayList<DomicilioView> domicilioViewArrayList);

}
