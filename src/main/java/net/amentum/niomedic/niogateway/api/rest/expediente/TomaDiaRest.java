package net.amentum.niomedic.niogateway.api.rest.expediente;

import net.amentum.niomedic.expediente.views.TomaDiaView;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.TomaDiaRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@FeignClient(value = "http://nio-expediente", fallback = TomaDiaRestImpl.class)
public interface TomaDiaRest {

   @GetMapping("toma-dia/{idUsuario}")
   List<TomaDiaView> getTomasDia(@PathVariable("idUsuario") Long idUsuario);
}
