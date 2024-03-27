package net.amentum.niomedic.niogateway.api.rest.expediente;

import net.amentum.niomedic.expediente.views.referencia_vs_referencia.ReferenciaView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.ReferenciaRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@FeignClient(value = "http://nio-expediente", fallback = ReferenciaRestImpl.class)
public interface ReferenciaRest {
    @PostMapping("referencia")
    Map<String, Object> createReferencia(@RequestBody @Validated ReferenciaView view);

    @GetMapping("referencia")
    Page<ReferenciaView> getReferencias(@RequestParam(value = "searchColumn") Integer searchColumn,
                                        @RequestParam(value = "type") Integer type,
                                        @RequestParam(value = "value") String value,
                                        @RequestParam(required = false, value = "page") Integer page,
                                        @RequestParam(required = false, value = "size") Integer size);
}
