package net.amentum.niomedic.niogateway.api.rest.catalogos;

import net.amentum.niomedic.catalogos.views.CatTipoAsentamientoDomView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.catalogos.CatTipoAsentamientoDomRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@FeignClient(value = "http://nio-catalogos", fallback = CatTipoAsentamientoDomRestImpl.class)
public interface CatTipoAsentamientoDomRest {

   @GetMapping("catalogo-tipo-asentamiento/{idCatTipoAsentamientoDom}")
   CatTipoAsentamientoDomView getDetailsByIdCatTipoAsentamientoDom(@PathVariable("idCatTipoAsentamientoDom") Integer idCatTipoAsentamientoDom);

   @GetMapping("catalogo-tipo-asentamiento/findAll")
   List<CatTipoAsentamientoDomView> findAll();

   @GetMapping("catalogo-tipo-asentamiento/search")
   Page<CatTipoAsentamientoDomView> getCatTipoAsentamientoDomSearch(@RequestParam(required = false, defaultValue = "", value = "datosBusqueda") String datosBusqueda,
                                                                    @RequestParam(required = false, value = "page") Integer page,
                                                                    @RequestParam(required = false, value = "size") Integer size,
                                                                    @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                                                    @RequestParam(required = false, value = "orderType") String orderType);

}
