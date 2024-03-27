package net.amentum.niomedic.niogateway.api.rest.catalogos;

import net.amentum.niomedic.catalogos.views.CatSubtitulosCie10View;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.catalogos.CatSubtitulosCie10RestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@FeignClient(value = "http://nio-catalogos", fallback = CatSubtitulosCie10RestImpl.class)
public interface CatSubtitulosCie10Rest {

   @GetMapping("catalogo-subtitulos-cie10/{idCatSubtitulosCie10}")
   CatSubtitulosCie10View getDetailsByIdCatSubtitulosCie10(@PathVariable("idCatSubtitulosCie10") Integer idCatSubtitulosCie10);

   @GetMapping("catalogo-subtitulos-cie10/findAll")
   List<CatSubtitulosCie10View> findAll();

   @GetMapping("catalogo-subtitulos-cie10/search")
   Page<CatSubtitulosCie10View> getCatSubtitulosCie10Search(@RequestParam(required = false, defaultValue = "", value = "datosBusqueda") String datosBusqueda,
                                                            @RequestParam(required = false, value = "page") Integer page,
                                                            @RequestParam(required = false, value = "size") Integer size,
                                                            @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                                            @RequestParam(required = false, value = "orderType") String orderType);

}
