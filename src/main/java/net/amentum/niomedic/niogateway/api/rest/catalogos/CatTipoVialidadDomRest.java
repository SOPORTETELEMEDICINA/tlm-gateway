package net.amentum.niomedic.niogateway.api.rest.catalogos;

import net.amentum.niomedic.catalogos.views.CatTipoVialidadDomView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.catalogos.CatTipoVialidadDomRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@FeignClient(value = "http://nio-catalogos", fallback = CatTipoVialidadDomRestImpl.class)
public interface CatTipoVialidadDomRest {

   @GetMapping("catalogo-tipo-vialidad/{idCatTipoVialidadDom}")
   CatTipoVialidadDomView getDetailsByIdCatTipoVialidadDom(@PathVariable("idCatTipoVialidadDom") Integer idCatTipoVialidadDom);

   @GetMapping("catalogo-tipo-vialidad/findAll")
   List<CatTipoVialidadDomView> findAll();

   @GetMapping("catalogo-tipo-vialidad/search")
   Page<CatTipoVialidadDomView> getCatTipoVialidadDomSearch(@RequestParam(required = false, defaultValue = "", value = "datosBusqueda") String datosBusqueda,
                                                            @RequestParam(required = false, value = "page") Integer page,
                                                            @RequestParam(required = false, value = "size") Integer size,
                                                            @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                                            @RequestParam(required = false, value = "orderType") String orderType);

}
