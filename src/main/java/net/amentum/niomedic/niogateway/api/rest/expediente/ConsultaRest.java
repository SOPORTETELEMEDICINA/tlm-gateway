package net.amentum.niomedic.niogateway.api.rest.expediente;

import net.amentum.niomedic.catalogos.views.CatEstadoConsultaView;
import net.amentum.niomedic.expediente.views.ConsultaView;
import net.amentum.niomedic.expediente.views.SignosVitalesView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.ConsultaRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

//@RestController
@FeignClient(value = "http://nio-expediente", fallback = ConsultaRestImpl.class)
public interface ConsultaRest {

   @PostMapping("consulta")
   ConsultaView createdConsulta(@RequestBody @Validated ConsultaView consultaView);

   @PutMapping("consulta")
   void updateConsulta(@RequestBody @Validated ConsultaView consultaView);
   
   /*@PutMapping("consulta/{numeroConsulta}")
   void updateConsulta(@PathVariable("numeroConsulta") Long numeroConsulta, @RequestBody @Validated ConsultaView consultaView);
   /*
    * Se comento para que no dierea problemas con el endPoint consulta/idConsultas
   
   //@GetMapping("consulta/{numeroConsulta}")
   //ConsultaView getDetailsByNumeroConsulta(@PathVariable("numeroConsulta") Long numeroConsulta);
   
   @GetMapping("consulta/por-padecimiento/{idPadecimiento}")
   List<ConsultaView> getAllByIdPadecimiento(@PathVariable("idPadecimiento") Long idPadecimiento);

   @GetMapping("consulta/findAll")
   List<ConsultaView> findAll();*/

   @GetMapping("consulta/page")
   Page<ConsultaView> getConsultaPage(@RequestParam(required = false, defaultValue = "", value = "idPaciente") String idPaciente,
		   							  @RequestParam(required = false, value = "idUsuario") List<Long> idUsuario,
		   							  @RequestParam(required = false, value = "idMedico") String idMedico,
                                      @RequestParam(required = false, value = "page") Integer page,
                                      @RequestParam(required = false, value = "size") Integer size,
                                      @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                      @RequestParam(required = false, value = "orderType") String orderType,
                                      @RequestParam(required = false, value = "startDate") Long startDate,
                                      @RequestParam(required = false, value = "endDate") Long endDate,
                                      @RequestParam(required = false, value = "idGroup") Integer idGroup,
                                      @RequestParam(required = false, value = "name") String name);

   /*@PutMapping("consulta/{numeroConsulta}/estatus/{idEstatus}")
   void updateEstatus(@PathVariable("numeroConsulta") Long numeroConsulta, @PathVariable("idEstatus") String idEstatus, @RequestBody @Validated ConsultaView consultaView);
   */
   @GetMapping("consulta/search")
   Page<ConsultaView> getConsultasearch(@RequestParam(required = false, defaultValue = "", value="idPaciente") String idPaciente,
				 @RequestParam(required = false, value="idUsuario") List<Long> idUsuario,
                 @RequestParam(required = false, value="idMedico") String idMedico,
                 @RequestParam(required = false, value="idEstadoConsulta") List<Integer> idEstadoConsulta,
                 @RequestParam(required = false, value="idTipoConsulta") Integer idTipoConsulta,
                 @RequestParam(required = false, value="page") Integer page,
                 @RequestParam(required = false, value="size") Integer size,
                 @RequestParam(required = false, value="orderColumn") String orderColumn,
                 @RequestParam(required = false, value="orderType") String orderType,
                 @RequestParam(required = false, value="startDate") Long startDate,
                 @RequestParam(required = false, value="endDate") Long endDate);

   @GetMapping("consulta/{idConsulta}")
   ConsultaView getConsultaById(@PathVariable("idConsulta") Long  idConsulta);

   @GetMapping("consulta/findAll")
   Page<HashMap<String, Object>> getConsultaByEstatus(@RequestParam(required = false, value = "idMedico") String idMedico,
                                                      @RequestParam(required = false, value = "page") Integer page,
                                                      @RequestParam(required = false, value = "size") Integer size,
                                                      @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                                      @RequestParam(required = false, value = "orderType") String orderType,
                                                      @RequestParam(value = "idGroup") Integer idGroup);
   
   @PutMapping("consulta/iniciar/{idConsulta}")
   void consultaStart(@PathVariable("idConsulta") Long idConsulta, @RequestBody @Validated CatEstadoConsultaView catEstadoConsultaView);
   
   @PutMapping("consulta/cancelar/{idConsulta}")
   void consultaCancel(@PathVariable("idConsulta") Long idConsulta, @RequestBody @Validated CatEstadoConsultaView catEstadoConsultaView);

   @PutMapping("consulta/reagendar/{idConsulta}")
   void consultareschedule(@PathVariable("idConsulta") Long idConsulta, 
		   				   @RequestParam(required = true, value="fechaConsulta") Long fechaConsulta,
		   				   @RequestParam(required = false, value="fechaConsultaFin") Long fechaConsultaFin,
		   				   @RequestBody @Validated CatEstadoConsultaView catEstadoConsultaView);
   
   @PutMapping("consulta/terminar/{idConsulta}")   
   void consultaFinish(@PathVariable("idConsulta") Long idConsulta, 
		   			   @RequestBody @Validated ConsultaView consultaView);
   
   @PutMapping("consulta/{idConsulta}/signosVitales")
   void signosVitales(@PathVariable("idConsulta") Long idConsulta,@RequestBody @Validated SignosVitalesView signosVitales);
   
   @GetMapping("consulta/ultima/{idPaciente}")
   ConsultaView ultimaConsulta(@PathVariable("idPaciente") String idPaciente,
                               @RequestParam(value = "idGroup") Integer idGroup);
   
   @PutMapping("consulta/confirmar/{idConsulta}")
   void confirmarConsulta(@PathVariable("idConsulta")Long idConsulta,@RequestBody @Validated CatEstadoConsultaView catEstadoConsultaView);
   
   @GetMapping("consulta/siguiente/{idPaciente}")
   ConsultaView siguienteConsulta(@PathVariable("idPaciente") String idPaciente);
   
   @PutMapping("consulta/enfermeria/{idConsulta}")
   void enfermeriaConsulta(@PathVariable("idConsulta") Long idConsulta, @RequestBody @Validated CatEstadoConsultaView catEstadoConsultaView);
   
   @PostMapping(value="consulta/CDA/{idConsulta}")
   void createCDA(@PathVariable("idConsulta") Long idConsulta);
   
   @GetMapping(value="consulta/{idConsulta}/urlImagen")
   String geturlImagen(@PathVariable("idConsulta") Long idConsulta);
   
}

