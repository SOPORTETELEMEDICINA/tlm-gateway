package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.catalogos.views.CatEstadoConsultaView;
import net.amentum.niomedic.expediente.views.ConsultaView;
import net.amentum.niomedic.expediente.views.SignosVitalesView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.expediente.ConsultaRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class ConsultaRestImpl extends BaseController implements ConsultaRest {

   private Logger logger = LoggerFactory.getLogger(ConsultaRestImpl.class);


   public ConsultaView createdConsulta(ConsultaView consultaView) {
      logger.error("Error al accesar al servicio para AGREGAR consulta: {}", consultaView);
      return null;
   }
   /*
   public void updateConsulta(Long numeroConsulta, ConsultaView consultaView) {
      logger.error("Error al accesar el servicio para MODIFICAR consulta: {} al número de consulta: {}", consultaView, numeroConsulta);
   }

   public ConsultaView getDetailsByNumeroConsulta(Long numeroConsulta) {
      logger.error("Error al accesar al servicio para OBTENER POR NúMERO CONSULTA del paciente {}", numeroConsulta);
      return null;
   }

   public List<ConsultaView> getAllByIdPadecimiento(Long idPadecimiento) {
      logger.error("Error al accesar al servicio para OBTENER TODOS por ID PADECIMIENTO");
      return null;
   }

   public List<ConsultaView> findAll() {
      logger.error("Error al accesar al servicio para OBTENER TODOS consulta");
      return null;
   }*/

   public Page<ConsultaView> getConsultaPage(String idPaciente,
		   									List<Long> idUsuario,
		   									 String idMedico,
                                             Integer page,
                                             Integer size,
                                             String orderColumn,
                                             String orderType,
                                             Long startDate,
                                             Long endDate,
											 Integer idGroup,
											 String name) {
      logger.error("Error al OBTENER PÁGINA de consulta - idPaciente: {} -idUsuario:{}- idMedico: {} - page: - {} size: {} - orderColumn: {} - orderType: {} - startDate: {} - endDate: {} - idGroup: {}",
         idPaciente,idUsuario, idMedico, page, size, orderColumn, orderType, startDate, endDate, idGroup);
      return null;
   }

   /*public void updateEstatus(Long numeroConsulta, String idEstatus, ConsultaView consultaView) {
      logger.error("Error al accesar al servicio para MODIFICAR status: {}, a la consulta número: {}, la consulta: {}",
         idEstatus, numeroConsulta, consultaView);
   }*/


   public Page<ConsultaView> getConsultasearch(String idPaciente,
		   									   List<Long> idUsuario,
		   									   String idMedico,
		   									   List<Integer> idEstadoConsulta,
		   									   Integer idTipoConsulta,
		   									   Integer page,
		   									   Integer size,
		   									   String orderColumn,
		   									   String orderType,
		   									   Long startDate,
		   									   Long endDate,
                                               Integer idGroup) {
		logger.error("Error al OBTENER PÁGINA de consulta - idPaciente: {} - idUsuario:{} - idMedico: {} - idEstadoConsulta:{} - idTipoConsulta:{} - page: - {} size: {} - orderColumn: {} - orderType: {} - startDate: {} - endDate: {}, idGroup={}",
	         idPaciente,idUsuario, idMedico,idEstadoConsulta,idTipoConsulta, page, size, orderColumn, orderType, startDate, endDate, idGroup);
        return null;
    }


	public ConsultaView getConsultaById(Long idConsulta) {
	   logger.error("Error al obtener de consulta por- idConsulta: {}", idConsulta); 
	   return null;
   }

	@Override
	public Page<HashMap<String, Object>> getConsultaByEstatus(String idMedico, Integer page, Integer size, String orderColumn, String orderType, Integer idGroup) {
		logger.error("Error al consultar los estatus");
		return null;
	}


	public void consultaStart(Long idConsulta,  CatEstadoConsultaView catEstadoConsultaView) {
	   logger.error("Error al Iniciar la consulta con el idConsulta: {}", idConsulta); 
   }


   public void consultaCancel(Long idConsulta,  CatEstadoConsultaView catEstadoConsultaView) {
	   logger.error("Error al Cancelar la consulta con el idConsulta: {}", idConsulta); 
   }


   public void consultareschedule(Long idConsulta, Long fechaConsulta, Long fechaConsultaFin,  CatEstadoConsultaView catEstadoConsultaView) {
	   logger.error("Error al Reagendar la consulta con el idConsulta: {}", idConsulta); 
   }


   public void consultaFinish(Long idConsulta, ConsultaView consultaView) {
	   logger.error("Error al Terminar la consulta con el idConsulta: {} - Consulta: {}", idConsulta, consultaView); 
   }


   public void updateConsulta(ConsultaView consultaView) {
	   logger.error("Error al Actualizar la Consulta: {}", consultaView); 
   }

@Override
public void signosVitales(Long idConsulta, SignosVitalesView signosVitales) {
	 logger.error("Error agregar los signos vitales a la consulta, id consulta:{}, SignosVitales:{}", idConsulta,signosVitales); 
	
}

	@Override
	public ConsultaView ultimaConsulta(String idPaciente, Integer idGroup) {
		logger.error("Error al obtener la ultima Consulta por idPaciente:{}", idPaciente); 
		return null;
	}

	@Override
	public void confirmarConsulta(Long idConsulta, CatEstadoConsultaView catEstadoConsultaView) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ConsultaView siguienteConsulta(String idPaciente) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void enfermeriaConsulta(Long idConsulta, CatEstadoConsultaView catEstadoConsultaView) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createCDA(Long idConsulta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String geturlImagen(Long idConsulta) {
		// TODO Auto-generated method stub
		return null;
	}



}
