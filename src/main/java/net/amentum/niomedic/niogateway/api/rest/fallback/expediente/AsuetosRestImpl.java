package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;

import net.amentum.niomedic.expediente.views.AsuetosView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.expediente.AsuetosRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class AsuetosRestImpl extends BaseController implements AsuetosRest {

   private Logger logger = LoggerFactory.getLogger(AsuetosRestImpl.class);

   public void createAsuetos(AsuetosView asuetosView){
      logger.error("Error al accesar al servicio para AGREGAR asuetos: {}", asuetosView);
   }

   public void updateAsuetos(Long idAsuetos, AsuetosView asuetosView){
      logger.error("Error al accesar el servicio para MODIFICAR asuetos {} al idAsuetos {}", asuetosView, idAsuetos);
   }

   public AsuetosView getDetailsByIdAsuetos(Long idAsuetos){
      logger.error("Error al accesar al servicio para OBTENER POR ID asuetos {}", idAsuetos);
      return null;
   }

   public void deleteAsuetos(Long idAsuetos){
      logger.error("Error al accesar al servicio para BORRAR asuetos {}", idAsuetos);
   }

   public List<AsuetosView> findAll(){
      logger.error("Error al accesar al servicio para OBTENER TODOS los asuetos");
      return null;
   }

}
