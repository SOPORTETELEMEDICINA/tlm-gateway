package net.amentum.niomedic.niogateway.api.rest.expediente;

import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.EventosRestImpl;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.ReportesRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@FeignClient(value = "http://nio-expediente", fallback = ReportesRestImpl.class)
public interface ReportesRest {

   @GetMapping("reportes/solicitud-servicios/{idConsulta}")
   String getSolicitudServicios(@PathVariable("idConsulta") Long idConsulta);

   @GetMapping("reportes/referencia/{idConsulta}")
   String getReferencia(@PathVariable("idConsulta") Long idConsulta);

   @GetMapping("reportes/notas-medicas/{idConsulta}/{idGroup}")
   String getNotasMedicasPresc(@PathVariable("idConsulta") Long idConsulta, @PathVariable("idGroup") Long idGroup); //GGR20200622 agrego idGroup

   // Sre03072020 Dejé este para que siga funcionando en Baja y en Puebla:
   @GetMapping("reportes/notas-medicas/{idConsulta}")
   String getNotasMedicasPresc(@PathVariable("idConsulta") Long idConsulta);

   @GetMapping("reportes/notas-evolucion/{idConsulta}")
   String getNotasEvolucion(@PathVariable("idConsulta") Long idConsulta);

//   @GetMapping("reportes/solicitud-estudios/{idConsulta}")
//   String getSolicitudEstudios(@PathVariable("idConsulta") Long idConsulta);
   // GGR20200803 agrego idGroup
   @GetMapping("reportes/solicitud-estudios/{idConsulta}/{folio}/{idGroup}")
   String getSolicitudEstudios(@PathVariable("idConsulta") Long idConsulta, @PathVariable("folio") Long folio, @PathVariable("idGroup") Long idGroup);

   @GetMapping("reportes/receta/{idConsulta}/{idGroup}")
   String getReceta(@PathVariable("idConsulta") Long idConsulta, @PathVariable("idGroup") Long idGroup); //GGR20200622 agerego idGroup

   @GetMapping("reportes/contrarreferencia/{idConsulta}")
   String getContrarreferencia(@PathVariable("idConsulta") Long idConsulta);

   @GetMapping("reportes/consentimiento-informado/{idConsulta}")
   String getConsentimiento(@PathVariable("idConsulta") Long idConsulta);

   @GetMapping("reportes/notas-interconsulta/{idConsulta}")
   String getNotasInterconsulta(@PathVariable("idConsulta") Long idConsulta);

   @GetMapping("reportes/historia-clinica/{idPaciente}")
   String getHistoriaClinica(@PathVariable("idPaciente") String idPaciente);

}
