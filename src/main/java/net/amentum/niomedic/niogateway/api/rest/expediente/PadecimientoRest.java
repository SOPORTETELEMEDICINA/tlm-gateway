package net.amentum.niomedic.niogateway.api.rest.expediente;

import net.amentum.niomedic.expediente.views.PadecimientoView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.PadecimientoRestImpl;
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
@FeignClient(value = "http://nio-expediente", fallback = PadecimientoRestImpl.class)
public interface PadecimientoRest {

   @PostMapping("padecimiento")
   void createPadecimiento(@RequestBody @Validated PadecimientoView padecimientoView);

   @PutMapping("padecimiento/{idPadecimiento}")
   void updatePadecimiento(@PathVariable("idPadecimiento") Long idPadecimiento, @RequestBody @Validated PadecimientoView padecimientoView);


   @DeleteMapping("padecimiento/{idPaciente}")
   void deletePadecimiento(@PathVariable("idPaciente") String idPaciente);

   @GetMapping("padecimiento/{idPadecimiento}")
   PadecimientoView getDetailsByIdPadecimiento(@PathVariable("idPadecimiento") Long idPadecimiento);

   @GetMapping("padecimiento/{idPadecimiento}/{idPaciente}")
   PadecimientoView getDetailsByIdPadecimientoAndIdPaciente(@PathVariable("idPadecimiento") Long idPadecimiento, @PathVariable("idPaciente") String idPaciente);

   @GetMapping("padecimiento/findAll")
   List<PadecimientoView> findAll(@RequestParam(required = false, value = "active") Boolean active);

   @GetMapping("padecimiento/page")
   Page<PadecimientoView> getPadecimientoPage(@RequestParam(required = false, value = "active") Boolean active,
                                              @RequestParam(required = false, defaultValue = "", value = "name") String name,
                                              @RequestParam(required = false, value = "page") Integer page,
                                              @RequestParam(required = false, value = "size") Integer size,
                                              @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                              @RequestParam(required = false, value = "orderType") String orderType);


}
