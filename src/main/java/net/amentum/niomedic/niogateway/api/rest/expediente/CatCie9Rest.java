package net.amentum.niomedic.niogateway.api.rest.expediente;

import net.amentum.niomedic.expediente.views.CatCie9FiltradoView;
import net.amentum.niomedic.expediente.views.CatCie9View;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.CatCie9RestImpl;
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
@FeignClient(value = "http://nio-expediente", fallback = CatCie9RestImpl.class)
public interface CatCie9Rest {

   @GetMapping("cat-cie9/{idCie9}")
   CatCie9View getDetailsByIdCie9(@PathVariable("idCie9") Long idCie9);

   @GetMapping("cat-cie9/findAll")
   List<CatCie9FiltradoView> findAll();

   @GetMapping("cat-cie9/search")
   Page<CatCie9FiltradoView> getCatCie9Search(@RequestParam(required = false, defaultValue = "", value = "datosBusqueda") String datosBusqueda,
                                              @RequestParam(required = false, value = "activo") Boolean activo,
                                              @RequestParam(required = false, defaultValue = "0", value = "page") Integer page,
                                              @RequestParam(required = false, defaultValue = "10", value = "size") Integer size,
                                              @RequestParam(required = false, defaultValue = "proNombre", value = "orderColumn") String orderColumn,
                                              @RequestParam(required = false, defaultValue = "asc", value = "orderType") String orderType,
                                              @RequestParam(required = false, defaultValue = "", value = "sexo") String sexo,
                                              @RequestParam(required = false, defaultValue = "0", value = "edad") Integer edad);


   @PostMapping("cat-cie9")
   CatCie9View createCatCie9(@RequestBody @Validated CatCie9View catCie9View);

   @PutMapping("cat-cie9/{idCie9}")
   CatCie9View updateCatCie9(@PathVariable("idCie9") Long idCie9, @RequestBody @Validated CatCie9View catCie9View);

}
