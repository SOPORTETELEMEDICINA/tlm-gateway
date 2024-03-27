package net.amentum.niomedic.niogateway.api.rest.security;

import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.security.WorkShiftRestFallback;
import net.amentum.niomedic.niogateway.api.rest.views.security.WorkShiftView;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("work/shifts")
@FeignClient(value = "http://nio-security", fallback = WorkShiftRestFallback.class)
public interface WorkShiftRest {

   @PostMapping
   void addWorkShift(@RequestBody WorkShiftView workShiftView);

   @PutMapping("{idWorkShift}")
   void updateWorkShift(@PathVariable("idWorkShift") Long idWorkShift,
                        @RequestBody WorkShiftView workShiftView);

   @DeleteMapping("{idWorkShift}")
   void deleteWorkShift(@PathVariable("idWorkShift") Long idWorkShift);

   @GetMapping("{idWorkShift}")
   WorkShiftView findWorkShiftById(@PathVariable("idWorkShift") Long idWorkShift);

   @GetMapping
   Collection<WorkShiftView> findAllWorkShifts();


   @GetMapping("page")
   Page<WorkShiftView> findWorkShiftPage(@RequestParam(required = false, name = "active") Boolean active,
                                         @RequestParam(required = false, name = "name") String name,
                                         @RequestParam(required = false, name = "page") Integer page,
                                         @RequestParam(required = false, name = "size") Integer size,
                                         @RequestParam(required = false, name = "orderColumn") String orderColumn,
                                         @RequestParam(required = false, name = "orderType") String orderType);

}
