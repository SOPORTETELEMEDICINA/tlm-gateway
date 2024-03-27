package net.amentum.niomedic.niogateway.api.rest.receta;

import net.amentum.niomedic.niogateway.api.rest.fallback.receta.RecetaRestImpl;
import net.amentum.niomedic.receta.views.RecetaView;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@RestController
@FeignClient(value = "http://nio-receta", fallback = RecetaRestImpl.class)
public interface RecetaRest {

   @PostMapping("receta")
   RecetaView createReceta(@RequestBody @Validated RecetaView recetaView);

   @PutMapping("receta/{idReceta}")
   RecetaView updateReceta(@PathVariable("idReceta") UUID idReceta, @RequestBody @Validated RecetaView recetaView);

   @GetMapping("receta/{idReceta}")
   RecetaView getDetailsByIdReceta(@PathVariable("idReceta") UUID idReceta);

   @DeleteMapping("receta/{idReceta}")
   void deleteReceta(@PathVariable("idReceta") UUID idReceta);

   @GetMapping("receta/por-consulta/{consultaId}")
   RecetaView getDetailsByConsultaId(@PathVariable("consultaId") Long consultaId);
}
