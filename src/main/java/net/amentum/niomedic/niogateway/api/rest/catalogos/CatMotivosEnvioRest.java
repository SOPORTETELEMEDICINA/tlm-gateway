package net.amentum.niomedic.niogateway.api.rest.catalogos;

import net.amentum.niomedic.catalogos.views.CatMotivosEnvioView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.catalogos.CatMotivosEnvioRestImpl;
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
@FeignClient(value = "http://nio-catalogos", fallback = CatMotivosEnvioRestImpl.class)
public interface CatMotivosEnvioRest {

   @GetMapping("catalogo-motivos-envio/{idCatMotivosEnvio}")
   CatMotivosEnvioView getDetailsByIdCatMotivosEnvio(@PathVariable("idCatMotivosEnvio") Integer idCatMotivosEnvio);

   @GetMapping("catalogo-motivos-envio/findAll")
   List<CatMotivosEnvioView> findAll();

   @GetMapping("catalogo-motivos-envio/search")
   Page<CatMotivosEnvioView> getCatMotivosEnvioSearch(@RequestParam(required = false, defaultValue = "", value = "datosBusqueda") String datosBusqueda,
                                                      @RequestParam(required = false, value = "activo") Boolean activo,
                                                      @RequestParam(required = false, defaultValue = "0", value = "page") Integer page,
                                                      @RequestParam(required = false, defaultValue = "10", value = "size") Integer size,
                                                      @RequestParam(required = false, defaultValue = "idCatMotivosEnvio", value = "orderColumn") String orderColumn,
                                                      @RequestParam(required = false, defaultValue = "asc", value = "orderType") String orderType);

   @PostMapping("catalogo-motivos-envio")
   CatMotivosEnvioView createCatMotivosEnvio(@RequestBody @Validated CatMotivosEnvioView catCatMotivosEnvioView);

   @PutMapping("catalogo-motivos-envio/{idCatMotivosEnvio}")
   CatMotivosEnvioView updateCatMotivosEnvio(@PathVariable("idCatMotivosEnvio") Integer idCatMotivosEnvio, @RequestBody @Validated CatMotivosEnvioView catCatMotivosEnvioView);

}
