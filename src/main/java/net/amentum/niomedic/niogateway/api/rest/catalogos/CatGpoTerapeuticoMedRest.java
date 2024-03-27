package net.amentum.niomedic.niogateway.api.rest.catalogos;

import net.amentum.niomedic.catalogos.views.CatGpoTerapeuticoMedView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.catalogos.CatGpoTerapeuticoMedRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@FeignClient(value = "http://nio-catalogos", fallback = CatGpoTerapeuticoMedRestImpl.class)
public interface CatGpoTerapeuticoMedRest {

   @GetMapping("catalogo-grupo-terapeutico/{idCatGpoTerapeuticoMed}")
   CatGpoTerapeuticoMedView getDetailsByIdCatGpoTerapeuticoMed(@PathVariable("idCatGpoTerapeuticoMed") Integer idCatGpoTerapeuticoMed);

   @GetMapping("catalogo-grupo-terapeutico/findAll")
   List<CatGpoTerapeuticoMedView> findAll();

   @GetMapping("catalogo-grupo-terapeutico/search")
   Page<CatGpoTerapeuticoMedView> getCatGpoTerapeuticoMedSearch(@RequestParam(required = false, defaultValue = "", value = "datosBusqueda") String datosBusqueda,
                                                                @RequestParam(required = false, value = "page") Integer page,
                                                                @RequestParam(required = false, value = "size") Integer size,
                                                                @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                                                @RequestParam(required = false, value = "orderType") String orderType);

}
