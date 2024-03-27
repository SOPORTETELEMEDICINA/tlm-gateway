package net.amentum.niomedic.niogateway.api.rest.security;

import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.security.OauthDetailRestFallback;
import net.amentum.niomedic.niogateway.api.rest.views.security.OauthClientDetailsView;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@FeignClient(value = "http://nio-security", fallback = OauthDetailRestFallback.class)
@RequestMapping("oauth/details")
public interface OauthDetailRest {

   @RequestMapping(method = RequestMethod.POST)
   void addCredential(@RequestBody @Validated OauthClientDetailsView detailsView);

   @RequestMapping(method = RequestMethod.PUT, value = "{id}")
   void updateCredential(@PathVariable("id") Long id, @RequestBody @Validated OauthClientDetailsView detailsView);

   @RequestMapping(method = RequestMethod.GET, value = "{id}")
   OauthClientDetailsView findById(@PathVariable("id") Long id);


   @RequestMapping(method = RequestMethod.GET)
   Page<OauthClientDetailsView> findPage(@RequestParam(required = false, value = "name") String name,
                                         @RequestParam(required = false, value = "page", defaultValue = "0") Integer page,
                                         @RequestParam(required = false, value = "size", defaultValue = "25") Integer size,
                                         @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                         @RequestParam(required = false, value = "orderType") String orderType);


   @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
   void deleteCredential(@PathVariable("id") Long id);
}
