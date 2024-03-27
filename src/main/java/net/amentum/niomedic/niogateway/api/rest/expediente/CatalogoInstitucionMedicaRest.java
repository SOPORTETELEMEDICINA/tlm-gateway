package net.amentum.niomedic.niogateway.api.rest.expediente;

import net.amentum.niomedic.expediente.views.CatalogoInstitucionMedicaView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.CatalogoInstitucionMedicaRestImpl;
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
@FeignClient(value = "http://nio-expediente", fallback = CatalogoInstitucionMedicaRestImpl.class)
public interface CatalogoInstitucionMedicaRest {

   @PostMapping("catalogo-institucion-medica")
   void createdCatalogoInstitucionMedica(@RequestBody @Validated CatalogoInstitucionMedicaView catalogoInstitucionMedicaView);

   @PutMapping("catalogo-institucion-medica/{idCatalogoInstitucionMedica}")
   void updateCatalogoInstitucionMedica(@PathVariable("idCatalogoInstitucionMedica") Long idCatalogoInstitucionMedica, @RequestBody @Validated CatalogoInstitucionMedicaView catalogoInstitucionMedicaView);

   @DeleteMapping("catalogo-institucion-medica/{idCatalogoInstitucionMedica}")
   void deleteCatalogoInstitucionMedica(@PathVariable("idCatalogoInstitucionMedica") Long idCatalogoInstitucionMedica);

   @GetMapping("catalogo-institucion-medica/{idCatalogoInstitucionMedica}")
   CatalogoInstitucionMedicaView getDetailsByIdCatalogoInstitucionMedica(@PathVariable("idCatalogoInstitucionMedica") Long idCatalogoInstitucionMedica);

   @GetMapping("catalogo-institucion-medica/findAll")
   List<CatalogoInstitucionMedicaView> findAll(@RequestParam(required = false, value = "active") Boolean active);

   @GetMapping("catalogo-institucion-medica/page")
   Page<CatalogoInstitucionMedicaView> getCatalogoInstitucionMedicaPage(@RequestParam(required = false, value = "active") Boolean active,
                                                                        @RequestParam(required = false, defaultValue = "", value = "name") String name,
                                                                        @RequestParam(required = false, value = "page") Integer page,
                                                                        @RequestParam(required = false, value = "size") Integer size,
                                                                        @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                                                        @RequestParam(required = false, value = "orderType") String orderType);


}

