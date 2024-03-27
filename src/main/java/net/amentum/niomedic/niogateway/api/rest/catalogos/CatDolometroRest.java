package net.amentum.niomedic.niogateway.api.rest.catalogos;

import net.amentum.niomedic.catalogos.views.CatDolometroView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.catalogos.CatDolometroRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@FeignClient(value = "http://nio-catalogos", fallback = CatDolometroRestImpl.class)
public interface CatDolometroRest {

   @GetMapping("catalogo-dolometro/{idCatDolometro}")
   CatDolometroView getDetailsByIdCatDolometro(@PathVariable("idCatDolometro") Integer idCatDolometro);

   @GetMapping("catalogo-dolometro/findAll")
   List<CatDolometroView> findAll();

   @GetMapping("catalogo-dolometro/search")
   Page<CatDolometroView> getCatDolometroSearch(@RequestParam(required = false, defaultValue = "", value = "datosBusqueda") String datosBusqueda,
                                    @RequestParam(required = false, value = "page") Integer page,
                                    @RequestParam(required = false, value = "size") Integer size,
                                    @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                    @RequestParam(required = false, value = "orderType") String orderType);

}
