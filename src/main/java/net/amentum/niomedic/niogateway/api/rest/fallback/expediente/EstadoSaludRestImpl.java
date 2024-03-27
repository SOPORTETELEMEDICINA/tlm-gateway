package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;

import net.amentum.niomedic.expediente.views.EstadoSaludView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.expediente.EstadoSaludRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class EstadoSaludRestImpl extends BaseController implements EstadoSaludRest {

   private Logger logger = LoggerFactory.getLogger(EstadoSaludRestImpl.class);

   public EstadoSaludView createEstadoSalud(EstadoSaludView estadoSaludView) {
      logger.error("Error al accesar al servicio para AGREGAR estadoSalud: {}", estadoSaludView);
      return null;
   }

   public EstadoSaludView updateEstadoSalud(Long idEstadoSalud, EstadoSaludView estadoSaludView) {
      logger.error("Error al accesar el servicio para MODIFICAR estadoSalud {} al idEstadoSalud {}", estadoSaludView, idEstadoSalud);
      return null;
   }


   public Page<EstadoSaludView> getEstadoSaludPage(String idPaciente,
                                             Long startDate,
                                             Long endDate,
                                             Integer page,
                                             Integer size,
                                             String orderColumn,
                                             String orderType) {
      logger.error("Error al OBTENER PÁGINA de estadoSalud - idPaciente: {} - startDate: {} - endDate: {} - page: {} - size: {} - orderColumn: {} - orderType: {}",
         idPaciente, startDate, endDate, page, size, orderColumn, orderType);
      return null;
   }

   public EstadoSaludView getLastEstadoSalud(String idPaciente){
      logger.error("Error al accesar al servicio para OBTENER POR ID paciente {}", idPaciente);
      return null;
   }

}
