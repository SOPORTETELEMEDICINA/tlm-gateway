package net.amentum.niomedic.niogateway.api.rest.expediente;

import net.amentum.niomedic.expediente.views.CuestionarioRespuestaView;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.CuestionarioRespuestaImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@FeignClient(value = "http://nio-expediente", fallback = CuestionarioRespuestaImpl.class)
public interface CuestionarioRespuestaRest {

    @PostMapping("cuestionario_respuesta")
    void createCuestionarioRespuesta(@RequestBody @Validated CuestionarioRespuestaView view);

    @GetMapping("cuestionario_respuesta")
    List<CuestionarioRespuestaView> getRespuestaSearch(@RequestParam(value = "idPaciente") String idPaciente,
                            @RequestParam(value = "idCuestionario") Integer idCuestionario);

}
