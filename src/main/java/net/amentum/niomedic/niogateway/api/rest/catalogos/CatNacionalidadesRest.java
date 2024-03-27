package net.amentum.niomedic.niogateway.api.rest.catalogos;

import net.amentum.niomedic.catalogos.views.CatNacionalidadesView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.catalogos.CatNacionalidadesRestImpl;
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

import javax.validation.Valid;

@RestController
@FeignClient(value = "http://nio-catalogos", fallback = CatNacionalidadesRestImpl.class)
public interface CatNacionalidadesRest {

   @GetMapping("catalogo-nacionalidades/{idCatNacionalidades}")
   CatNacionalidadesView getDetailsByIdCatNacionalidades(@PathVariable("idCatNacionalidades") Integer idCatNacionalidades);

   @GetMapping("catalogo-nacionalidades/findAll")
   List<CatNacionalidadesView> findAll();

   @GetMapping("catalogo-nacionalidades/search")
   Page<CatNacionalidadesView> getCatNacionalidadesSearch(@RequestParam(required = false, defaultValue = "", value = "datosBusqueda") String datosBusqueda,
		   												  @RequestParam(required = false, value = "activo") Boolean activo,
		   												  @RequestParam(required = false, value = "page", defaultValue = "0") Integer page,
                                                          @RequestParam(required = false, value = "size", defaultValue = "10") Integer size,
                                                          @RequestParam(required = false, value = "orderColumn", defaultValue = "nacPaisDescripcion") String orderColumn,
                                                          @RequestParam(required = false, value = "orderType", defaultValue = "asc") String orderType);
   @PostMapping("catalogo-nacionalidades")
   CatNacionalidadesView createCatNacionalidades(@RequestBody @Validated CatNacionalidadesView catNacionalidadesView);

   @PutMapping("catalogo-nacionalidades/{idCatNacionalidades}")
   CatNacionalidadesView updateCatNacionalidades(@PathVariable("idCatNacionalidades")Integer idCatNacionalidades, @RequestBody @Valid CatNacionalidadesView catNacionalidadesView);
   

}
