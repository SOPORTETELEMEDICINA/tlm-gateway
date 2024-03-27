package net.amentum.niomedic.niogateway.api.rest.catalogos;

import net.amentum.niomedic.catalogos.views.CatCapitulosCie10View;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.catalogos.CatCapitulosCie10RestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@FeignClient(value = "http://nio-catalogos", fallback = CatCapitulosCie10RestImpl.class)
public interface CatCapitulosCie10Rest {

   @GetMapping("catalogo-capitulos-cie10/{idCatCapitulosCie10}")
   CatCapitulosCie10View getDetailsByIdCatCapitulosCie10(@PathVariable("idCatCapitulosCie10") Integer idCatCapitulosCie10);

   @GetMapping("catalogo-capitulos-cie10/findAll")
   List<CatCapitulosCie10View> findAll();

   @GetMapping("catalogo-capitulos-cie10/search")
   Page<CatCapitulosCie10View> getCatCapitulosCie10Search(@RequestParam(required = false, defaultValue = "", value = "datosBusqueda") String datosBusqueda,
                                                          @RequestParam(required = false, value = "page") Integer page,
                                                          @RequestParam(required = false, value = "size") Integer size,
                                                          @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                                          @RequestParam(required = false, value = "orderType") String orderType);

}
