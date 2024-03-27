package net.amentum.niomedic.niogateway.api.rest.fallback.pacientes;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.pacientes.DatosContactoRest;
import net.amentum.niomedic.pacientes.views.DatosContactoView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;


public class DatosContactoRestImpl extends BaseController implements DatosContactoRest {

   private Logger logger = LoggerFactory.getLogger(DatosContactoRestImpl.class);

   public void createDatosContacto(String idPaciente, ArrayList<DatosContactoView> datosContactoViewArrayList) {
      logger.error("Error al accesar al servicio para AGREGAR datos contacto: {} al paciente: {}", datosContactoViewArrayList, idPaciente);
   }

   public void deleteDatosContacto(String idPaciente, ArrayList<DatosContactoView> datosContactoViewArrayList) {
      logger.error("Error al accesar al servicio para BORRAR datos contacto: {} al paciente: {}", datosContactoViewArrayList, idPaciente);
   }

   public void updateDatosContacto(String idPaciente, ArrayList<DatosContactoView> datosContactoViewArrayList) {
      logger.error("Error al accesar al servicio para MODIFICAR datos contacto: {} al paciente: {}", datosContactoViewArrayList, idPaciente);
   }
}
