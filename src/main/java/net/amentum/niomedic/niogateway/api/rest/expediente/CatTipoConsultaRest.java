package net.amentum.niomedic.niogateway.api.rest.expediente;

import net.amentum.niomedic.expediente.views.CatTipoConsultaView;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.CatTipoConsultaRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@FeignClient(value = "http://nio-expediente", fallback = CatTipoConsultaRestImpl.class)
public interface CatTipoConsultaRest {

   @GetMapping("cat-tipo-consulta")
   List<CatTipoConsultaView> getAll();

}
