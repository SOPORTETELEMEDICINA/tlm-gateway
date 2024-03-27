package net.amentum.niomedic.niogateway.api.rest.fallback.security;

import net.amentum.niomedic.niogateway.api.rest.security.UserAlentaRest;
import net.amentum.niomedic.niogateway.api.rest.views.security.UserAlentaView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserAlentaRestFallback implements UserAlentaRest {

    private final Logger logger = LoggerFactory.getLogger(UserAlentaRestFallback.class);

    @Override
    public void createUserAlenta(UserAlentaView view) {
        logger.error("Error al conectar con el metodo de insert");
    }

    @Override
    public UserAlentaView getUserById(String idUser) {
        logger.error("Error al conectar con el metodo de getUserById");
        return null;
    }

    @Override
    public UserAlentaView getUserByIdAlenta(String idUserAlenta) {
        logger.error("Error al conectar con el metodo de getUserByIdAlenta");
        return null;
    }
}
