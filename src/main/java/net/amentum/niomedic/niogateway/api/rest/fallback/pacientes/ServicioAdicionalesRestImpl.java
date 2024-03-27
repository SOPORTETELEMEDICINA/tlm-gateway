package net.amentum.niomedic.niogateway.api.rest.fallback.pacientes;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.pacientes.ServicioAdicionalesRest;
import net.amentum.niomedic.pacientes.views.ServicioAdicionalesView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class ServicioAdicionalesRestImpl extends BaseController implements ServicioAdicionalesRest {

   private Logger logger = LoggerFactory.getLogger(ServicioAdicionalesRestImpl.class);

   public void createServicioAdicionales(String idPaciente, ArrayList<ServicioAdicionalesView> servicioAdicionalesViewArrayList){
      logger.error("Error al accesar al servicio para AGREGAR servicio adicionales: {} al paciente: {}", servicioAdicionalesViewArrayList, idPaciente);
   }

   public void updateServicioAdicionales(String idPaciente, ArrayList<ServicioAdicionalesView> servicioAdicionalesViewArrayList){
      logger.error("Error al accesar al servicio para MODIFICAR servicio adicionales: {} al paciente: {}", servicioAdicionalesViewArrayList, idPaciente);
   }

   public void deleteServicioAdicionales(String idPaciente, ArrayList<ServicioAdicionalesView> servicioAdicionalesViewArrayList){
      logger.error("Error al accesar al servicio para BORRAR servicio adicionales: {} al paciente: {}", servicioAdicionalesViewArrayList, idPaciente);
   }


}
