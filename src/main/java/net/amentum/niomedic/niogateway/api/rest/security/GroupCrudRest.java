package net.amentum.niomedic.niogateway.api.rest.security;

import net.amentum.niomedic.niogateway.api.rest.fallback.security.GroupCrudRestFallback;
import net.amentum.niomedic.niogateway.api.rest.views.security.GroupCrudView;
import org.springframework.cloud.netflix.feign.FeignClient;
import net.amentum.niomedic.niogateway.api.rest.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@FeignClient(value = "http://nio-security", fallback = GroupCrudRestFallback.class)
@RequestMapping("groups-crud")
public interface GroupCrudRest {

    @RequestMapping(method = RequestMethod.POST)
    void addGroup(@RequestBody GroupCrudView group);

    @RequestMapping(value = "{groupCrudId}",method = RequestMethod.PUT)
    void editGroup(@RequestBody @Validated GroupCrudView group, @PathVariable()Long groupCrudId);

    @RequestMapping(value = "{groupCrudId}",method = RequestMethod.DELETE)
    void deleteGroup(@PathVariable()Long groupCrudId);

    @RequestMapping(method = RequestMethod.GET)
    Page<GroupCrudView> findPage(@RequestParam(required = false, value = "gid", defaultValue = "0" ) Integer gid,
                                 @RequestParam(required = false, value = "page", defaultValue = "0") Integer page,
                                 @RequestParam(required = false, value = "size", defaultValue = "25") Integer size,
                                 @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                 @RequestParam(required = false, value = "orderType")String orderType);

    @RequestMapping(value = "all",method = RequestMethod.GET)
    Collection<GroupCrudView> findAll();

    @RequestMapping(value = "image",method = RequestMethod.GET)
    String findImageGroupCrud(@RequestParam(required = true)Integer gid,@RequestParam(required = true)String color);

    @RequestMapping(value = "{groupCrudId}",method = RequestMethod.GET)
    GroupCrudView findGroup(@PathVariable()Long groupCrudId);
}
