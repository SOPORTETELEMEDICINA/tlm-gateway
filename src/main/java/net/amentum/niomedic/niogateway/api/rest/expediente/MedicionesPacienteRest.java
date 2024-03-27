package net.amentum.niomedic.niogateway.api.rest.expediente;


import net.amentum.niomedic.expediente.views.MedicionesPacienteView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.MedicionesPacienteRestImpl;
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
@FeignClient(value = "http://nio-expediente", fallback = MedicionesPacienteRestImpl.class)
public interface MedicionesPacienteRest {

   @PostMapping("mediciones-paciente")
   MedicionesPacienteView createMedicionesPaciente(@RequestBody @Validated MedicionesPacienteView medicionesPacienteView);

   @PutMapping("mediciones-paciente/{idMedicionesPaciente}")
   MedicionesPacienteView updateMedicionesPaciente(@PathVariable("idMedicionesPaciente") Long idMedicionesPaciente, @RequestBody @Validated MedicionesPacienteView medicionesPacienteView);

   @GetMapping("mediciones-paciente/search")
   Page<MedicionesPacienteView> getMedicionesPacienteSearch(@RequestParam(required = true, value="idPaciente") String idPaciente,
                                                            @RequestParam(required = false, value="startDate") Long startDate,
                                                            @RequestParam(required = false, value="endDate") Long endDate,
                                                            @RequestParam(required = false, value="page") Integer page,
                                                            @RequestParam(required = false, value="size") Integer size,
                                                            @RequestParam(required = false, value="orderColumn") String orderColumn,
                                                            @RequestParam(required = false, value="orderType") String orderType);


}
