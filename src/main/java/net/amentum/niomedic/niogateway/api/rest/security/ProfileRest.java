package net.amentum.niomedic.niogateway.api.rest.security;

import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.security.ProfileRestFallback;
import net.amentum.niomedic.niogateway.api.rest.views.security.NodeTree;
import net.amentum.niomedic.niogateway.api.rest.views.security.ProfileView;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@FeignClient(value = "http://nio-security", fallback = ProfileRestFallback.class)
@RequestMapping("profiles")
public interface ProfileRest {


   @RequestMapping(method = RequestMethod.POST)
   void addProfile(@RequestBody @Validated ProfileView profileView);

   @RequestMapping(method = RequestMethod.PUT, value = "{profileId}")
   void updateProfile(@RequestBody @Validated ProfileView profileView, @PathVariable("profileId") Long profileId);

   @RequestMapping(method = RequestMethod.DELETE, value = "{profileId}")
   void deleteProfile(@PathVariable("profileId") Long profileId);

   @RequestMapping(method = RequestMethod.GET, value = "{profileId}")
   ProfileView findProfile(@PathVariable("profileId") Long profileId);

   @RequestMapping(method = RequestMethod.GET)
   Page<ProfileView> getPage(@RequestParam(required = false, name = "name") String name,
                             @RequestParam(required = false, name = "page", defaultValue = "0") Integer page,
                             @RequestParam(required = false, name = "size", defaultValue = "25") Integer size,
                             @RequestParam(required = false, name = "orderColumn") String orderColumn,
                             @RequestParam(required = false, name = "orderType") String orderType);

   @RequestMapping(method = RequestMethod.GET, value = "tree")
   Collection<NodeTree> findNodes();

   @RequestMapping(method = RequestMethod.GET, value = "all")
   Collection<ProfileView> findAll();
}

