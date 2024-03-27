package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;

import net.amentum.niomedic.expediente.views.TomaDiaView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.expediente.TomaDiaRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class TomaDiaRestImpl extends BaseController implements TomaDiaRest {

   private Logger logger = LoggerFactory.getLogger(TomaDiaRestImpl.class);

   public List<TomaDiaView> getTomasDia(Long idUsuario) {
      logger.error("Error al accesar al servicio para OBTENER tomasDia por idUsuario {}", idUsuario);
      return null;
   }

}
