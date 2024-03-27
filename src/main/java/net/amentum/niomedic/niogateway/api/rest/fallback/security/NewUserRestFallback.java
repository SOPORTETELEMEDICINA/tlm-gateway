package net.amentum.niomedic.niogateway.api.rest.fallback.security;

import net.amentum.niomedic.niogateway.api.rest.security.NewUserRest;
import net.amentum.niomedic.niogateway.api.rest.views.security.NewUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewUserRestFallback implements NewUserRest {

    private final Logger logger = LoggerFactory.getLogger(NewUserRestFallback.class);

    @Override
    public String createUserLink(String username, String idMedico, Long idGroup) {
        logger.error("Error al crear link: {} - {}- {}", username, idMedico, idGroup);
        return null;
    }

    @Override
    public Boolean verifyLink(String hash) {
        logger.error("Error al verificar hash: {}", hash);
        return false;
    }

    @Override
    public NewUser findByHash(String hash) {
        logger.error("Error al buscar por hash: {}", hash);
        return null;
    }
}
