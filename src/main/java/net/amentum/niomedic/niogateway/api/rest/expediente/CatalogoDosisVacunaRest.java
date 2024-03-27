package net.amentum.niomedic.niogateway.api.rest.expediente;

import net.amentum.niomedic.expediente.views.CatalogoDosisVacunaView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.CatalogoDosisVacunaRestImpl;
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
@FeignClient(value = "http://nio-expediente", fallback = CatalogoDosisVacunaRestImpl.class)
public interface CatalogoDosisVacunaRest {

   @PostMapping("catalogo-vacuna/{idCatalogoVacuna}/catalogo-dosis-vacuna")
   void createCatalogoDosisVacuna(@PathVariable("idCatalogoVacuna") Long idCatalogoVacuna, @RequestBody @Validated CatalogoDosisVacunaView catalogoDosisVacunaView);

   @PutMapping("catalogo-vacuna/{idCatalogoVacuna}/catalogo-dosis-vacuna")
   void updateCatalogoDosisVacuna(@PathVariable("idCatalogoVacuna") Long idCatalogoVacuna, @RequestBody @Validated CatalogoDosisVacunaView catalogoDosisVacunaView);

   @DeleteMapping("catalogo-vacuna/{idCatalogoVacuna}/catalogo-dosis-vacuna")
   void deleteCatalogoDosisVacuna(@PathVariable("idCatalogoVacuna") Long idCatalogoVacuna);

   @GetMapping("catalogo-vacuna/{idCatalogoVacuna}/catalogo-dosis-vacuna")
   CatalogoDosisVacunaView getDetailsByIdCatalogoDosisVacuna(@PathVariable("idCatalogoVacuna") Long idCatalogoVacuna);

   @GetMapping("catalogo-vacuna/catalogo-dosis-vacuna/findAll")
   List<CatalogoDosisVacunaView> findAll(@RequestParam(required = false, value = "active") Boolean active);

   @GetMapping("catalogo-vacuna/catalogo-dosis-vacuna/page")
   Page<CatalogoDosisVacunaView> getCatalogoDosisVacunaPage(@RequestParam(required = false, value = "active") Boolean active,
                                                            @RequestParam(required = false, defaultValue = "", value = "name") String name,
                                                            @RequestParam(required = false, value = "page") Integer page,
                                                            @RequestParam(required = false, value = "size") Integer size,
                                                            @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                                            @RequestParam(required = false, value = "orderType") String orderType);


}

