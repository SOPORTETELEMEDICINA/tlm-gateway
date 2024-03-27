package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;

import net.amentum.niomedic.expediente.views.SaludNivPreartView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.expediente.views.SaludNivPreartView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.expediente.SaludNivPreartRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

//import org.springframework.data.domain.Page;
public class SaludNivPreartRestImpl extends BaseController implements SaludNivPreartRest {

    private Logger logger = LoggerFactory.getLogger(SaludNivPreartRestImpl.class);

    public void createSaludNivPreart(SaludNivPreartView SaludNivPreartView) {
        logger.error("Error al accesar al servicio para AGREGAR un niveles presion arterial: {}", SaludNivPreartView);
    }


    public void updateSaludNivPreart(String pacidfk, SaludNivPreartView SaludNivPreartView) {
        logger.error("Error al accesar el servicio para MODIFICAR niveles presion arterial {} al paciente {}", SaludNivPreartView, pacidfk);
    }


    public void deleteSaludNivPreart(String pacidfk) {
        logger.error("Error al accesar al servicio para BORRAR niveles presion arterial al paciente {}", pacidfk);
    }




    public List<SaludNivPreartView> findAll() {
        logger.error("Error al accesar al servicio para OBTENER TODOS los niveles presion arterial");
        return null;
    }

    @Override
    public Page<SaludNivPreartView> getSaludNivPreartSearch(String pacidfk, Integer page, Integer size, String orderColumn, String orderType) {
        logger.error("Error al OBTENER PÁGINA de NivelesPeso - pacidfk: {}  - page: {} - size: {} - orderColumn: {} - orderType: {}",
                pacidfk, page, size, orderColumn, orderType);
        return null;
    }


    @Override
    public Page<SaludNivPreartView> getSaludNivPreartfechaSearch(String pacidfk,int periodo,String fechaInicio, String fechaFin , Integer page, Integer size, String orderColumn, String orderType) {
        logger.error("Error al OBTENER PÁGINA de NivelesPeso - pacidfk: {} - periodo: {} - fechaInicio: {} - fechaFin: {} - page: {} - size: {} - orderColumn: {} - orderType: {}",
                pacidfk,periodo,fechaInicio,fechaFin, page, size, orderColumn, orderType);
        return null;
    }
   

}
