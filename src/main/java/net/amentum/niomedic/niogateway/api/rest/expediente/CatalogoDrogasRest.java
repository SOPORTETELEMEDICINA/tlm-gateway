package net.amentum.niomedic.niogateway.api.rest.expediente;

import net.amentum.niomedic.expediente.views.CatalogoDrogasView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.CatalogoDrogasRestImpl;
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
@FeignClient(value = "http://nio-expediente", fallback = CatalogoDrogasRestImpl.class)
public interface CatalogoDrogasRest {

   @PostMapping("catalogo-drogas")
   void createdCatalogoDrogas(@RequestBody @Validated CatalogoDrogasView catalogoDrogasView);

   @PutMapping("catalogo-drogas/{idCatalogoDroga}")
   void updateCatalogoDrogas(@PathVariable("idCatalogoDroga") Long idCatalogoDroga, @RequestBody @Validated CatalogoDrogasView catalogoDrogasView);

   @DeleteMapping("catalogo-drogas/{idCatalogoDroga}")
   void deleteCatalogoDrogas(@PathVariable("idCatalogoDroga") Long idCatalogoDroga);

   @GetMapping("catalogo-drogas/{idCatalogoDroga}")
   CatalogoDrogasView getDetailsByIdCatalogoDrogas(@PathVariable("idCatalogoDroga") Long idCatalogoDroga);

   @GetMapping("catalogo-drogas/findAll")
   List<CatalogoDrogasView> findAll(@RequestParam(required = false, value = "active") Boolean active);

   @GetMapping("catalogo-drogas/page")
   Page<CatalogoDrogasView> getCatalogoDrogasPage(@RequestParam(required = false, value = "active") Boolean active,
                                                  @RequestParam(required = false, defaultValue = "", value = "name") String name,
                                                  @RequestParam(required = false, value = "page") Integer page,
                                                  @RequestParam(required = false, value = "size") Integer size,
                                                  @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                                  @RequestParam(required = false, value = "orderType") String orderType);

}
