package net.amentum.niomedic.niogateway.api.rest.catalogos;

import net.amentum.niomedic.catalogos.views.CatMunicipiosDomView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.catalogos.CatMunicipiosDomRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@FeignClient(value = "http://nio-catalogos", fallback = CatMunicipiosDomRestImpl.class)
public interface CatMunicipiosDomRest {

   @GetMapping("catalogo-municipios/{idCatMunicipiosDom}")
   CatMunicipiosDomView getDetailsByIdCatMunicipiosDom(@PathVariable("idCatMunicipiosDom") Integer idCatMunicipiosDom);

   @GetMapping("catalogo-municipios/findAll")
   List<CatMunicipiosDomView> findAll();

   @GetMapping("catalogo-municipios/search")
   Page<CatMunicipiosDomView> getCatMunicipiosDomSearch(@RequestParam(required = false, defaultValue = "", value = "datosBusqueda") String datosBusqueda,
                                                        @RequestParam(required = false, value = "page") Integer page,
                                                        @RequestParam(required = false, value = "size") Integer size,
                                                        @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                                        @RequestParam(required = false, value = "orderType") String orderType);

}
