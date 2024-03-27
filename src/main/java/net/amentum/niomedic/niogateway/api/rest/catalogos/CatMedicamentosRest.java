package net.amentum.niomedic.niogateway.api.rest.catalogos;

import net.amentum.niomedic.catalogos.views.CatMedicamentosView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.catalogos.CatMedicamentosRestImpl;
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
@FeignClient(value = "http://nio-catalogos", fallback = CatMedicamentosRestImpl.class)
public interface CatMedicamentosRest {

   @GetMapping("catalogo-medicamentos/{idCatMedicamentos}")
   CatMedicamentosView getDetailsByIdCatMedicamentos(@PathVariable("idCatMedicamentos") Integer idCatMedicamentos);

   @GetMapping("catalogo-medicamentos/findAll")
   List<CatMedicamentosView> findAll();

   @GetMapping("catalogo-medicamentos/search")
   Page<CatMedicamentosView> getCatMedicamentosSearch(@RequestParam(required = false, defaultValue = "", value = "datosBusqueda") String datosBusqueda,
                                                      @RequestParam(required = false, value = "activo") Boolean activo,
                                                      @RequestParam(required = false, defaultValue = "0", value = "page") Integer page,
                                                      @RequestParam(required = false, defaultValue = "10", value = "size") Integer size,
                                                      @RequestParam(required = false, defaultValue = "idCatMedicamentos", value = "orderColumn") String orderColumn,
                                                      @RequestParam(required = false, defaultValue = "asc", value = "orderType") String orderType);

   @PostMapping("catalogo-medicamentos")
   CatMedicamentosView createCatMedicamentos(@RequestBody @Validated CatMedicamentosView catCatMedicamentosView);

   @PutMapping("catalogo-medicamentos/{idCatMedicamentos}")
   CatMedicamentosView updateCatMedicamentos(@PathVariable("idCatMedicamentos") Integer idCatMedicamentos, @RequestBody @Validated CatMedicamentosView catCatMedicamentosView);

}
