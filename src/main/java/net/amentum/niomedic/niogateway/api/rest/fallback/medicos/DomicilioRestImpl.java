package net.amentum.niomedic.niogateway.api.rest.fallback.medicos;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.medicos.DomicilioRest;
import net.amentum.niomedic.medicos.views.DomicilioView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;


public class DomicilioRestImpl extends BaseController implements DomicilioRest {

   private Logger logger = LoggerFactory.getLogger(DomicilioRestImpl.class);

   public void createDomicilio(String idMedico, ArrayList<DomicilioView> domicilioViewArrayList) {
      logger.error("Error al accesar al servicio para AGREGAR domicilio: {} al médico: {}", domicilioViewArrayList, idMedico);
   }

   public void updateDomicilio(String idMedico, ArrayList<DomicilioView> domicilioViewArrayList) {
      logger.error("Error al accesar al servicio para MODIFICAR domicilio: {} al médico: {}", domicilioViewArrayList, idMedico);
   }

   public void deleteDomicilio(String idMedico, ArrayList<DomicilioView> domicilioViewArrayList) {
      logger.error("Error al accesar al servicio para BORRAR domicilio: {} al médico: {}", domicilioViewArrayList, idMedico);
   }
}

