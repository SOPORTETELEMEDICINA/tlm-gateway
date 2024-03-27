package net.amentum.niomedic.niogateway.api.secured;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.security.UsuariosCanalizadosRest;
import net.amentum.niomedic.niogateway.api.rest.views.security.UsuariosCanalizadosView;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ggarcia GGR20200626
 */
@RestController
@RequestMapping("canalizar")
public class UsuariosCanalizadosRestApi extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(UsuariosCanalizadosRestApi.class);

    @Autowired
    private UsuariosCanalizadosRest usuariosCanalizadosRest;


    @PostMapping
    void createUsuarioCanalizado(@RequestBody @Validated UsuariosCanalizadosView usuariosCanalizadosView) {
        logger.info("Crerar un usuario canalizado : {}" , usuariosCanalizadosView);
        this.usuariosCanalizadosRest.createUsuariosCanalizados(usuariosCanalizadosView);
    }

    @GetMapping("/page")
    Page<UsuariosCanalizadosView> findPage(HttpServletRequest request,
                                           @RequestParam(required = false, value = "page", defaultValue = "0") Integer page,
                                           @RequestParam(required = false, value = "size", defaultValue = "25") Integer size,
                                           @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                           @RequestParam(required = false, value = "orderType") String orderType,
                                           @RequestParam(required = false, value = "idMedicoEmisor") Long idMedicoEmisor) {

        logger.info("Pido pagina de usuarios canalizados ");
        return this.usuariosCanalizadosRest.findUsuariosCanalizados(page, size, orderColumn, orderType, idMedicoEmisor);
    }

    @DeleteMapping( "{usuariosCanalizadosId}")
    void deleteUsuariosCanalizados(@PathVariable("usuariosCanalizadosId") Long usuariosCanalizadosId) {
        logger.info("deleteUsuariosCanalizados: {}" , usuariosCanalizadosId);
        this.usuariosCanalizadosRest.deleteUsuariosCanalizados(usuariosCanalizadosId);
    }

    @GetMapping("/lista/{idUserApp}")
    List<Long> getListByUser(@PathVariable("idUserApp") Long idUserApp) {
        logger.info("getListByUser: {}" , idUserApp);
       return this.usuariosCanalizadosRest.getListByUser(idUserApp);
    }

    @GetMapping("/pacienteCanalizado/{idPaciente}")
    List<Long> getStatusByPaciente(@PathVariable("idPaciente") Long idPaciente) {
        logger.info("getStatusByPaciente: {}", idPaciente);
        return this.usuariosCanalizadosRest.getStatusByPaciente(idPaciente);
    }

}



