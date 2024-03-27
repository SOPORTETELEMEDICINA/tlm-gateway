package net.amentum.niomedic.niogateway.api.rest.fallback.security;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.security.SocketSessionRest;
import net.amentum.niomedic.niogateway.api.views.SocketSessionView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SocketSessionRestFallback extends BaseController implements SocketSessionRest {


   private final Logger logger = LoggerFactory.getLogger(SocketSessionRestFallback.class);

   @Override
   public void createSession(SocketSessionView socketSessionView) {
      logger.error("Error al guardar socket: {}",socketSessionView);
   }

   @Override
   public void removeSession(String sessionID) {
      logger.error("Error al eliminar session: {}",sessionID);
   }

   @Override
   public Boolean getSessions(String username) {
      logger.error("Error al obtener sesion de usuario: {}",username);
      return Boolean.FALSE;
   }
}
