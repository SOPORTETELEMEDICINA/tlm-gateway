package net.amentum.niomedic.niogateway.api.rest.catalogos;

import net.amentum.niomedic.catalogos.views.CatEstadoConsultaView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.catalogos.CatEstadoConsultaRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@FeignClient(value = "http://nio-catalogos", fallback = CatEstadoConsultaRestImpl.class)
public interface CatEstadoConsultaRest {

   @GetMapping("catalogo-estado-consulta/{idEstadoConsulta}")
   CatEstadoConsultaView getDetailsByIdCatEstadoConsulta(@PathVariable("idEstadoConsulta") Integer idEstadoConsulta);

   @GetMapping("catalogo-estado-consulta/findAll")
   List<CatEstadoConsultaView> findAll();

   @GetMapping("catalogo-estado-consulta/search")
   Page<CatEstadoConsultaView> getCatEstadoConsultaSearch(@RequestParam(required = false, defaultValue = "", value = "datosBusqueda") String datosBusqueda,
                                                          @RequestParam(required = false, value = "page") Integer page,
                                                          @RequestParam(required = false, value = "size") Integer size,
                                                          @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                                          @RequestParam(required = false, value = "orderType") String orderType);

}
