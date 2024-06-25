package net.amentum.niomedic.niogateway.api.rest.pacientes;

import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.pacientes.PacienteRestImpl;
import net.amentum.niomedic.pacientes.exceptions.PacienteException;
import net.amentum.niomedic.pacientes.views.PacientePageView;
import net.amentum.niomedic.pacientes.views.PacienteView;
import net.amentum.niomedic.pacientes.views.RelacionTitularView;
import net.amentum.niomedic.pacientes.views.RelacionTutoresView;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@FeignClient(value = "http://nio-pacientes", fallback = PacienteRestImpl.class)
public interface PacienteRest {

   @PostMapping("pacientes")
   PacienteView createPaciente(@RequestBody @Validated PacienteView pacienteView) throws PacienteException;

   @PutMapping("pacientes/{idPaciente}")
   PacienteView updatePaciente(@PathVariable("idPaciente") String idPaciente, @RequestBody @Validated PacienteView pacienteView) throws PacienteException;

   @GetMapping("pacientes/{idPaciente}")
   PacienteView getPacienteById(@PathVariable("idPaciente") String idPaciente) throws PacienteException;

   @GetMapping("pacientes/obtenerPorIdUsuario/{idUsuario}")
   PacienteView getPacienteByIdUsuario(@PathVariable("idUsuario") Integer idUsuario) throws PacienteException;

   @GetMapping("pacientes/obtenerPorCURP/{curp}")
   PacienteView getDetailsPacienteByCurp(@PathVariable("curp") String curp) throws PacienteException;

//   ESTA ES UNA VERSION ANTERIOR
//   @GetMapping("pacientes/page")
//   Page<PacientePageView> getPacientePage(@RequestParam(required = false, value = "active") Boolean active,
//                                          @RequestParam(required = false, defaultValue = "", value = "name") String name,
//                                          @RequestParam(required = false, value = "page") Integer page,
//                                          @RequestParam(required = false, value = "size") Integer size,
//                                          @RequestParam(required = false, value = "orderColumn") String orderColumn,
//                                          @RequestParam(required = false, value = "orderType") String orderType);

   @GetMapping("pacientes/page")
   Page<PacientePageView> getPacientePage(@RequestParam(required = false, defaultValue = "", value = "datosBusqueda") String datosBusqueda,
                                          @RequestParam(required = false, value = "active") Boolean active,
//                                          @RequestParam(required = false, defaultValue = "", value = "name") String name,
                                          @RequestParam(required = false, value = "page") Integer page,
                                          @RequestParam(required = false, value = "size") Integer size,
                                          @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                          @RequestParam(required = false, value = "orderType") String orderType,
                                          @RequestParam(required = false, value = "selectGroup") Long selectGroup) throws PacienteException; // GGR20200618 Agrego grupo seleccionado


   @GetMapping("pacientes/search")
   public Page<PacientePageView> getPacienteSearch(@RequestParam(required = false, value="active") Boolean active,
                                                   @RequestParam(required = false, defaultValue = "", value="datosBusqueda") String datosBusqueda,
                                                   @RequestParam(required = false, defaultValue = "", value="nombre") String nombre,
                                                   @RequestParam(required = false, defaultValue = "", value="apellidoPaterno") String apellidoPaterno,
                                                   @RequestParam(required = false, defaultValue = "", value="apellidoMaterno") String apellidoMaterno,
                                                   @RequestParam(required = false, defaultValue = "", value="telefonoMovil") String telefonoMovil,
                                                   @RequestParam(required = false, defaultValue = "", value="telefonoFijo") String telefonoFijo,
                                                   @RequestParam(required = false, defaultValue = "", value="correo") String correo,
                                                   @RequestParam(required = false, defaultValue = "", value="rfc") String rfc,
                                                   @RequestParam(required = false, defaultValue = "", value="curp") String curp,
                                                   @RequestParam(required = false, value="page") Integer page,
                                                   @RequestParam(required = false, value="size") Integer size,
                                                   @RequestParam(required = false, value="orderColumn") String orderColumn,
                                                   @RequestParam(required = false, value="orderType") String orderType) throws PacienteException;


    // Sre19062020 Nuevo metodo para actualizar grupos
    @PostMapping("pacientes/grupos/{idUserApp}")
    void updatePacienteGroups(@PathVariable("idUserApp") Long idUserApp, @RequestBody List<Long> pacienteGroups) throws PacienteException;



   @GetMapping("pacientes/page/canalizado")
   Page<PacientePageView> getPacientePageCanalizados(@RequestParam(required = false, defaultValue = "", value = "datosBusqueda") String datosBusqueda,
                                          @RequestParam(required = false, value = "active") Boolean active,
//                                          @RequestParam(required = false, defaultValue = "", value = "name") String name,
                                          @RequestParam(required = false, value = "page") Integer page,
                                          @RequestParam(required = false, value = "size") Integer size,
                                          @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                          @RequestParam(required = false, value = "orderType") String orderType,
                                          @RequestParam(required = false, value = "idUser") Long idUser) throws PacienteException;

   @GetMapping("pacientes/page/atendidos")
   Page<PacientePageView> getPacientePageAtendidos(@RequestParam(required = false, defaultValue = "", value = "datosBusqueda") String datosBusqueda,
                                                     @RequestParam(required = false, value = "active") Boolean active,
//                                          @RequestParam(required = false, defaultValue = "", value = "name") String name,
                                                     @RequestParam(required = false, value = "page") Integer page,
                                                     @RequestParam(required = false, value = "size") Integer size,
                                                     @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                                     @RequestParam(required = false, value = "orderType") String orderType,
                                                     @RequestParam(required = false, value = "idUser") Long idUser) throws PacienteException;


   @DeleteMapping("pacientes/rollback/{idUserApp}")
   void deleteRollback(@PathVariable("idUserApp") Long idUserApp) throws PacienteException;

   @PutMapping("pacientes/setIdDevice")
   void setIdDevice(@RequestParam(value="idUsuario") Integer idUsuario,
                    @RequestParam(value="idDevice") String idDevice) throws PacienteException;

}
