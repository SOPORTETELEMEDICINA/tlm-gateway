package net.amentum.niomedic.niogateway.api.rest.catalogos;

import net.amentum.niomedic.catalogos.views.CatTitulosCie10View;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.catalogos.CatTitulosCie10RestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@FeignClient(value = "http://nio-catalogos", fallback = CatTitulosCie10RestImpl.class)
public interface CatTitulosCie10Rest {

   @GetMapping("catalogo-titulos-cie10/{idCatTitulosCie10}")
   CatTitulosCie10View getDetailsByIdCatTitulosCie10(@PathVariable("idCatTitulosCie10") Integer idCatTitulosCie10);

   @GetMapping("catalogo-titulos-cie10/findAll")
   List<CatTitulosCie10View> findAll();

   @GetMapping("catalogo-titulos-cie10/search")
   Page<CatTitulosCie10View> getCatTitulosCie10Search(@RequestParam(required = false, defaultValue = "", value = "datosBusqueda") String datosBusqueda,
                                                      @RequestParam(required = false, value = "page") Integer page,
                                                      @RequestParam(required = false, value = "size") Integer size,
                                                      @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                                      @RequestParam(required = false, value = "orderType") String orderType);

}
