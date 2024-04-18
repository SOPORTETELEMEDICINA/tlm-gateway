package net.amentum.niomedic.niogateway.api.rest.fallback.security;

import net.amentum.niomedic.niogateway.api.rest.security.UserPasswordRest;
import net.amentum.niomedic.niogateway.api.rest.views.security.ChangePasswordRequestView;
import net.amentum.niomedic.niogateway.api.rest.views.security.RecoverPasswordRequestView;
import net.amentum.niomedic.niogateway.api.rest.views.security.ResetPasswordView;

import net.amentum.niomedic.niogateway.api.rest.views.security.UserAppPageView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserPasswordRestFallback implements UserPasswordRest {

    private final Logger logger = LoggerFactory.getLogger(UserPasswordRestFallback.class);

    @Override
    public void resetPassword(Long idUserApp, ResetPasswordView resetPasswordView) {
        logger.error("Error al accesar al servicio para MODIFICAR usuario: {} - {}", idUserApp, resetPasswordView);
    }

    @Override
    public UserAppPageView recoverPassword(String email) {
        logger.error("Error al accesar al servicio recover password: {}", email);
        return null;
    }

    @Override
    public String hashPass(String user,String pass) {
        logger.error("Error al accesar al servicio recover password: {}", user);
        return null;
    }


    @Override
    public void validatePassword(RecoverPasswordRequestView requestView) {
        logger.error("Error al accesar al servicio validate password: {} ", requestView);
    }

    @Override
    public void changePassword(ChangePasswordRequestView requestView) {
        logger.error("Error al accesar al servicio change password: {} ", requestView);
    }

}
