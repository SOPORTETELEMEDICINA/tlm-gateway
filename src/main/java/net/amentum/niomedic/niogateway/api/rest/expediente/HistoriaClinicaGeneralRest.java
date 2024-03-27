package net.amentum.niomedic.niogateway.api.rest.expediente;

import net.amentum.niomedic.expediente.views.HistoriaClinicaGeneralView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.HistoriaClinicaGeneralRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@FeignClient(value = "http://nio-expediente", fallback = HistoriaClinicaGeneralRestImpl.class)
public interface HistoriaClinicaGeneralRest {

   @PostMapping("historia-clinica")
   void createHistoriaClinicaGeneral(@RequestBody @Validated String json);

   @PutMapping("historia-clinica/{idPaciente}")
void updateHistoriaClinicaGeneral(@PathVariable("idPaciente") String idPaciente, @RequestBody @Validated String json);
//   void updateHistoriaClinicaGeneral(@PathVariable("idPaciente") UUID idPaciente, @RequestBody @Validated HistoriaClinicaGeneralView historiaClinicaGeneralView);
  @GetMapping("historia-clinica/{idPaciente}")
  HistoriaClinicaGeneralView getDetailsByIdPaciente(@PathVariable("idPaciente") String idPaciente);
//   HistoriaClinicaGeneralView getDetailsByIdPaciente(@PathVariable("idPaciente") UUID idPaciente);

}
