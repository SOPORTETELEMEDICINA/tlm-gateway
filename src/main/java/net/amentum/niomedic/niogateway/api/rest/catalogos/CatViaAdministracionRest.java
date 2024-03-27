package net.amentum.niomedic.niogateway.api.rest.catalogos;

import net.amentum.niomedic.catalogos.views.CatViaAdministracionView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.catalogos.CatViaAdministracionRestImpl;
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
@FeignClient(value = "http://nio-catalogos", fallback = CatViaAdministracionRestImpl.class)
public interface CatViaAdministracionRest {

   @GetMapping("catalogo-via-administracion/{idCatViaAdministracion}")
   CatViaAdministracionView getDetailsByIdCatViaAdministracion(@PathVariable("idCatViaAdministracion") Integer idCatViaAdministracion);

   @GetMapping("catalogo-via-administracion/findAll")
   List<CatViaAdministracionView> findAll();

   @GetMapping("catalogo-via-administracion/search")
   Page<CatViaAdministracionView> getCatViaAdministracionSearch(@RequestParam(required = false, defaultValue = "", value = "datosBusqueda") String datosBusqueda,
		   														@RequestParam(required = false, value ="activo") Boolean activo,
                                                                @RequestParam(required = false, defaultValue = "0",value = "page") Integer page,
                                                                @RequestParam(required = false, defaultValue = "10",value = "size") Integer size,
                                                                @RequestParam(required = false, defaultValue = "vaDescripcion",value = "orderColumn") String orderColumn,
                                                                @RequestParam(required = false, defaultValue = "asc",value = "orderType") String orderType);
   @PostMapping("catalogo-via-administracion")
   CatViaAdministracionView createCatViaAdministracion(@RequestBody @Validated CatViaAdministracionView catViaAdministracion);
   
   @PutMapping("catalogo-via-administracion/{idCatViaAdministracion}")
   CatViaAdministracionView updateCatViaAdministracion(@PathVariable("idCatViaAdministracion") Integer idCatViaAdministracion,@RequestBody @Validated CatViaAdministracionView catViaAdministracion);
}
