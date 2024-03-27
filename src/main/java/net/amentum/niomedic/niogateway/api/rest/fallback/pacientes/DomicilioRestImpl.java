package net.amentum.niomedic.niogateway.api.rest.fallback.pacientes;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.pacientes.DomicilioRest;
import net.amentum.niomedic.pacientes.views.DomicilioView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;


public class DomicilioRestImpl extends BaseController implements DomicilioRest {

   private Logger logger = LoggerFactory.getLogger(DomicilioRestImpl.class);

   public void createDomicilio(String idPaciente, ArrayList<DomicilioView> domicilioViewArrayList) {
      logger.error("Error al accesar al servicio para AGREGAR domicilio: {} al paciente: {}", domicilioViewArrayList, idPaciente);
   }

   public void updateDomicilio(String idPaciente, ArrayList<DomicilioView> domicilioViewArrayList) {
      logger.error("Error al accesar al servicio para MODIFICAR domicilio: {} al paciente: {}", domicilioViewArrayList, idPaciente);
   }

   public void deleteDomicilio(String idPaciente, ArrayList<DomicilioView> domicilioViewArrayList) {
      logger.error("Error al accesar al servicio para BORRAR domicilio: {} al paciente: {}", domicilioViewArrayList, idPaciente);
   }
}

