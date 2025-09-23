package net.amentum.niomedic.niogateway.api.secured;

import net.amentum.niomedic.catalogos.views.CatEstadoConsultaView;
import net.amentum.niomedic.expediente.views.ConsultaView;
import net.amentum.niomedic.expediente.views.EventosView;
import net.amentum.niomedic.expediente.views.PadecimientoView;
import net.amentum.niomedic.expediente.views.SignosVitalesView;
import net.amentum.niomedic.medicos.views.MedicoView;
import net.amentum.niomedic.niogateway.api.rest.expediente.PadecimientoRest;
import net.amentum.niomedic.niogateway.api.rest.ApiZoom;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.expediente.ConsultaRest;
import net.amentum.niomedic.niogateway.api.rest.expediente.EventosRest;
import net.amentum.niomedic.niogateway.api.rest.medicos.MedicosRest;
import net.amentum.niomedic.niogateway.api.rest.pacientes.PacienteRest;
import net.amentum.niomedic.niogateway.exception.ZoomException;
import net.amentum.niomedic.niogateway.views.ConsultaEventoView;
import net.amentum.niomedic.pacientes.views.PacienteView;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.esotericsoftware.minlog.Log;

import net.amentum.common.GenericException;

import javax.validation.Valid;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("consulta")
public class ConsultaRestApi extends BaseController {

   @Autowired
   private ConsultaRest consultaRest;

   @Autowired
   private SecurityHandlerProvider securityHandlerProvider;

   @Autowired
   private EventosRest eventosRest;

   @Autowired
   private PacienteRest pacienteRest;

   @Autowired
   private MedicosRest medicosRest;
   
   @Autowired
   private ApiZoom apiZoom;
   
   @Autowired
   PadecimientoRest PadecimientoRest;
   

   private final Logger logger = LoggerFactory.getLogger(ConsultaRestApi.class);

   @PostMapping
   ConsultaView createdConsulta(@RequestBody @Validated ConsultaView consultaView, HttpServletRequest request) throws  Exception, ZoomException {
      String decrypted = securityHandlerProvider.decryptHeader(request);
      logger.info("createdConsulta() - Obteniendo id usuario");
      Long idUser = securityHandlerProvider.getHierarchy("ID", decrypted).get(0);
      logger.info("createdConsulta() - id Usuario:{}", idUser);
      consultaView.setIdUsuario(idUser);
      consultaView.getFechaConsulta();
      consultaView.setConsultaHis(Boolean.FALSE);
      Map<String, Object> infoMeeting = new HashMap<String, Object>();
      String linkMeeting="";
      Long idTipoUsuario = securityHandlerProvider.getHierarchy("TU", decrypted).get(0);
      String idUsuarioZoom = null;

//      Medico
      if (idTipoUsuario == 2) {
         logger.info("createdConsulta() - Obteniendo idUsuario del paciente");
         MedicoView medicoView = medicosRest.getDetailsByIdMedico(consultaView.getIdMedico().toString());
         logger.info("createdConsulta() - Obteniendo idUsuario e idUsuarioZomm del medico");
         idUsuarioZoom = medicoView.getIdUsuarioZoom();
         consultaView.setIdUsuario(medicoView.getIdUsuario());
      }
//      Paciente
      if (idTipoUsuario == 3) {
         MedicoView medicoView = medicosRest.getDetailsByIdMedico(consultaView.getIdMedico().toString());
         logger.info("createdConsulta() - Obteniendo idUsuario e idUsuarioZomm del medico");
         idUsuarioZoom = medicoView.getIdUsuarioZoom();
         consultaView.setIdUsuario(medicoView.getIdUsuario());
      }
//      otros
      if (idTipoUsuario != 2 && idTipoUsuario != 3) {
    	 logger.info("createdConsulta() - Obteniendo idUsuario del medico y del paciente");
         MedicoView medicoView = medicosRest.getDetailsByIdMedico(consultaView.getIdMedico().toString());
         idUsuarioZoom = medicoView.getIdUsuarioZoom();
      }
      
      if(consultaView.getIdTipoConsulta()==2 || consultaView.getIdTipoConsulta()==3) {
    	  if(consultaView.getIdMedicoSolicitado()==null) {
    		  ZoomException ee = new ZoomException("Error de validación al crear la Consulta.", ZoomException.LAYER_DAO, ZoomException.ACTION_VALIDATE);
    		  ee.addError("idMedicoSolicitado no puede se nulo");
    		  logger.error("createdConsulta() - idMedicoSolicitado viene nulo");
    		  throw ee;
    	  }
      }
      if((consultaView.getIdTipoConsulta() == 2 || consultaView.getIdTipoConsulta() == 3)) {
    	  logger.info("createdConsulta() - Obteniendo idusuario e idUsuarioZoom del medico solicitado");
    	  MedicoView medicoView = medicosRest.getDetailsByIdMedico(consultaView.getIdMedicoSolicitado().toString());
    	  idUsuarioZoom = medicoView.getIdUsuarioZoom();
    	  consultaView.setIdUsuario(medicoView.getIdUsuario());
      }
      
      if(consultaView.getCanal().equalsIgnoreCase("Video consulta")) {
    	  if(idUsuarioZoom==null || idUsuarioZoom.isEmpty()) {
    		  ZoomException ee = new ZoomException("Error de validación al crear la Consulta.", ZoomException.LAYER_DAO, ZoomException.ACTION_VALIDATE);
    		  ee.addError("El médico con el id: "+consultaView.getIdMedico()+" no cuenta con un idUsuarioZoom");
    		  logger.error("createdConsulta() - El médico con el id: "+consultaView.getIdMedico()+" no cuenta con un idUsuarioZoom");
    		  throw ee;
    	  }
    	  logger.info("createConsulta() - Creado evento en Zoom para consulta de tipo video Consulta"); 
    	  infoMeeting= apiZoom.crearMeeting("Niomedic - Orientación médica.", consultaView.getFechaConsulta(), consultaView.getMotivoConsulta(), idUsuarioZoom.trim());
    	  linkMeeting= (String) infoMeeting.get("join_url");
    	  consultaView.setMeeting(linkMeeting);
    	  Long id = (Long) infoMeeting.get("id");
    	  consultaView.setIdMeeting(id.longValue());
      }
      ConsultaEventoView consultaEventoView = new ConsultaEventoView();
      ConsultaView consultaReturn = null;
      try {
         consultaReturn = this.consultaRest.createdConsulta(consultaView);
      } catch (Exception ex) {
         logger.error("===>>>Error al crear la consulta");
      }
      return consultaReturn;
   } 
  
   
   @PutMapping
   void updateConsulta(@RequestBody @Validated ConsultaView consultaView, HttpServletRequest request) throws Exception {
      String decrypted = securityHandlerProvider.decryptHeader(request);
      logger.info("updateConsulta() - Obteniendo idusuario");
      Long idUser = securityHandlerProvider.getHierarchy("ID", decrypted).get(0);
      logger.info("updateConsulta() - id Usuario:{}", idUser);
      consultaView.setIdUsuario(idUser);
      this.consultaRest.updateConsulta(consultaView);
   }

   @GetMapping("/page")
   Page<ConsultaView> getConsultaPage(
      HttpServletRequest request,
      @RequestParam(required = false, defaultValue = "", value = "idPaciente") String idPaciente,
      @RequestParam(required = false, value = "idUsuario") List<Long> idUsuario,
      @RequestParam(required = false, value = "idMedico") String idMedico,
      @RequestParam(required = false, value = "page") Integer page,
      @RequestParam(required = false, value = "size") Integer size,
      @RequestParam(required = false, value = "orderColumn") String orderColumn,
      @RequestParam(required = false, value = "orderType") String orderType,
      @RequestParam(required = false, value = "startDate") Long startDate,
      @RequestParam(required = false, value = "endDate") Long endDate,
      @RequestParam(required = false, value = "idGroup") Integer idGroup,
      @RequestParam(required = false, value = "name") String name) throws Exception {
      if ((idPaciente == null || idPaciente.isEmpty()) && (idMedico == null || idMedico.isEmpty())) {
         logger.info("getConsultaPage() - idMedico e idPaciente vienen vacíos, obteniendo idUsuarios");
         String decrypted = securityHandlerProvider.decryptHeader(request);
         idUsuario = securityHandlerProvider.getHierarchy("UA", decrypted);
         logger.info("getConsultaPage() - Lista de usuarios:{}", idUsuario);
      }
      logger.info("getConsultaPage() - Obtener listado Consulta paginable: - idPaciente {} - idUsuario:{} - idMedico {} - page {} - size: {} - orderColumn: {} - orderType: {} - startDate: {}  - endDate: {} - idGroup: {}",
         idPaciente, idUsuario, idMedico, page, size, orderColumn, orderType, startDate, endDate, idGroup);
      return this.consultaRest.getConsultaPage(idPaciente, idUsuario, idMedico, page, size, orderColumn, orderType, startDate, endDate, idGroup, name);
   }

   @GetMapping("/search")
   Page<ConsultaView> getConsultasearch(HttpServletRequest request,
                                        @RequestParam(required = false, defaultValue = "", value = "idPaciente") String idPaciente,
                                        @RequestParam(required = false, value = "idUsuario") List<Long> idUsuario,
                                        @RequestParam(required = false, value = "idMedico") String idMedico,
                                        @RequestParam(required = false, value = "idEstadoConsulta") List<Integer> idEstadoConsulta,
                                        @RequestParam(required = false, value = "idTipoConsulta") Integer idTipoConsulta,
                                        @RequestParam(required = false, value = "page") Integer page,
                                        @RequestParam(required = false, value = "size") Integer size,
                                        @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                        @RequestParam(required = false, value = "orderType") String orderType,
                                        @RequestParam(required = false, value = "startDate") Long startDate,
                                        @RequestParam(required = false, value = "endDate") Long endDate,
                                        @RequestParam(required = false, value="idGroup") Integer idGroup) throws Exception {
      if ((idPaciente == null || idPaciente.isEmpty()) && (idMedico == null || idMedico.isEmpty())) {
         logger.info("getConsultasearch() - idMedico e idPaciente vienen vacíos, obteniendo idUsuarios");
         String decrypted = securityHandlerProvider.decryptHeader(request);
         idUsuario = securityHandlerProvider.getHierarchy("UA", decrypted);
         logger.info("getConsultasearch() - Lista de usuarios:{}", idUsuario);
      }
      logger.info("getConsultasearch() - Obtener listado Consulta paginable: - idPaciente {} - idUsuario:{} - idEstadoConsulta:{} - idTipoConsulta:{} - idMedico {} - page {} - size: {} - orderColumn: {} - orderType: {} - startDate: {}  - endDate: {} - idGroup: {}",
         idPaciente, idUsuario, idMedico, idEstadoConsulta, idTipoConsulta, page, size, orderColumn, orderType, startDate, endDate, idGroup);
      return this.consultaRest.getConsultasearch(idPaciente, idUsuario, idMedico, idEstadoConsulta, idTipoConsulta, page, size, orderColumn, orderType, startDate, endDate, idGroup);
   }

   @GetMapping("/{idConsulta}")
   ConsultaView getConsultaById(@PathVariable("idConsulta") Long idConsulta) {
      return this.consultaRest.getConsultaById(idConsulta);
   }


   @PutMapping("/iniciar/{idConsulta}")
   void consultaStart(@PathVariable("idConsulta") Long idConsulta, @RequestBody @Validated CatEstadoConsultaView catEstadoConsultaView) {
      this.consultaRest.consultaStart(idConsulta, catEstadoConsultaView);
   }

   @PutMapping("/cancelar/{idConsulta}")
   void consultaCancel(@PathVariable("idConsulta") Long idConsulta, @RequestBody @Validated CatEstadoConsultaView catEstadoConsultaView) throws GenericException, Exception {
	   this.consultaRest.consultaCancel(idConsulta, catEstadoConsultaView);
	   ConsultaView view = this.consultaRest.getConsultaById(idConsulta);
	   if(view.getCanal().equalsIgnoreCase("Video consulta")) {
		   if(view.getIdMeeting()!=null) {
			   apiZoom.cancelarMeeting(view.getIdMeeting());
		   }
	   }
   }

   @PutMapping("/reagendar/{idConsulta}")
   void consultareschedule(@PathVariable("idConsulta") Long idConsulta,
		   				   @RequestParam(required = true, value = "fechaConsulta") Long fechaConsulta,
		   				   @RequestParam(required = false, value = "fechaConsultaFin") Long fechaConsultaFin,
		   				   @RequestBody @Validated CatEstadoConsultaView catEstadoConsultaView) throws GenericException, Exception {
	   Long sumado30minutosLong = null;
	   try {
		   if (fechaConsultaFin == null) {
			   Date fechaConsultaTemporal = new Date(fechaConsulta);
			   final long ONE_MINUTE_IN_MILLIS = 60000;//millisecs
			   Calendar calendar = Calendar.getInstance();
			   calendar.setTime(fechaConsultaTemporal);
			   Long temporal = calendar.getTimeInMillis();
			   Date sumado30minutos = new Date(temporal + (30 * ONE_MINUTE_IN_MILLIS));
			   sumado30minutosLong = sumado30minutos.getTime();
		   } else {
			   sumado30minutosLong = fechaConsultaFin;
		   }
		   this.consultaRest.consultareschedule(idConsulta, fechaConsulta, sumado30minutosLong, catEstadoConsultaView);

	   } catch (Exception ex) {
		   logger.error("===>>>Error al reagendar la consulta");
	   }
	   try {
		   EventosView tempo = this.eventosRest.getDetailsByIdConsulta(idConsulta);
		   this.eventosRest.rescheduleEventos(tempo.getIdEventos(), fechaConsulta, sumado30minutosLong);
		   ConsultaView view = this.consultaRest.getConsultaById(idConsulta);
		   if(view.getCanal().equalsIgnoreCase("Video consulta")) {
			   if(view.getIdMeeting()!=null) {
				   apiZoom.reagedarMeeting(view.getIdMeeting(), new Date(fechaConsulta));
			   }
		   }
	   } catch (Exception ex) {
		   logger.error("===>>>Error al reagendar el evento");
	   }
   }

   @PutMapping("/terminar/{idConsulta}")
   void consultaFinish(@PathVariable("idConsulta") Long idConsulta,
                       @RequestBody @Validated ConsultaView consultaView, HttpServletRequest request) throws Exception {
      String decrypted = securityHandlerProvider.decryptHeader(request);
      logger.info("consultaFinish() - Obteniendo idusuario");
      Long idUser = securityHandlerProvider.getHierarchy("ID", decrypted).get(0);
      logger.info("consultaFinish() - id Usuario:{}", idUser);
      consultaView.setIdUsuario(idUser);
      this.consultaRest.consultaFinish(idConsulta, consultaView);
   }

   @PutMapping("/{idConsulta}/signosVitales")
   void signosVitales(@PathVariable("idConsulta") Long idConsulta, @RequestBody @Validated SignosVitalesView signosVitales) {
      this.consultaRest.signosVitales(idConsulta, signosVitales);
   }

   @GetMapping("/ultima/{idPaciente}")
   ConsultaView ultimaConsulta(@PathVariable("idPaciente") String idPaciente,
                               @RequestParam(value = "idGroup") Integer idGroup) {
      return this.consultaRest.ultimaConsulta(idPaciente, idGroup);
   }

   @PutMapping("/confirmar/{idConsulta}")
   void confirmarConsulta(@PathVariable("idConsulta") Long idConsulta, @RequestBody @Valid CatEstadoConsultaView catEstadoConsultaView) {
      this.consultaRest.confirmarConsulta(idConsulta, catEstadoConsultaView);
   }

   @GetMapping("/siguiente/{idPaciente}")
   ConsultaView siguienteConsulta(@PathVariable("idPaciente") String idPaciente) {
      return this.consultaRest.siguienteConsulta(idPaciente);
   }

   @PutMapping("/enfermeria/{idConsulta}")
   void enfermeriaConsulta(@PathVariable("idConsulta") Long idConsulta, @RequestBody @Validated CatEstadoConsultaView catEstadoConsultaView) {
      this.consultaRest.enfermeriaConsulta(idConsulta, catEstadoConsultaView);
   }

   @PostMapping("/CDA/{idConsulta}")
   void createCDA(@PathVariable("idConsulta") Long idConsulta) {
      this.consultaRest.createCDA(idConsulta);
   }
   
   
   @GetMapping(value="/{idConsulta}/urlImagen")
   String geturlImagen(@PathVariable("idConsulta") Long idConsulta) {
	  return this.consultaRest.geturlImagen(idConsulta);
   }

    @GetMapping(value = "/findAll")
    Page<HashMap<String, Object>> getConsultaByEstatus(@RequestParam(required = false, value = "idMedico") String idMedico,
                                                       @RequestParam(required = false, value = "page") Integer page,
                                                       @RequestParam(required = false, value = "size") Integer size,
                                                       @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                                       @RequestParam(required = false, value = "orderType") String orderType,
                                                       @RequestParam(value = "idGroup") Integer idGroup) {
       return this.consultaRest.getConsultaByEstatus(idMedico, page, size, orderColumn, orderType, idGroup);
    }
   
   private String bodyEvento(ConsultaView view) {
	   String padecimientos = "";
	   String body="";
	   if(view.getIdTipoConsulta()==1) {
		   body="Motivo consulta: "+view.getMotivoConsulta();
	   }else if(view.getIdTipoConsulta()==4) {
		   body="Motivo consulta: "+view.getMotivoConsulta();
		   while(view.getListaPadecimiento().contains(null)) {
			   view.getListaPadecimiento().remove(null);
		   } 
		   for(PadecimientoView p:view.getListaPadecimiento()) {
			   PadecimientoView padecimiento=PadecimientoRest.getDetailsByIdPadecimiento(p.getIdPadecimiento());
			   padecimientos = padecimientos + "\n" +padecimiento.getNombrePadecimiento();
		   }
		   body=body+"\nPadecimiento:"+ padecimientos;
	   }else if(view.getIdTipoConsulta() == 3) {
		   body = "Motivo del envio: " + view.getMotivoEnvio();
		   body = body + "\nServicio: " + view.getServicio();
		   if(view.getUrgente() != null) {
			   body = body + "\nUrgente: " + (view.getUrgente() ? "SI" : "NO"); 
		   }
		   if(view.getSamu() != null) {
			   body = body + "\nSamu: " + (view.getSamu()? "SI" : "NO"); 
		   }
		   body=body+"\nMotivo consulta: "+view.getMotivoConsulta();
		   while(view.getListaPadecimiento().contains(null)) {
			   view.getListaPadecimiento().remove(null);
		   } 
		   for(PadecimientoView p:view.getListaPadecimiento()) {
			   PadecimientoView padecimiento=PadecimientoRest.getDetailsByIdPadecimiento(p.getIdPadecimiento());
			   padecimientos = padecimientos + "\n" +padecimiento.getNombrePadecimiento();
		   }
		   body=body+"\nPadecimiento:"+ padecimientos;
	   } else if (view.getIdTipoConsulta() == 2) {
		   body="Motivo consulta: "+view.getMotivoConsulta();
		   while(view.getListaPadecimiento().contains(null)) {
			   view.getListaPadecimiento().remove(null);
		   } 
		   for(PadecimientoView p:view.getListaPadecimiento()) {
			   PadecimientoView padecimiento=PadecimientoRest.getDetailsByIdPadecimiento(p.getIdPadecimiento());
			   padecimientos = padecimientos + "\n" +padecimiento.getNombrePadecimiento();
		   }
		   body=body+"\nPadecimiento:"+ padecimientos;
	   }
	   return body;
   }
}
