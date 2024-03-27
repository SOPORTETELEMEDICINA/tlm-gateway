package net.amentum.niomedic.niogateway.api.rest.expediente;

import net.amentum.niomedic.expediente.views.CuestionarioEmbarazoView;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.CuestionarioEmbarazoRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import net.amentum.niomedic.niogateway.api.rest.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@FeignClient(value = "http://nio-expediente", fallback = CuestionarioEmbarazoRestImpl.class)
public interface CuestionarioEmbarazoRest {


    @PostMapping("Cuestionario")
    void createCuestionario(@RequestBody @Valid CuestionarioEmbarazoView view);

    @PutMapping("Cuestionario/{idCuestionario}")
    void updateCuestionarioEmbarazo(@PathVariable("idCuestionario") String idCuestionario, CuestionarioEmbarazoView view);

    @DeleteMapping("Cuestionario/{idCuestionario}")
    void deleteCuestionarioEmbarazo(@PathVariable("idCuestionario") String idCuestionario);

    @GetMapping("Cuestionario/findAll")
    List<CuestionarioEmbarazoView> findAll();

    @GetMapping("Cuestionario/find")
    Page<CuestionarioEmbarazoView> getCuestionarioSearch(@RequestParam(value = "pacidfk") String pacidfk,
                                                         @RequestParam(required = false, value = "page") Integer page,
                                                         @RequestParam(required = false, value = "size") Integer size,
                                                         @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                                         @RequestParam(required = false, value = "orderType") String orderType);

    @GetMapping("Cuestionario/findByDate")
    Page<CuestionarioEmbarazoView> getCuestionarioFechaSearch(@RequestParam(value = "pacidfk") String pacidfk,
                                                              @RequestParam(value = "fechaInicio") String fechaInicio,
                                                              @RequestParam(value = "fechaFin") String fechaFin,
                                                              @RequestParam(required = false, value = "page") Integer page,
                                                              @RequestParam(required = false, value = "size") Integer size,
                                                              @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                                              @RequestParam(required = false, value = "orderType") String orderType);
}

