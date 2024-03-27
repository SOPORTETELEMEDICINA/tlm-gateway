package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.expediente.views.HistoriaClinicaGeneralView;
import net.amentum.niomedic.niogateway.api.rest.expediente.HistoriaClinicaGeneralRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.UUID;

public class HistoriaClinicaGeneralRestImpl extends BaseController implements HistoriaClinicaGeneralRest {
//public class HistoriaClinicaGeneralRestImpl implements HistoriaClinicaGeneralRest {

   private Logger logger = LoggerFactory.getLogger(HistoriaClinicaGeneralRestImpl.class);

   @Override
   public void createHistoriaClinicaGeneral(String json){
      logger.error("Error al accesar al servicio para AGREGAR un historia clinica general: {}", json);
   }


//   public void updateHistoriaClinicaGeneral(UUID idPaciente, HistoriaClinicaGeneralView historiaClinicaGeneralView){
   public void updateHistoriaClinicaGeneral(String idPaciente, String json){
      logger.error("Error al accesar al servicio para MODIFICAR un historia clinica general {} al paciente {}", json, idPaciente);
   }


//   public HistoriaClinicaGeneralView getDetailsByIdPaciente(UUID idPaciente){
   public HistoriaClinicaGeneralView getDetailsByIdPaciente(String idPaciente){
      logger.error("Error al accesar al servicio para OBTENER POR ID historia clinica general del paciente {}", idPaciente);
      return null;
   }

}
