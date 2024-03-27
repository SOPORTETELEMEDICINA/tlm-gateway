package net.amentum.niomedic.niogateway.api.rest.expediente;

import net.amentum.niomedic.expediente.views.CatalogoVacunaView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.CatalogoVacunaRestImpl;
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
@FeignClient(value = "http://nio-expediente", fallback = CatalogoVacunaRestImpl.class)
public interface CatalogoVacunaRest {

   @PostMapping("catalogo-vacuna")
   void createdCatalogoVacuna(@RequestBody @Validated CatalogoVacunaView catalogoVacunaView);

   @PutMapping("catalogo-vacuna/{idCatalogoVacuna}")
   void updateCatalogoVacuna(@PathVariable("idCatalogoVacuna") Long idCatalogoVacuna, @RequestBody @Validated CatalogoVacunaView catalogoVacunaView);

   @DeleteMapping("catalogo-vacuna/{idCatalogoVacuna}")
   void deleteCatalogoVacuna(@PathVariable("idCatalogoVacuna") Long idCatalogoVacuna);

   @GetMapping("catalogo-vacuna/{idCatalogoVacuna}")
   CatalogoVacunaView getDetailsByIdCatalogoVacuna(@PathVariable("idCatalogoVacuna") Long idCatalogoVacuna);

   @GetMapping("catalogo-vacuna/findAll")
   List<CatalogoVacunaView> findAll(@RequestParam(required = false, value = "active") Boolean active);

   @GetMapping("catalogo-vacuna/page")
   Page<CatalogoVacunaView> getCatalogoVacunaPage(@RequestParam(required = false, value = "active") Boolean active,
                                                  @RequestParam(required = false, defaultValue = "", value = "name") String name,
                                                  @RequestParam(required = false, value = "page") Integer page,
                                                  @RequestParam(required = false, value = "size") Integer size,
                                                  @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                                  @RequestParam(required = false, value = "orderType") String orderType);
}

