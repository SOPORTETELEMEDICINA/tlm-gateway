package net.amentum.niomedic.niogateway.api.rest.catalogos;

import net.amentum.niomedic.catalogos.views.CatEspecialidadesView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.catalogos.CatEspecialidadesRestImpl;
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
@FeignClient(value = "http://nio-catalogos", fallback = CatEspecialidadesRestImpl.class)
public interface CatEspecialidadesRest {

   @GetMapping("/catalogo-especialidades")  // Endpoint del servicio de catálogo
   List<CatEspecialidadesView> getEspecialidadesActivas();

   @GetMapping("catalogo-especialidades/{idCatEspecialidades}")
   CatEspecialidadesView getDetailsByIdCatEspecialidades(@PathVariable("idCatEspecialidades") Integer idCatEspecialidades);

   @GetMapping("catalogo-especialidades/findAll")
   List<CatEspecialidadesView> findAll();

   @GetMapping("catalogo-especialidades/search")
   Page<CatEspecialidadesView> getCatEspecialidadesSearch(@RequestParam(required = false, defaultValue = "", value = "datosBusqueda") String datosBusqueda,
                                                      @RequestParam(required = false, value = "activo") Boolean activo,
                                                      @RequestParam(required = false, defaultValue = "0", value = "page") Integer page,
                                                      @RequestParam(required = false, defaultValue = "10", value = "size") Integer size,
                                                      @RequestParam(required = false, defaultValue = "idCatEspecialidades", value = "orderColumn") String orderColumn,
                                                      @RequestParam(required = false, defaultValue = "asc", value = "orderType") String orderType);

   @PostMapping("catalogo-especialidades")
   CatEspecialidadesView createCatEspecialidades(@RequestBody @Validated CatEspecialidadesView catCatEspecialidadesView);

   @PutMapping("catalogo-especialidades/{idCatEspecialidades}")
   CatEspecialidadesView updateCatEspecialidades(@PathVariable("idCatEspecialidades") Integer idCatEspecialidades, @RequestBody @Validated CatEspecialidadesView catCatEspecialidadesView);

}
