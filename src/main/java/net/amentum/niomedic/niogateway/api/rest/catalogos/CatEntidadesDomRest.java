package net.amentum.niomedic.niogateway.api.rest.catalogos;

import net.amentum.niomedic.catalogos.views.CatEntidadesDomView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.catalogos.CatEntidadesDomRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@FeignClient(value = "http://nio-catalogos", fallback = CatEntidadesDomRestImpl.class)
public interface CatEntidadesDomRest {

   @GetMapping("catalogo-entidades/{idCatEntidadesDom}")
   CatEntidadesDomView getDetailsByIdCatEntidadesDom(@PathVariable("idCatEntidadesDom") Integer idCatEntidadesDom);

   @GetMapping("catalogo-entidades/findAll")
   List<CatEntidadesDomView> findAll();

   @GetMapping("catalogo-entidades/search")
   Page<CatEntidadesDomView> getCatEntidadesDomSearch(@RequestParam(required = false, defaultValue = "", value = "datosBusqueda") String datosBusqueda,
                                                      @RequestParam(required = false, value = "page") Integer page,
                                                      @RequestParam(required = false, value = "size") Integer size,
                                                      @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                                      @RequestParam(required = false, value = "orderType") String orderType);

}
