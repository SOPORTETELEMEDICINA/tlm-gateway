package net.amentum.niomedic.niogateway.api.rest.fallback.medicos;

import java.util.List; // Sre19062020 Nuevo

import net.amentum.niomedic.medicos.views.MedicoAgendaPageView;
import net.amentum.niomedic.medicos.views.MedicoPageView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.medicos.views.MedicoView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.medicos.MedicosRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


//import org.springframework.data.domain.Page;

public class MedicoRestImpl extends BaseController implements MedicosRest {

   private Logger logger = LoggerFactory.getLogger(MedicoRestImpl.class);

   public MedicoView createdMedico(MedicoView medicoView) {
      logger.error("Error al accesar al servicio para AGREGAR un médico: {}", medicoView);
      return null;
   }


   public MedicoView updateMedico(String idMedico, MedicoView medicoView) {
      logger.error("Error al accesar al servicio para MODIFICAR un médico: {}", medicoView);
      return null;
   }


   public MedicoView getDetailsByIdMedico(String idMedico) {
      logger.error("Error al accesar al servicio para OBTENER POR ID un médico: {}", idMedico);
      return null;
   }


   public MedicoView getDetailsByIdUsuario(Integer idUsuario) {
      logger.error("Error al accesar al servicio para OBTENER POR ID USUARIO un médico: {}", idUsuario);
      return null;
   }


//   public Page<MedicoView> getMedicoPage(Boolean active,
//                                         String name,
//                                         Integer page,
//                                         Integer size,
//                                         String orderColumn,
//                                         String orderType) {

   public Page<MedicoPageView> getMedicoPage(String datosBusqueda,
                                             Boolean active,
//                                              String name,
                                             Integer page,
                                             Integer size,
                                             String orderColumn,
                                             String orderType,
                                             Long selectGroup) {

      logger.error("Error al OBTENER PÁGINA de medicos - active: {} - page: - {} size: {} - orderColumn: {} - orderType: {} - selectGroup: {}",
         active, page, size, orderColumn, orderType, selectGroup); // GGR20200617 Agrego grupo seleccionado
//      return new Page<MedicoView>();
      return null;
   }

   public MedicoView getDetailsByUserName(String userName){
      logger.error("Error al accesar al servicio para OBTENER por USERNAME un médico: {}",userName);
      return null;
   }
   
    // Sre19062020 Nuevo para actualizar grupos de medicos
    public void updateMedicoGroups(Long idUserApp, List<Long> medicoGroups) {
        logger.error("Error al accesar al servicio para actualizar grupos de un médico: {}", idUserApp);
    }

   @Override
   public Page<MedicoAgendaPageView> getDetailsByEspecialidad(String nombreEspecialidad, Integer page, Integer size, String orderColumn, String orderType) {
      logger.error("Error al accesar al servicio para obtener médicos por especialidad");
      return null;
   }
}

