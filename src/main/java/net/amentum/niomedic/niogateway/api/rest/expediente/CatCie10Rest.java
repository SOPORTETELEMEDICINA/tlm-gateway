package net.amentum.niomedic.niogateway.api.rest.expediente;


import net.amentum.niomedic.expediente.views.CatCie10FiltradoView;
import net.amentum.niomedic.expediente.views.CatCie10View;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.CatCie10RestImpl;
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
@FeignClient(value = "http://nio-expediente", fallback = CatCie10RestImpl.class)
public interface CatCie10Rest {

   @GetMapping("cat-cie10/{idCie10}")
   CatCie10View getDetailsByIdCie10(@PathVariable("idCie10") Long idCie10);

   @GetMapping("cat-cie10/findAll")
   List<CatCie10FiltradoView> findAll();

   @GetMapping("cat-cie10/search")
   Page<CatCie10FiltradoView> getCatCie10Search(@RequestParam(required = false, defaultValue = "", value = "datosBusqueda") String datosBusqueda,
                                                @RequestParam(required = false, value = "activo") Boolean activo,
                                                @RequestParam(required = false, defaultValue = "0", value = "page") Integer page,
                                                @RequestParam(required = false, defaultValue = "10", value = "size") Integer size,
                                                @RequestParam(required = false, defaultValue = "nombre", value = "orderColumn") String orderColumn,
                                                @RequestParam(required = false, defaultValue = "asc", value = "orderType") String orderType);

   @PostMapping("cat-cie10")
   CatCie10View createCatCie10(@RequestBody @Validated CatCie10View catCie10View);

   @PutMapping("cat-cie10/{idCie10}")
   CatCie10View updateCatCie10(@PathVariable("idCie10") Long idCie10, @RequestBody @Validated CatCie10View catCie10View);

}