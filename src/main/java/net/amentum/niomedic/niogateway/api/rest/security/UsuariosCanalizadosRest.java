package net.amentum.niomedic.niogateway.api.rest.security;

import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.security.UsuariosCanalizadosRestFallback;

import net.amentum.niomedic.niogateway.api.rest.views.security.UsuariosCanalizadosPageView;
import net.amentum.niomedic.niogateway.api.rest.views.security.UsuariosCanalizadosView;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ggarcia GGR20200626
 */

@FeignClient(value = "http://nio-security", fallback = UsuariosCanalizadosRestFallback.class)
public interface UsuariosCanalizadosRest {

    @PostMapping("canalizar")
    UsuariosCanalizadosPageView createUsuariosCanalizados(@RequestBody @Validated UsuariosCanalizadosView usuariosCanalizadosView);


    @GetMapping("canalizar/page")
    Page<UsuariosCanalizadosView> findUsuariosCanalizados(@RequestParam(required = false, value = "page", defaultValue = "0") Integer page,
                                           @RequestParam(required = false, value = "size", defaultValue = "25") Integer size,
                                           @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                           @RequestParam(required = false, value = "orderType") String orderType,
                                           @RequestParam(required = false, value = "idMedicoEmisor") Long idMedicoEmisor);

    @DeleteMapping("canalizar/{usuariosCanalizadosId}")
    void deleteUsuariosCanalizados(@PathVariable("usuariosCanalizadosId") Long usuariosCanalizadosId);


    @GetMapping("canalizar/lista/{idUserApp}")
    List<Long> getListByUser(@PathVariable("idUserApp") Long idUserApp);

    @GetMapping("canalizar/pacienteCanalizado/{idPaciente}")
    List<Long> getStatusByPaciente(@PathVariable("idPaciente") Long idPaciente);

}
