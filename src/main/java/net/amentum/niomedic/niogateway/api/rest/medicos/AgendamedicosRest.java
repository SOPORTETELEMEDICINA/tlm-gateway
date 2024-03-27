package net.amentum.niomedic.niogateway.api.rest.medicos;


import net.amentum.niomedic.medicos.views.AgendaMedicosView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.medicos.AgendamedicosRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@FeignClient(value = "http://nio-medicos", fallback = AgendamedicosRestImpl.class)
public interface AgendamedicosRest {


    @PostMapping("Agendamedicos")
    void createAgendamedicos(@RequestBody @Validated AgendaMedicosView AgendamedicosView);

    @PutMapping("Agendamedicos/{idagenda}")
    void updateAgendamedicos(@PathVariable("idagenda") Integer idagenda, @RequestBody @Validated AgendaMedicosView AgendamedicosView);

    @DeleteMapping("Agendamedicos/{idagenda}")
    void deleteAgendamedicos(@PathVariable("idagenda") Integer idagenda);

    @GetMapping("Agendamedicos/findAll")
    List<AgendaMedicosView> findAll();

    @GetMapping({"Agendamedicos/search"})
    Page<AgendaMedicosView> getAgendamedicosSearch(@RequestParam(required = true, value = "idmedico") String idmedico,
                                                   @RequestParam(required = false, value = "page") Integer page,
                                                   @RequestParam(required = false, value = "size") Integer size,
                                                   @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                                   @RequestParam(required = false, value = "orderType") String orderType);

}
