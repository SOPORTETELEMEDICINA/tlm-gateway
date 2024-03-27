package net.amentum.niomedic.niogateway.api.rest.expediente;

import net.amentum.niomedic.expediente.views.ImagenLaboratorioListView;
import net.amentum.niomedic.expediente.views.ImagenLaboratorioView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.ImagenLaboratorioRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@FeignClient(value = "http://nio-expediente", fallback = ImagenLaboratorioRestImpl.class)
public interface ImagenLaboratorioRest {

   @GetMapping("imagen-laboratorio/page")
   Page<ImagenLaboratorioListView> getImagenLaboratorioPage(@RequestParam(required = false, defaultValue = "", value = "idPaciente") String idPaciente,
                                                            @RequestParam(required = false, defaultValue = "", value = "idConsulta") Long idConsulta,
                                                            @RequestParam(required = false, value = "active") Boolean active,
                                                            @RequestParam(required = false, value = "page") Integer page,
                                                            @RequestParam(required = false, value = "size") Integer size,
                                                            @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                                            @RequestParam(required = false, value = "orderType") String orderType);


   @PostMapping("imagen-laboratorio/subir-archivo/{idPaciente}")
   void subirArchivo(@PathVariable("idPaciente") String idPaciente, @RequestBody @Validated ImagenLaboratorioView archivobase64);

   @DeleteMapping("imagen-laboratorio/{idImagenLaboratorio}")
   void eliminarImagenLaboratorio(@PathVariable("idImagenLaboratorio") Long idImagenLaboratorio);

   @GetMapping("imagen-laboratorio/por-padecimiento/{idPadecimiento}")
   List<ImagenLaboratorioListView> getDocumentosPorPadecimiento(@PathVariable("idPadecimiento") Long idPadecimiento);

}
