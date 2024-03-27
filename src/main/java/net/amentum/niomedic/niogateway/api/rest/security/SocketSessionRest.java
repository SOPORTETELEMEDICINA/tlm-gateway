package net.amentum.niomedic.niogateway.api.rest.security;


import net.amentum.niomedic.niogateway.api.rest.fallback.security.SocketSessionRestFallback;
import net.amentum.niomedic.niogateway.api.views.SocketSessionView;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "http://nio-security",fallback = SocketSessionRestFallback.class)
public interface SocketSessionRest {

   @PostMapping(value = "/sockets")
   void createSession(@RequestBody() SocketSessionView socketSessionView);


   @DeleteMapping(value = "/sockets/{sessionId}")
   void removeSession(@PathVariable(name = "sessionId")String sessionID);

   @GetMapping(value = "/sockets/{username}")
   Boolean getSessions(@PathVariable(name = "username")String username);
}