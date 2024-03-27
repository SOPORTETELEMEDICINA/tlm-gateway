package net.amentum.niomedic.niogateway.api.rest.security;

import net.amentum.common.GenericException;
import net.amentum.niomedic.niogateway.api.rest.fallback.security.UserAppRestFallback;
import net.amentum.niomedic.niogateway.api.rest.views.security.ChangePasswordRequestView;
import net.amentum.niomedic.niogateway.api.rest.views.security.RecoverPasswordRequestView;
import net.amentum.niomedic.niogateway.api.rest.views.security.ResetPasswordView;
import net.amentum.niomedic.niogateway.api.rest.views.security.UserAppPageView;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@FeignClient(value = "http://nio-security", fallback = UserAppRestFallback.class)
public interface UserPasswordRest {

    @PutMapping("users/{idUserApp}/reset")
    void resetPassword(@PathVariable("idUserApp") Long idUserApp, @RequestBody @Validated ResetPasswordView resetPasswordView);

    @GetMapping(value = "users/recoverPassword")
    UserAppPageView recoverPassword(@RequestParam(name = "email") String email);

    @PostMapping(value = "users/recoverPassword")
    void validatePassword(@Validated @RequestBody RecoverPasswordRequestView requestView);

    @PostMapping(value = "users/changePassword")
    void changePassword(@Validated @RequestBody ChangePasswordRequestView requestView);

}

