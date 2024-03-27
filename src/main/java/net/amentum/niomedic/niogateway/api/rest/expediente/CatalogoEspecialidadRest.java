package net.amentum.niomedic.niogateway.api.rest.expediente;

import net.amentum.niomedic.expediente.views.CatalogoEspecialidadView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.CatalogoEspecialidadRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//import org.springframework.data.domain.Page;

@RestController
@FeignClient(value = "http://nio-expediente", fallback = CatalogoEspecialidadRestImpl.class)
public interface CatalogoEspecialidadRest {

   @PostMapping("catalogo-especialidad")
   void createdCatalogoEspecialidad(@RequestBody @Validated CatalogoEspecialidadView catalogoEspecialidadView);

   @PutMapping("catalogo-especialidad/{idCatalogoEspecialidad}")
   void updateCatalogoEspecialidad(@PathVariable("idCatalogoEspecialidad") Long idCatalogoEspecialidad, @RequestBody @Validated CatalogoEspecialidadView catalogoEspecialidadView);

   @DeleteMapping("catalogo-especialidad/{idCatalogoEspecialidad}")
   void deleteCatalogoEspecialidad(@PathVariable("idCatalogoEspecialidad") Long idCatalogoEspecialidad);

   @GetMapping("catalogo-especialidad/{idCatalogoEspecialidad}")
   CatalogoEspecialidadView getDetailsByIdCatalogoEspecialidad(@PathVariable("idCatalogoEspecialidad") Long idCatalogoEspecialidad);

   @GetMapping("catalogo-especialidad/findAll")
   List<CatalogoEspecialidadView> findAll(@RequestParam(required = false, value = "active") Boolean active);

   @GetMapping("catalogo-especialidad/page")
   Page<CatalogoEspecialidadView> getCatalogoEspecialidadPage(@RequestParam(required = false, value = "active") Boolean active,
                                                              @RequestParam(required = false, defaultValue = "", value = "name") String name,
                                                              @RequestParam(required = false, value = "page") Integer page,
                                                              @RequestParam(required = false, value = "size") Integer size,
                                                              @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                                              @RequestParam(required = false, value = "orderType") String orderType);







}
