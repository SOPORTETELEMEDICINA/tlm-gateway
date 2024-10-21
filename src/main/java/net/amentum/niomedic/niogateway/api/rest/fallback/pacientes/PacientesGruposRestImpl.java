package net.amentum.niomedic.niogateway.api.rest.fallback.pacientes;

import net.amentum.niomedic.pacientes.exceptions.PacienteException;
import net.amentum.niomedic.pacientes.views.PacientesGruposView;
import net.amentum.niomedic.niogateway.api.rest.pacientes.PacientesGruposRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PacientesGruposRestImpl implements PacientesGruposRest {
   private static final Logger logger = LoggerFactory.getLogger(PacientesGruposRestImpl.class);

   @Override
   public PacientesGruposView findFirstByIdPaciente(String idPaciente) throws PacienteException {
      logger.error("No fui posible obtener el grupo del paciente.");
      throw new PacienteException("Servicio de grupos de pacientes no disponible.", PacienteException.LAYER_SERVICE, PacienteException.ACTION_INSERT);
   }
}