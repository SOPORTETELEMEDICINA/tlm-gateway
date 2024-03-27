package net.amentum.niomedic.niogateway.api.rest.expediente;

import net.amentum.niomedic.expediente.views.DatosClinicosView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.DatosClinicosRestImpl;
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
@FeignClient(value = "http://nio-expediente", fallback = DatosClinicosRestImpl.class)
public interface DatosClinicosRest {

   @PostMapping("datos-clinicos")
   void createDatosClinicos(@RequestBody @Validated DatosClinicosView datosClinicosView);

   @PutMapping("datos-clinicos/{idPaciente}")
   void updateDatosClinicos(@PathVariable("idPaciente") String idPaciente, @RequestBody @Validated DatosClinicosView datosClinicosView);

   @DeleteMapping("datos-clinicos/{idPaciente}")
   void deleteDatosClinicos(@PathVariable("idPaciente") String idPaciente);

   @GetMapping("datos-clinicos/{idPaciente}")
   DatosClinicosView getDetailsByIdDatosClinicos(@PathVariable("idPaciente") String idPaciente);

   @GetMapping("datos-clinicos/findAll")
   List<DatosClinicosView> findAll(@RequestParam(required = false, value = "active") Boolean active);

   @GetMapping("datos-clinicos/page")
   Page<DatosClinicosView> getDatosClinicosPage(@RequestParam(required = false, value = "active") Boolean active,
                                                @RequestParam(required = false, defaultValue = "", value = "name") String name,
                                                @RequestParam(required = false, value = "page") Integer page,
                                                @RequestParam(required = false, value = "size") Integer size,
                                                @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                                @RequestParam(required = false, value = "orderType") String orderType);


}

