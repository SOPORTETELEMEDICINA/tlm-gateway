package net.amentum.niomedic.niogateway.api.rest.catalogos;

import net.amentum.niomedic.catalogos.views.CatLocalidadesDomView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.catalogos.CatLocalidadesDomRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@FeignClient(value = "http://nio-catalogos", fallback = CatLocalidadesDomRestImpl.class)
public interface CatLocalidadesDomRest {

   @GetMapping("catalogo-localidades/{idCatLocalidadesDom}")
   CatLocalidadesDomView getDetailsByIdCatLocalidadesDom(@PathVariable("idCatLocalidadesDom") Integer idCatLocalidadesDom);

   @GetMapping("catalogo-localidades/findAll")
   List<CatLocalidadesDomView> findAll();

   @GetMapping("catalogo-localidades/search")
   Page<CatLocalidadesDomView> getCatLocalidadesDomSearch(@RequestParam(required = false, defaultValue = "", value = "datosBusqueda") String datosBusqueda,
                                                          @RequestParam(required = false, value = "page") Integer page,
                                                          @RequestParam(required = false, value = "size") Integer size,
                                                          @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                                          @RequestParam(required = false, value = "orderType") String orderType);

}
