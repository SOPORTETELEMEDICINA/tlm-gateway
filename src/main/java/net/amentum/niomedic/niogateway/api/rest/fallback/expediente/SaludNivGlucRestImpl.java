package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;

import net.amentum.niomedic.expediente.views.SaludNivGlucView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.expediente.views.SaludNivGlucView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.expediente.SaludNivGlucRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

//import org.springframework.data.domain.Page;

public class SaludNivGlucRestImpl extends BaseController implements SaludNivGlucRest {

    private Logger logger = LoggerFactory.getLogger(SaludNivGlucRestImpl.class);

    public void createSaludNivGluc(SaludNivGlucView SaludNivGlucView) {
        logger.error("Error al accesar al servicio para AGREGAR un niveles glucosa: {}", SaludNivGlucView);
    }


    public void updateSaludNivGluc(String pacidfk, SaludNivGlucView SaludNivGlucView) {
        logger.error("Error al accesar el servicio para MODIFICAR niveles glucosa {} al paciente {}", SaludNivGlucView, pacidfk);
    }


    public void deleteSaludNivGluc(String pacidfk) {
        logger.error("Error al accesar al servicio para BORRAR niveles glucosa al paciente {}", pacidfk);
    }



    public List<SaludNivGlucView> findAll() {
        logger.error("Error al accesar al servicio para OBTENER TODOS los niveles glucosa");
        return null;
    }

    @Override
    public Page<SaludNivGlucView> getSaludNivGlucSearch(String pacidfk, Integer page, Integer size, String orderColumn, String orderType) {
        logger.error("Error al OBTENER PÁGINA de NivelesPeso - pacidfk: {}  - page: {} - size: {} - orderColumn: {} - orderType: {}",
                pacidfk, page, size, orderColumn, orderType);
        return null;
    }


    @Override
    public Page<SaludNivGlucView> getSaludNivGlucfechaSearch(String pacidfk,int periodo,String fechaInicio, String fechaFin , Integer page, Integer size, String orderColumn, String orderType) {
        logger.error("Error al OBTENER PÁGINA de NivelesPeso - pacidfk: {} - periodo: {} - fechaInicio: {} - fechaFin: {} - page: {} - size: {} - orderColumn: {} - orderType: {}",
                pacidfk,periodo,fechaInicio,fechaFin, page, size, orderColumn, orderType);
        return null;
    }


}
