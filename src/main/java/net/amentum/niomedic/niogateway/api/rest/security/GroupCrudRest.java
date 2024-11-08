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

    @PostMapping()
    void addGroup(@RequestBody GroupCrudView group);

    @PutMapping(value = "{groupCrudId}")
    void editGroup(@RequestBody @Validated GroupCrudView group, @PathVariable("groupCrudId")Long groupCrudId);

    @DeleteMapping(value = "{groupCrudId}")
    void deleteGroup(@PathVariable("groupCrudId")Long groupCrudId);

    @GetMapping()
    Page<GroupCrudView> findPage(@RequestParam(required = false, value = "gid") Integer gid,
                                 @RequestParam(required = false, value = "page") Integer page,
                                 @RequestParam(required = false, value = "size") Integer size,
                                 @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                 @RequestParam(required = false, value = "orderType")String orderType);

    @GetMapping(value ="all")
    Collection<GroupCrudView> findAll();

    @GetMapping(value = "image")
    String findImageGroupCrud(
            @RequestParam(required = false, value = "gid") Long gid,
            @RequestParam(required = false, value = "color") String color
    );

    @GetMapping(value = "{groupCrudId}")
    GroupCrudView findGroup(@PathVariable("groupCrudId") Long groupCrudId);
}
