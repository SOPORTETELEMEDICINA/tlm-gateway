package net.amentum.niomedic.niogateway.api.rest.security;

import net.amentum.niomedic.niogateway.api.rest.fallback.security.HierarchyRestFallback;
import net.amentum.niomedic.niogateway.api.rest.views.security.HierarchyRequestView;
import net.amentum.niomedic.niogateway.api.rest.views.security.ProfileHierarchyView;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("hierarchies")
@FeignClient(value = "http://nio-security", fallback = HierarchyRestFallback.class)
public interface HierarchyRest {

   @PostMapping
   void addOrUpdateHierarchy(@RequestBody @Validated HierarchyRequestView hierarchyView);

   @GetMapping(value = "{idPerfilBoss}")
   List<ProfileHierarchyView> getHierarchy(@PathVariable("idPerfilBoss") Long idPerfilBoss);
}
