package net.amentum.niomedic.niogateway.api.rest.security;

import net.amentum.niomedic.niogateway.api.rest.fallback.security.NewUserRestFallback;
import net.amentum.niomedic.niogateway.api.rest.views.security.NewUser;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@RestController
@FeignClient(value = "http://nio-security", fallback = NewUserRestFallback.class)
public interface NewUserRest {

    @GetMapping(value = "new-user/get-link")
    String createUserLink(@RequestParam(name = "username") String username,
                          @RequestParam(name = "idUsuario") String idUsuario,
                          @RequestParam(name = "idGroup") Long idGroup);

    @GetMapping(value = "new-user/link")
    Boolean verifyLink(@RequestParam(name = "hash") String hash);

    @RequestMapping(value = "new-user/find", method = RequestMethod.GET)
    NewUser findByHash(@RequestParam(name = "hash") String hash);

}
