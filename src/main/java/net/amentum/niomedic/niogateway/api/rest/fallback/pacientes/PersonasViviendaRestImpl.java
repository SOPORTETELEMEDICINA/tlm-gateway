package net.amentum.niomedic.niogateway.api.rest.fallback.pacientes;


import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.pacientes.PersonasViviendaRest;
import net.amentum.niomedic.pacientes.views.PersonasViviendaView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class PersonasViviendaRestImpl extends BaseController implements PersonasViviendaRest {

   private Logger logger = LoggerFactory.getLogger(PersonasViviendaRestImpl.class);

   public void createPersonasVivienda(String idPaciente, ArrayList<PersonasViviendaView> personasViviendaViewArrayList){
      logger.error("Error al accesar al servicio para AGREGAR personas vivienda: {} al paciente: {}", personasViviendaViewArrayList, idPaciente);
   }

   public void updatePersonasVivienda(String idPaciente, ArrayList<PersonasViviendaView> personasViviendaViewArrayList){
      logger.error("Error al accesar al servicio para MODIFICAR personas vivienda: {} al paciente: {}", personasViviendaViewArrayList, idPaciente);
   }

   public void deletePersonasVivienda(String idPaciente, ArrayList<PersonasViviendaView> personasViviendaViewArrayList){
      logger.error("Error al accesar al servicio para BORRAR personas vivienda: {} al paciente: {}", personasViviendaViewArrayList, idPaciente);
   }
}
