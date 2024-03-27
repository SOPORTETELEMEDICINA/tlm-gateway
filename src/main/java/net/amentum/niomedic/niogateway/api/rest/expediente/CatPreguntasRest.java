package net.amentum.niomedic.niogateway.api.rest.expediente;

import net.amentum.niomedic.expediente.views.CatCuestionarioHeader;
import net.amentum.niomedic.expediente.views.CatPreguntaView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.CatPreguntasRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@FeignClient(value = "http://nio-expediente", fallback = CatPreguntasRestImpl.class)
public interface CatPreguntasRest {

    @PostMapping("cat_preguntas")
    void createPregunta(@RequestBody @Validated CatPreguntaView view);

    @PutMapping("cat_preguntas/{idPregunta}")
    void updatePregunta(@PathVariable("idPregunta") Integer idPregunta, @RequestBody @Validated CatPreguntaView view);

    @GetMapping("cat_preguntas/{idPregunta}")
    CatPreguntaView getPregunta(@PathVariable("idPregunta") Integer idPregunta);

    @GetMapping("cat_preguntas/find")
    Page<CatCuestionarioHeader> getPreguntaSearch(@RequestParam(required = false, value = "idCuestionario") Integer idCuestionario,
                                                  @RequestParam(required = false, value = "page") Integer page,
                                                  @RequestParam(required = false, value = "size") Integer size,
                                                  @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                                  @RequestParam(required = false, value = "orderType") String orderType);

    @GetMapping("cat_preguntas/search")
    Page<CatPreguntaView> getPreguntaSearchPage(@RequestParam(required = false, value = "page") Integer page,
                                                @RequestParam(required = false, value = "size") Integer size,
                                                @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                                @RequestParam(required = false, value = "orderType") String orderType);

}
