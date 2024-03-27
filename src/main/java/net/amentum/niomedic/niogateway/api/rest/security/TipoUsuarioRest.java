package net.amentum.niomedic.niogateway.api.rest.security;

import net.amentum.niomedic.niogateway.api.rest.fallback.security.TipoUsuarioRestFallback;
import net.amentum.niomedic.niogateway.api.rest.views.security.TipoUsuarioView;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tipo-usuario")
@FeignClient(value = "http://nio-security", fallback = TipoUsuarioRestFallback.class)
public interface TipoUsuarioRest {

   @GetMapping("findAll")
   List<TipoUsuarioView> findAll(@RequestParam(required = false, value = "visible") Boolean visible);

}
