package net.amentum.niomedic.niogateway.api.rest.expediente;

import net.amentum.niomedic.expediente.views.CatalogoServicioMedicoView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.CatalogoServicioMedicoRestImpl;
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
@FeignClient(value = "http://nio-expediente", fallback = CatalogoServicioMedicoRestImpl.class)
public interface CatalogoServicioMedicoRest {

   @PostMapping("catalogo-servicio-medico")
   void createdCatalogoServicioMedico(@RequestBody @Validated CatalogoServicioMedicoView catalogoServicioMedicoView);

   @PutMapping("catalogo-servicio-medico/{idCatalogoServicioMedico}")
   void updateCatalogoServicioMedico(@PathVariable("idCatalogoServicioMedico") Long idCatalogoServicioMedico, @RequestBody @Validated CatalogoServicioMedicoView catalogoServicioMedicoView);

   @DeleteMapping("catalogo-servicio-medico/{idCatalogoServicioMedico}")
   void deleteCatalogoServicioMedico(@PathVariable("idCatalogoServicioMedico") Long idCatalogoServicioMedico);

   @GetMapping("catalogo-servicio-medico/{idCatalogoServicioMedico}")
   CatalogoServicioMedicoView getDetailsByIdCatalogoServicioMedico(@PathVariable("idCatalogoServicioMedico") Long idCatalogoServicioMedico);

   @GetMapping("catalogo-servicio-medico/findAll")
   List<CatalogoServicioMedicoView> findAll(@RequestParam(required = false, value = "active") Boolean active);

   @GetMapping("catalogo-servicio-medico/page")
   Page<CatalogoServicioMedicoView> getCatalogoServicioMedicoPage(@RequestParam(required = false, value = "active") Boolean active,
                                                                  @RequestParam(required = false, defaultValue = "", value = "name") String name,
                                                                  @RequestParam(required = false, value = "page") Integer page,
                                                                  @RequestParam(required = false, value = "size") Integer size,
                                                                  @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                                                  @RequestParam(required = false, value = "orderType") String orderType);
}

