package net.amentum.niomedic.niogateway.api.rest.security;

import net.amentum.niomedic.niogateway.api.rest.fallback.security.UserAlentaRestFallback;
import net.amentum.niomedic.niogateway.api.rest.views.security.UserAlentaView;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@FeignClient(value = "http://nio-security", fallback = UserAlentaRestFallback.class)
public interface UserAlentaRest {

    @PostMapping("users-alenta")
    void createUserAlenta(@RequestBody @Validated UserAlentaView view);

    @GetMapping("users-alenta/findUser")
    UserAlentaView getUserById(@RequestParam(value = "idUser") String idUser);

    @GetMapping("users-alenta/findUserAlenta")
    UserAlentaView getUserByIdAlenta(@RequestParam(value = "idUserAlenta") String idUserAlenta);
}
