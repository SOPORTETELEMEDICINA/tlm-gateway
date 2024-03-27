package net.amentum.niomedic.niogateway.api.rest.fallback.receta;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.receta.EstudioRest;
import net.amentum.niomedic.receta.views.EstudioView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.UUID;

public class EstudioRestImpl extends BaseController implements EstudioRest {

   private Logger logger = LoggerFactory.getLogger(EstudioRestImpl.class);

   public EstudioView createEstudio(EstudioView estudioView) {
      logger.error("Error al accesar al servicio para AGREGAR estudio: {}", estudioView);
      return null;
   }

   public EstudioView updateEstudio(UUID idEstudio, EstudioView estudioView) {
      logger.error("Error al accesar al servicio para MODIFICAR estudio: {}", estudioView);
      return null;
   }

   public EstudioView getDetailsByIdEstudio(UUID idEstudio) {
      logger.error("Error al accesar al servicio para OBTENER POR ID estudio {}", idEstudio);
      return null;
   }

   public void deleteEstudio(UUID idEstudio) {
      logger.error("Error al accesar al servicio para BORRAR estudio {}", idEstudio);
   }

   public List<EstudioView> getAllEstudioByConsultaId(Long consultaId, Boolean activo) {
      logger.error("Error al accesar al servicio para OBTENER POR ID consulta {}", consultaId);
      return null;
   }

   public EstudioView getEstudioByFolio(Long folio) {
      logger.error("Error al accesar al servicio para OBTENER POR ID folio {}", folio);
      return null;
   }
}
