package net.amentum.niomedic.niogateway.api.rest.fallback.security;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.security.TipoUsuarioRest;
import net.amentum.niomedic.niogateway.api.rest.views.security.TipoUsuarioView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TipoUsuarioRestFallback extends BaseController implements TipoUsuarioRest {

   private final Logger logger = LoggerFactory.getLogger(TipoUsuarioRestFallback.class);

   public List<TipoUsuarioView> findAll(Boolean visible) {
      logger.error("Error al accesar al servicio para OBTENER TODOS los tipo de usuarios que el visible sea {}", visible);
      return null;
   }

}
