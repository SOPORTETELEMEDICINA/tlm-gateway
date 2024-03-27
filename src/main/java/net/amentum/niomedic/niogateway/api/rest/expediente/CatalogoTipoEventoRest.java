package net.amentum.niomedic.niogateway.api.rest.expediente;

import net.amentum.niomedic.expediente.views.CatalogoTipoEventoView;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.CatalogoTipoEventoRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@FeignClient(value = "http://nio-expediente", fallback = CatalogoTipoEventoRestImpl.class)
public interface CatalogoTipoEventoRest {

   @PostMapping("catalogo-tipo-evento")
   void createCatalogoTipoEvento(@RequestBody @Validated CatalogoTipoEventoView catalogoTipoEventoView);

   @PutMapping("catalogo-tipo-evento/{idCatalogoTipoEvento}")
   void updateCatalogoTipoEvento(@PathVariable("idCatalogoTipoEvento") Integer idCatalogoTipoEvento, @RequestBody @Validated CatalogoTipoEventoView catalogoTipoEventoView);

   @GetMapping("catalogo-tipo-evento/{idCatalogoTipoEvento}")
   CatalogoTipoEventoView getDetailsByIdCatalogoTipoEvento(@PathVariable("idCatalogoTipoEvento") Integer idCatalogoTipoEvento);

   @GetMapping("catalogo-tipo-evento/findAll")
   List<CatalogoTipoEventoView> findAll();
}
