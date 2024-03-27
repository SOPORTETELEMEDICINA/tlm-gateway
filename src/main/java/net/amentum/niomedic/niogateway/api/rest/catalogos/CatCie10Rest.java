package net.amentum.niomedic.niogateway.api.rest.catalogos;

import net.amentum.niomedic.catalogos.views.CatCie10View;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.catalogos.CatCie10RestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@FeignClient(value = "http://nio-catalogos", fallback = CatCie10RestImpl.class)
public interface CatCie10Rest {

   @GetMapping("catalogo-diagnosticos/{idCatCie10}")
   CatCie10View getDetailsByIdCatCie10(@PathVariable("idCatCie10") Integer idCatCie10);

   @GetMapping("catalogo-diagnosticos/findAll")
   List<CatCie10View> findAll();

   @GetMapping("catalogo-diagnosticos/search")
   Page<CatCie10View> getCatCie10Search(@RequestParam(required = false, defaultValue = "", value = "datosBusqueda") String datosBusqueda,
                                        @RequestParam(required = false, value = "page") Integer page,
                                        @RequestParam(required = false, value = "size") Integer size,
                                        @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                        @RequestParam(required = false, value = "orderType") String orderType);

}
