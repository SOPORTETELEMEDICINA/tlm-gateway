package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.expediente.ReportesRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReportesRestImpl extends BaseController implements ReportesRest {
   private Logger logger = LoggerFactory.getLogger(ReportesRestImpl.class);

   public String getSolicitudServicios(Long idConsulta){
      logger.error("Error al accesar al servicio para OBTENER POR ID getSolicitudServicios {}", idConsulta);
      return null;
   }

   public String getReferencia(Long idConsulta){
      logger.error("Error al accesar al servicio para OBTENER POR ID getReferenciaContrareferencia {}", idConsulta);
      return null;
   }

   //GGR20200622 agrego idGroup
   public String getNotasMedicasPresc(Long idConsulta, Long idGroup){
      logger.error("Error al accesar al servicio para OBTENER POR ID getNotasMedicasPresc {} para el grupo {}", idConsulta, idGroup);
      return null;
   }

   // Sre03072020 Dejé este para que siga funcionando en Baja y en Puebla:
   public String getNotasMedicasPresc(Long idConsulta){
      logger.error("Error al accesar al servicio para OBTENER POR ID getNotasMedicasPresc {}", idConsulta);
      return null;
   }

   public String getNotasEvolucion(Long idConsulta){
      logger.error("Error al accesar al servicio para OBTENER POR ID getNotasEvolucion {}", idConsulta);
      return null;
   }

   // GGR20200803 agrego idGroup
   public String getSolicitudEstudios(Long idConsulta, Long folio, Long idGroup){
      logger.error("Error al accesar al servicio para OBTENER POR ID: {} y por folio: {} getSolicitudEstudios con grupo: {}", idConsulta,folio, idGroup);
      return null;
   }

   //GGR20200622 agrego idGroup
   public String getReceta(Long idConsulta, Long idGroup){
      logger.error("Error al accesar al servicio para OBTENER POR ID getReceta {} para el grupo {}", idConsulta, idGroup);
      return null;
   }

   public String getContrarreferencia(Long idConsulta){
      logger.error("Error al accesar al servicio para OBTENER POR ID getContrarreferencia {}", idConsulta);
      return null;
   }

   public String getConsentimiento(Long idConsulta){
      logger.error("Error al accesar al servicio para OBTENER POR ID getConsentimiento {}", idConsulta);
      return null;
   }

   public String getNotasInterconsulta(Long idConsulta) {
      logger.error("Error al accesar al servicio para OBTENER POR ID getNotasInterconsulta {}", idConsulta);
      return null;
   }

   @Override
   public String getHistoriaClinica(String idPaciente) {
      logger.error("Error al accesar al servicio para OBTENER POR ID getHistoriaClinica {}", idPaciente);
      return null;
   }
}
