package net.amentum.niomedic.niogateway.api.rest.fallback.security;

import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.security.UsuariosCanalizadosRest;
import net.amentum.niomedic.niogateway.api.rest.views.security.UsuariosCanalizadosPageView;
import net.amentum.niomedic.niogateway.api.rest.views.security.UsuariosCanalizadosView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author Ggarcia GGR20200626
 */
public class UsuariosCanalizadosRestFallback implements UsuariosCanalizadosRest {

    private final Logger logger = LoggerFactory.getLogger(UsuariosCanalizadosRestFallback.class);

    @Override
    public UsuariosCanalizadosPageView createUsuariosCanalizados(UsuariosCanalizadosView usuariosCanalizadosView) {
        logger.info("Estoy en fallBack de creación de usuarios canalizados : {}" , usuariosCanalizadosView);
        return null;
    }

    @Override
    public Page<UsuariosCanalizadosView> findUsuariosCanalizados(Integer page, Integer size, String orderColumn, String orderType, Long idMedicoEmisor) {
        logger.info("Estoy en fallBack de findUsuariosCanalizados");
        return null;
    }

    @Override
    public void deleteUsuariosCanalizados(Long usuariosCanalizadosId) {
        logger.info("Hubo un error al borrar un usuarios canalizado");
    }

    @Override
    public List<Long> getListByUser(Long idUserApp) {
        logger.info("Hubo un error al pedir la lista de usuarios canalizados");
        return null;
    }

    @Override
    public List<Long> getStatusByPaciente(Long idPaciente) {
        logger.info("Hubo un error al checar usuarios canalizados");
        return null;
    }


}
