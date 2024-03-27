package net.amentum.niomedic.niogateway.api.rest.expediente;

import net.amentum.niomedic.expediente.views.CatEstadoConsultaView;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.CatEstadoConsultaRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@FeignClient(value = "http://nio-expediente", fallback = CatEstadoConsultaRestImpl.class)
public interface CatEstadoConsultaRest {

   @GetMapping("cat-estado-consulta")
   List<CatEstadoConsultaView> getAll();

}