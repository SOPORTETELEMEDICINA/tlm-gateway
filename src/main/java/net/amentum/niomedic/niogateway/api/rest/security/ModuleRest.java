package net.amentum.niomedic.niogateway.api.rest.security;

import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.security.ModuleRestFallback;
import net.amentum.niomedic.niogateway.api.rest.views.security.ModuleView;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@FeignClient(value = "http://nio-security", fallback = ModuleRestFallback.class)
@RequestMapping(value = "modules")
public interface ModuleRest {

   @RequestMapping(method = RequestMethod.POST)
   void addModule(@RequestBody @Validated ModuleView moduleView);

   @RequestMapping(method = RequestMethod.PUT, value = "{moduleId}")
   void updateModule(@RequestBody @Validated ModuleView moduleView, @PathVariable("moduleId") Long moduleId);

   @RequestMapping(method = RequestMethod.DELETE, value = "{moduleId}")
   void deleteModule(@PathVariable("moduleId") Long moduleId);

   @RequestMapping(method = RequestMethod.GET, value = "{moduleId}")
   ModuleView findModuleById(@PathVariable("moduleId") Long moduleId);


   @RequestMapping(method = RequestMethod.GET)
   Page<ModuleView> getPage(@RequestParam(required = false, value = "name") String name,
                            @RequestParam(required = false, value = "page") Integer page,
                            @RequestParam(required = false, value = "size") Integer size,
                            @RequestParam(required = false, value = "orderColumn") String orderColumn,
                            @RequestParam(required = false, value = "orderType") String orderType);

}