package net.amentum.niomedic.niogateway.api.rest.expediente;

import net.amentum.niomedic.expediente.views.CatEstatusConsultaView;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.CatEstatusConsultaRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@FeignClient(value = "http://nio-expediente", fallback = CatEstatusConsultaRestImpl.class)
public interface CatEstatusConsultaRest {

   @GetMapping("cat-estatus-consulta")
   List<CatEstatusConsultaView> getAll();

}
