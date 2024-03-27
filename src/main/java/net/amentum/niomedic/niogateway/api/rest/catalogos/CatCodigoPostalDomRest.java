package net.amentum.niomedic.niogateway.api.rest.catalogos;

import net.amentum.niomedic.catalogos.views.CatCodigoPostalDomView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.catalogos.CatCodigoPostalDomRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@FeignClient(value = "http://nio-catalogos", fallback = CatCodigoPostalDomRestImpl.class)
public interface CatCodigoPostalDomRest {

   @GetMapping("catalogo-codigo-postal/{idCatCodigoPostalDom}")
   CatCodigoPostalDomView getDetailsByIdCatCodigoPostalDom(@PathVariable("idCatCodigoPostalDom") Long idCatCodigoPostalDom);

   @GetMapping("catalogo-codigo-postal/findAll")
   List<CatCodigoPostalDomView> findAll();

   @GetMapping("catalogo-codigo-postal/search")
   Page<CatCodigoPostalDomView> getCatCodigoPostalDomSearch(@RequestParam(required = false, defaultValue = "", value = "datosBusqueda") String datosBusqueda,
                                                            @RequestParam(required = false, value = "page") Integer page,
                                                            @RequestParam(required = false, value = "size") Integer size,
                                                            @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                                            @RequestParam(required = false, value = "orderType") String orderType);

}
