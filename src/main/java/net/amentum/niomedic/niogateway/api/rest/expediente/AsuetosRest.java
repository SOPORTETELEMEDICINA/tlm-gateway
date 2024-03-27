package net.amentum.niomedic.niogateway.api.rest.expediente;

import net.amentum.niomedic.expediente.views.AsuetosView;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.AsuetosRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@FeignClient(value = "http://nio-expediente", fallback = AsuetosRestImpl.class)
public interface AsuetosRest {

   @PostMapping("asuetos")
   void createAsuetos(@RequestBody @Validated AsuetosView asuetosView);

   @PutMapping("asuetos/{idAsuetos}")
   void updateAsuetos(@PathVariable("idAsuetos") Long idAsuetos, @RequestBody @Validated AsuetosView asuetosView);

   @GetMapping("asuetos/{idAsuetos}")
   AsuetosView getDetailsByIdAsuetos(@PathVariable("idAsuetos") Long idAsuetos);

   @DeleteMapping("asuetos/{idAsuetos}")
   void deleteAsuetos(@PathVariable("idAsuetos") Long idAsuetos);

   @GetMapping("asuetos/findAll")
   List<AsuetosView> findAll();
}
