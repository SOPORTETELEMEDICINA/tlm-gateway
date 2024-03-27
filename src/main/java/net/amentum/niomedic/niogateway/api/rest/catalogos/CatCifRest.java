package net.amentum.niomedic.niogateway.api.rest.catalogos;

import net.amentum.niomedic.catalogos.views.CatCifView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.catalogos.CatCifRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@FeignClient(value = "http://nio-catalogos", fallback = CatCifRestImpl.class)
public interface CatCifRest {

   @GetMapping("catalogo-discapacidades/{idCatCif}")
   CatCifView getDetailsByIdCatCif(@PathVariable("idCatCif") Integer idCatCif);

   @GetMapping("catalogo-discapacidades/findAll")
   List<CatCifView> findAll();

   @GetMapping("catalogo-discapacidades/search")
   Page<CatCifView> getCatCifSearch(@RequestParam(required = false, defaultValue = "", value = "datosBusqueda") String datosBusqueda,
                                     @RequestParam(required = false, value = "activo") Boolean activo,
                                     @RequestParam(required = false, defaultValue = "0", value = "page") Integer page,
                                     @RequestParam(required = false, defaultValue = "10", value = "size") Integer size,
                                     @RequestParam(required = false, defaultValue = "idCatCif", value = "orderColumn") String orderColumn,
                                     @RequestParam(required = false, defaultValue = "asc", value = "orderType") String orderType);

   @PostMapping("catalogo-discapacidades")
   CatCifView createCatCif(@RequestBody @Validated CatCifView catCatCifView);

   @PutMapping("catalogo-discapacidades/{idCatCif}")
   CatCifView updateCatCif(@PathVariable("idCatCif") Integer idCatCif, @RequestBody @Validated CatCifView catCatCifView);

}
