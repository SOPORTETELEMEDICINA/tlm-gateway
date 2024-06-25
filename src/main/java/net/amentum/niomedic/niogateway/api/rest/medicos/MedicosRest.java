package net.amentum.niomedic.niogateway.api.rest.medicos;

import java.util.List; // Sre19062020 Nuevo

import net.amentum.niomedic.medicos.views.MedicoAgendaPageView;
import net.amentum.niomedic.medicos.views.MedicoFirmaView;
import net.amentum.niomedic.medicos.views.MedicoPageView;
import net.amentum.niomedic.medicos.views.MedicoView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.medicos.MedicoRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@FeignClient(value = "http://nio-medicos", fallback = MedicoRestImpl.class)
public interface MedicosRest {

   @PostMapping("medicos")
   MedicoView createdMedico(@RequestBody @Validated MedicoView medicoView);

   @PutMapping("medicos/{idMedico}")
   MedicoView updateMedico(@PathVariable("idMedico") String idMedico, @RequestBody @Validated MedicoView medicoView);

   @GetMapping("medicos/{idMedico}")
   MedicoView getDetailsByIdMedico(@PathVariable("idMedico") String idMedico);

   @GetMapping("medicos/obtenerPorIdUsuario/{idUsuario}")
   MedicoView getDetailsByIdUsuario(@PathVariable("idUsuario") Integer idUsuario);

   //   ESTA ES UNA VERSION ANTERIOR
   //   @GetMapping("medicos/page")
//   Page<MedicoView> getMedicoPage(@RequestParam(required = false, value = "active") Boolean active,
//                                  @RequestParam(required = false, defaultValue = "", value = "name") String name,
//                                  @RequestParam(required = false, value = "page") Integer page,
//                                  @RequestParam(required = false, value = "size") Integer size,
//                                  @RequestParam(required = false, value = "orderColumn") String orderColumn,
//                                  @RequestParam(required = false, value = "orderType") String orderType);
   @GetMapping("medicos/page")
   Page<MedicoPageView> getMedicoPage(@RequestParam(required = false, defaultValue = "", value = "datosBusqueda") String datosBusqueda,
                                      @RequestParam(required = false, value = "active") Boolean active,
//                                              @RequestParam(required = false, defaultValue = "") String name,
                                      @RequestParam(required = false, value = "page") Integer page,
                                      @RequestParam(required = false, value = "size") Integer size,
                                      @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                      @RequestParam(required = false, value = "orderType") String orderType,
                                      @RequestParam(required = false, value = "selectGroup") Long selectGroup); // GGR20200617 Agrego grupo seleccionado


      @GetMapping("medicos/obtenerPorNombreUsuario/{userName}")
      MedicoView getDetailsByUserName (@PathVariable("userName") String userName);

    // Sre19062020 Nuevo metodo para actualizar grupos
    @PostMapping("medicos/grupos/{idUserApp}")
    void updateMedicoGroups(@PathVariable("idUserApp") Long idUserApp, @RequestBody List<Long> medicoGroups);

   @GetMapping("medicos/obtenerPorEspecialidad")
   Page<MedicoAgendaPageView> getDetailsByEspecialidad(@RequestParam(value = "nombreEspecialidad") String nombreEspecialidad,
                                                       @RequestParam(required = false, value = "page") Integer page,
                                                       @RequestParam(required = false, value = "size") Integer size,
                                                       @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                                       @RequestParam(required = false, value = "orderType") String orderType);

   @GetMapping("medicos/firma/{idFirma}")
   MedicoFirmaView getSignatureById(@PathVariable("idFirma") Integer idFirma);
}
