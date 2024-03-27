//package net.amentum.niomedic.niogateway.api.rest;
//
//import net.amentum.common.BaseController;
//import net.amentum.niomedic.expediente.views.ConsultaView;
//import net.amentum.niomedic.expediente.views.EventosView;
//import net.amentum.niomedic.niogateway.api.rest.expediente.ConsultaRest;
//import net.amentum.niomedic.niogateway.api.rest.expediente.EventosRest;
//import net.amentum.niomedic.niogateway.exception.ApiErrorDecoder;
//import net.amentum.niomedic.niogateway.exception.ConsultaEventoException;
//import net.amentum.niomedic.niogateway.views.ConsultaEventoView;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("consulta-evento")
//public class ConsultaEventoCompositeRest extends BaseController {
//   private final Logger logger = LoggerFactory.getLogger(ConsultaEventoCompositeRest.class);
//
//   @Autowired
//   private ApiErrorDecoder apiErrorDecoder;
//
//   @Autowired
//   private ConsultaRest consultaRest;
//
//   @Autowired
//   private EventosRest eventosRest;
//
//   @PostMapping
//   public void createConsultaEvento(@RequestBody @Validated ConsultaEventoView consultaEventoView) throws ConsultaEventoException {
//      boolean bandera = true;
//      ConsultaView consultaView = consultaEventoView.getConsultaView();
//      EventosView eventoView = consultaEventoView.getEventosView();
//
//      eventoView.setInicio(consultaView.getFechaInicio());
//      eventoView.setFin(consultaView.getFeachaFin());
//      eventoView.setTitulo(consultaView.getTipoConsulta() + " " + consultaView.getNombrePaciente() + " " + consultaView.getMotivoConsulta());
//
//      try {
//         logger.info("===>>>Guardando nueva consulta: {}", consultaView);
//         consultaRest.createdConsulta(consultaView);
//      } catch (Exception ex) {
//         logger.error("No se pudo INSERTAR nueva consulta: {}", consultaView);
//         bandera = false;
//         ConsultaEventoException ceE = new ConsultaEventoException("Error", ConsultaEventoException.LAYER_REST, ConsultaEventoException.ACTION_INSERT);
//         ceE.addError("No se pudo INSERTAR nueva consulta: " + apiErrorDecoder.toString().replace('\"', ' '));
//         throw ceE;
//
//      }
//      if (bandera) {
//         logger.info("===>>>Guardando nuevo evento: {}", eventoView);
//         eventosRest.createEventos(eventoView);
//      }
//   }
//
//   @PutMapping()
//   public void updateConsultaEvento(@RequestBody @Validated ConsultaEventoView consultaEventoView) throws ConsultaEventoException {
//      Long idUsuarioConsulta = (consultaEventoView.getConsultaView().getIdUsuario() != null) ? consultaEventoView.getConsultaView().getIdUsuario() : null;
//      Long idUsuarioEvento = (consultaEventoView.getEventosView().getIdUsuario() != null) ? consultaEventoView.getEventosView().getIdUsuario() : null;
//      try {
//         if (idUsuarioConsulta != null && idUsuarioEvento != null) {
//            if (idUsuarioConsulta == idUsuarioEvento) {
//               logger.info("===>>>Modificando consulta: {} y evento: {}", consultaEventoView.getConsultaView().getIdConsulta(), consultaEventoView.getEventosView().getIdEventos());
//               consultaRest.updateConsulta(consultaEventoView.getConsultaView());
//               eventosRest.updateEventos(consultaEventoView.getEventosView().getIdEventos(), consultaEventoView.getEventosView());
//            }else{
//               logger.error("===>>>IdUsario diferentes consulta: {} y evento: {}", consultaEventoView.getConsultaView().getIdConsulta(), consultaEventoView.getEventosView().getIdEventos());
//               ConsultaEventoException ceE = new ConsultaEventoException("Error", ConsultaEventoException.LAYER_REST, ConsultaEventoException.ACTION_UPDATE);
//               ceE.addError("IdUsario diferentes, No se pudo MODIFICAR consulta-evento: " + apiErrorDecoder.toString().replace('\"', ' '));
//               throw ceE;
//            }
//         }else{
//            logger.error("===>>>IdUsario vacios consulta: {} y evento: {}", consultaEventoView.getConsultaView().getIdConsulta(), consultaEventoView.getEventosView().getIdEventos());
//            ConsultaEventoException ceE = new ConsultaEventoException("Error", ConsultaEventoException.LAYER_REST, ConsultaEventoException.ACTION_UPDATE);
//            ceE.addError("IdUsario vacios, No se pudo MODIFICAR consulta-evento: " + apiErrorDecoder.toString().replace('\"', ' '));
//            throw ceE;
//         }
//
//      } catch (Exception ex) {
//         logger.error("No se pudo MODIFICAR consulta: {} y evento: {}", consultaEventoView.getConsultaView().getIdConsulta(), consultaEventoView.getEventosView().getIdEventos());
//         ConsultaEventoException ceE = new ConsultaEventoException("Error", ConsultaEventoException.LAYER_REST, ConsultaEventoException.ACTION_UPDATE);
//         ceE.addError("No se pudo MODIFICAR consulta-evento: " + apiErrorDecoder.toString().replace('\"', ' '));
//         throw ceE;
//      }
//   }
//}
