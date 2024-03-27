package net.amentum.niomedic.niogateway.api.rest.security;

import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.security.GroupRestFallback;
import net.amentum.niomedic.niogateway.api.rest.views.security.GroupView;
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
@FeignClient(value = "http://nio-security", fallback = GroupRestFallback.class)
@RequestMapping("groups")
public interface GroupRest {


   @RequestMapping(method = RequestMethod.GET, value = "/{groupId}")
   GroupView findGroup(@PathVariable("groupId") Long groupId);

   @RequestMapping(method = RequestMethod.GET)
   Page<GroupView> findPage(@RequestParam(required = false, value = "active") Boolean active,
                            @RequestParam(required = false, value = "name", defaultValue = "") String name,
                            @RequestParam(required = false, value = "page", defaultValue = "0") Integer page,
                            @RequestParam(required = false, value = "size", defaultValue = "25") Integer size,
                            @RequestParam(required = false, value = "orderColumn") String orderColumn,
                            @RequestParam(required = false, value = "orderType") String orderType);

   @RequestMapping(method = RequestMethod.GET, value = "all")
   Collection<GroupView> findAll(@RequestParam(required = false, value = "active") Boolean active);

   @RequestMapping(method = RequestMethod.POST)
   void addGroup(@RequestBody @Validated GroupView view);

   @RequestMapping(method = RequestMethod.PUT, value = "{groupId}")
   void updateGroup(@RequestBody @Validated GroupView view, @PathVariable("groupId") Long groupId);

   @RequestMapping(method = RequestMethod.DELETE, value = "{groupId}")
   void deleteGroup(@PathVariable("groupId") Long groupId);

}

