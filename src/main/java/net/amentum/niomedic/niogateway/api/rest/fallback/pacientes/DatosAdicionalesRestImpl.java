package net.amentum.niomedic.niogateway.api.rest.fallback.pacientes;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.pacientes.DatosAdicionalesRest;
import net.amentum.niomedic.pacientes.views.DatosAdicionalesView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DatosAdicionalesRestImpl extends BaseController implements DatosAdicionalesRest {

   private Logger logger = LoggerFactory.getLogger(DatosAdicionalesRestImpl.class);

   public void createdDatosAdicionales(String idPaciente, DatosAdicionalesView datosAdicionalesView){
      logger.error("Error al accesar al servicio para AGREGAR datos adicionales: {} al paciente: {}", datosAdicionalesView, idPaciente);
   }

   public void updateDatosAdicionales(String idPaciente, DatosAdicionalesView datosAdicionalesView){
      logger.error("Error al accesar al servicio para MODIFICAR datos adicionales: {} al paciente: {}", datosAdicionalesView, idPaciente);
   }



}