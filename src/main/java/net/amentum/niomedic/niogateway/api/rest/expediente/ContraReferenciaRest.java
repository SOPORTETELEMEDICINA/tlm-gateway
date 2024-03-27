package net.amentum.niomedic.niogateway.api.rest.expediente;

import net.amentum.niomedic.expediente.views.referencia_vs_referencia.ContraReferenciaView;
import net.amentum.niomedic.expediente.views.referencia_vs_referencia.ReferenciaView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.ContraReferenciaRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@FeignClient(value = "http://nio-expediente", fallback = ContraReferenciaRestImpl.class)
public interface ContraReferenciaRest {
    @PostMapping("contra-referencia")
    void createReferencia(@RequestBody @Validated ContraReferenciaView view);

    @GetMapping("contra-referencia")
    Page<ContraReferenciaView> getReferencias(@RequestParam(value = "searchColumn") Integer searchColumn,
                                        @RequestParam(value = "value") String value,
                                        @RequestParam(required = false, value = "page") Integer page,
                                        @RequestParam(required = false, value = "size") Integer size);
}
