package net.amentum.niomedic.niogateway.api.rest.receta;

import net.amentum.niomedic.niogateway.api.rest.fallback.receta.EstudioRestImpl;
import net.amentum.niomedic.receta.views.EstudioView;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@FeignClient(value = "http://nio-receta", fallback = EstudioRestImpl.class)
public interface EstudioRest {

   @PostMapping("estudio")
   EstudioView createEstudio(@RequestBody @Validated EstudioView estudioView);

   @PutMapping("estudio/{idEstudio}")
   EstudioView updateEstudio(@PathVariable("idEstudio") UUID idEstudio, @RequestBody @Validated EstudioView estudioView);

   @GetMapping("estudio/{idEstudio}")
   EstudioView getDetailsByIdEstudio(@PathVariable("idEstudio") UUID idEstudio);

   @DeleteMapping("estudio/{idEstudio}")
   void deleteEstudio(@PathVariable("idEstudio") UUID idEstudio);

   @GetMapping("estudio/por-consulta/{consultaId}")
   List<EstudioView> getAllEstudioByConsultaId(@PathVariable("consultaId") Long consultaId,
                                               @RequestParam(required = false, value = "activo") Boolean activo);

   @GetMapping("estudio/por-folio/{folio}")
   EstudioView getEstudioByFolio(@PathVariable("folio") Long folio);

}
