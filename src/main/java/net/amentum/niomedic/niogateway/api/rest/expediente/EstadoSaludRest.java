package net.amentum.niomedic.niogateway.api.rest.expediente;

import net.amentum.niomedic.expediente.views.EstadoSaludView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.EstadoSaludRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@FeignClient(value = "http://nio-expediente", fallback = EstadoSaludRestImpl.class)
public interface EstadoSaludRest {

   @PostMapping("estado-salud")
   EstadoSaludView createEstadoSalud(@RequestBody @Validated EstadoSaludView estadoSaludView);

   @PutMapping("estado-salud/{idEstadoSalud}")
   EstadoSaludView updateEstadoSalud(@PathVariable("idEstadoSalud") Long idEstadoSalud, @RequestBody @Validated EstadoSaludView estadoSaludView);

   @GetMapping("estado-salud/page")
   Page<EstadoSaludView> getEstadoSaludPage(@RequestParam(required = false, value = "idPaciente") String idPaciente,
                                            @RequestParam(required = false, value = "startDate") Long startDate,
                                            @RequestParam(required = false, value = "endDate") Long endDate,
                                            @RequestParam(required = false, value = "page") Integer page,
                                            @RequestParam(required = false, value = "size") Integer size,
                                            @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                            @RequestParam(required = false, value = "orderType") String orderType);

   @GetMapping("estado-salud/ultimo/{idPaciente}")
   EstadoSaludView getLastEstadoSalud(@PathVariable("idPaciente") String idPaciente);

}
