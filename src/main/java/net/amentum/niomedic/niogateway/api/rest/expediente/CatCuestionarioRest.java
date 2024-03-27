package net.amentum.niomedic.niogateway.api.rest.expediente;

import net.amentum.niomedic.expediente.views.CatCuestionarioView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.CatCuestionarioRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@FeignClient(value = "http://nio-expediente", fallback = CatCuestionarioRestImpl.class)
public interface CatCuestionarioRest {

    @PostMapping("cat_cuestionario")
    void createCuestionario(@RequestBody @Validated CatCuestionarioView view);

    @PutMapping("cat_cuestionario/{idCuestionario}")
    void updateCuestionario(@PathVariable("idCuestionario") Integer idCuestionario, @RequestBody @Validated CatCuestionarioView view);

    @GetMapping("cat_cuestionario/{idCuestionario}")
    CatCuestionarioView getCuestionario(@PathVariable("idCuestionario") Integer idCuestionario);

    @GetMapping("cat_cuestionario/find")
    Page<CatCuestionarioView> getCuestionarioSearch(@RequestParam(required = false, value = "page") Integer page,
                                                      @RequestParam(required = false, value = "size") Integer size,
                                                      @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                                      @RequestParam(required = false, value = "orderType") String orderType);

}
