package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;

import net.amentum.niomedic.expediente.views.MedicionesPacienteView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.expediente.MedicionesPacienteRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MedicionesPacienteRestImpl extends BaseController implements MedicionesPacienteRest {

   private Logger logger = LoggerFactory.getLogger(MedicionesPacienteRestImpl.class);

   public MedicionesPacienteView createMedicionesPaciente(MedicionesPacienteView medicionesPacienteView) {
      logger.error("Error al accesar al servicio para AGREGAR medicionesPaciente: {}", medicionesPacienteView);
      return null;
   }

   public MedicionesPacienteView updateMedicionesPaciente(Long idMedicionesPaciente, MedicionesPacienteView medicionesPacienteView) {
      logger.error("Error al accesar el servicio para MODIFICAR medicionesPaciente {} al idMedicionesPaciente {}", medicionesPacienteView, idMedicionesPaciente);
      return null;
   }

   public Page<MedicionesPacienteView> getMedicionesPacienteSearch(String idPaciente,
                                                                   Long startDate,
                                                                   Long endDate,
                                                                   Integer page,
                                                                   Integer size,
                                                                   String orderColumn,
                                                                   String orderType) {
      logger.error("Error al OBTENER PÁGINA de medicionesPaciente - idPaciente: {} - startDate: {} - endDate: {} - page: {} - size: {} - orderColumn: {} - orderType: {}",
         idPaciente, startDate, endDate, page, size, orderColumn, orderType);
      return null;
   }
}
