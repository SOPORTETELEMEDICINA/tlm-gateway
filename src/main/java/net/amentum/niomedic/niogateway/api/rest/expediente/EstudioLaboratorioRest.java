package net.amentum.niomedic.niogateway.api.rest.expediente;

import net.amentum.niomedic.expediente.views.EstudioLaboratorioListView;
import net.amentum.niomedic.expediente.views.EstudioLaboratorioView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.EstudioLaboratorioRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@FeignClient(value = "http://nio-expediente", fallback = EstudioLaboratorioRestImpl.class)
public interface EstudioLaboratorioRest {

   @GetMapping("estudio-laboratorio/page")
   Page<EstudioLaboratorioListView> getEstudioLaboratorioPage(@RequestParam(required = false, value = "active") Boolean active,
                                                              @RequestParam(required = false, defaultValue = "", value = "name") String name,
                                                              @RequestParam(required = false, value = "page") Integer page,
                                                              @RequestParam(required = false, value = "size") Integer size,
                                                              @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                                              @RequestParam(required = false, value = "orderType") String orderType);

   @GetMapping("estudio-laboratorio/por-padecimiento/{idPadecimiento}")
   List<List<Map<String, Object>>> getEstudioLaboratorioPorPadecimiento(@PathVariable("idPadecimiento") Long idPadecimiento);

}

