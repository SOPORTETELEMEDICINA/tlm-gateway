package net.amentum.niomedic.niogateway.api.rest.catalogos;

import net.amentum.niomedic.catalogos.views.CatCuadroIoMedView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.catalogos.CatCuadroIoMedRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@FeignClient(value = "http://nio-catalogos", fallback = CatCuadroIoMedRestImpl.class)
public interface CatCuadroIoMedRest {

   @GetMapping("catalogo-cuadroIO/{idCatCuadroIoMed}")
   CatCuadroIoMedView getDetailsByIdCatCuadroIoMed(@PathVariable("idCatCuadroIoMed") Integer idCatCuadroIoMed);

   @GetMapping("catalogo-cuadroIO/findAll")
   List<CatCuadroIoMedView> findAll();

   @GetMapping("catalogo-cuadroIO/search")
   Page<CatCuadroIoMedView> getCatCuadroIoMedSearch(@RequestParam(required = false, defaultValue = "", value = "datosBusqueda") String datosBusqueda,
                                                    @RequestParam(required = false, value = "page") Integer page,
                                                    @RequestParam(required = false, value = "size") Integer size,
                                                    @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                                    @RequestParam(required = false, value = "orderType") String orderType);

}
