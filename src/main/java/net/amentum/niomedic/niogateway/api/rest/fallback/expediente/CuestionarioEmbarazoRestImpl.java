package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;

import net.amentum.niomedic.expediente.views.CuestionarioEmbarazoView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.expediente.CuestionarioEmbarazoRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.amentum.niomedic.niogateway.api.rest.Page;

import java.util.List;

public class CuestionarioEmbarazoRestImpl extends BaseController implements CuestionarioEmbarazoRest {

    Logger logger = LoggerFactory.getLogger(CuestionarioEmbarazoRestImpl.class);

    @Override
    public void createCuestionario(CuestionarioEmbarazoView view) {
        logger.error("Error al accesar al servicio para AGREGAR cuestionarios: {} ", view);
    }

    @Override
    public void updateCuestionarioEmbarazo(String idCuestionario, CuestionarioEmbarazoView view) {
        logger.error("Error al accesar al servicio para MODIFICAR cuestionario: {} - {}", idCuestionario, view);
    }

    @Override
    public void deleteCuestionarioEmbarazo(String idCuestionario) {
        logger.error("Error al accesar al servicio para BORRAR cuestionario: {} ", idCuestionario);
    }

    @Override
    public List<CuestionarioEmbarazoView> findAll() {
        logger.error("Error al accesar al servicio para OBTENER TODOS los cuestionarios");
        return null;
    }

    @Override
    public Page<CuestionarioEmbarazoView> getCuestionarioSearch(String pacidfk, Integer page, Integer size, String orderColumn, String orderType) {
        logger.error("Error al OBTENER PÁGINA de Cuestionarios - pacidfk: {}  - page: {} - size: {} - orderColumn: {} - orderType: {}",
                pacidfk, page, size, orderColumn, orderType);
        return null;
    }

    @Override
    public Page<CuestionarioEmbarazoView> getCuestionarioFechaSearch(String pacidfk, String fechaInicio, String fechaFin, Integer page, Integer size, String orderColumn, String orderType) {
        logger.error("Error al OBTENER PÁGINA de Cuestionarios - pacidfk: {} - fechaInicio: {} - fechaFin: {} - page: {} - size: {} - orderColumn: {} - orderType: {}",
                pacidfk,fechaInicio,fechaFin, page, size, orderColumn, orderType);
        return null;
    }
}
