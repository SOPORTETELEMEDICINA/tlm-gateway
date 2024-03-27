package net.amentum.niomedic.niogateway.api.rest.fallback.receta;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.receta.RecetaRest;
import net.amentum.niomedic.receta.views.RecetaView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class RecetaRestImpl extends BaseController implements RecetaRest {

   private Logger logger = LoggerFactory.getLogger(RecetaRestImpl.class);

   public RecetaView createReceta(RecetaView recetaView) {
      logger.error("Error al accesar al servicio para AGREGAR receta: {}", recetaView);
      return null;
   }

   public RecetaView updateReceta(UUID idReceta, RecetaView recetaView) {
      logger.error("Error al accesar el servicio para MODIFICAR receta {} al idReceta {}", recetaView, idReceta);
      return null;
   }

   public RecetaView getDetailsByIdReceta(UUID idReceta) {
      logger.error("Error al accesar al servicio para OBTENER POR ID receta {}", idReceta);
      return null;
   }

   public void deleteReceta(UUID idReceta) {
      logger.error("Error al accesar al servicio para BORRAR receta {}", idReceta);
   }

   public RecetaView getDetailsByConsultaId(Long consultaId){
      logger.error("Error al accesar al servicio para OBTENER POR ID consulta {}", consultaId);
      return null;
   }
}
