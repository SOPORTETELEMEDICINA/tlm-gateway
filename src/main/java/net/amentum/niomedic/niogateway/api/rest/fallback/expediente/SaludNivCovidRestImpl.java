package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;


import net.amentum.niomedic.expediente.views.SaludNivCovidView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.expediente.views.SaludNivCovidView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.expediente.SaludNivCovidRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

//import org.springframework.data.domain.Page;
public class SaludNivCovidRestImpl extends BaseController implements SaludNivCovidRest {

    private Logger logger = LoggerFactory.getLogger(SaludNivCovidRestImpl.class);

    public void createSaludNivCovid(SaludNivCovidView SaludNivCovidView) {
        logger.error("Error al accesar al servicio para AGREGAR un niveles covid: {}", SaludNivCovidView);
    }


    public void updateSaludNivCovid(String pacidfk, SaludNivCovidView SaludNivCovidView) {
        logger.error("Error al accesar el servicio para MODIFICAR niveles covid {} al paciente {}", SaludNivCovidView, pacidfk);
    }


    public void deleteSaludNivCovid(String pacidfk) {
        logger.error("Error al accesar al servicio para BORRAR niveles covid al paciente {}", pacidfk);
    }


       public List<SaludNivCovidView> findAll() {
        logger.error("Error al accesar al servicio para OBTENER TODOS los niveles covid");
        return null;
    }

    @Override
    public Page<SaludNivCovidView> getSaludNivCovidSearch(String pacidfk, Integer page, Integer size, String orderColumn, String orderType) {
        logger.error("Error al OBTENER PÁGINA de NivelesPeso - pacidfk: {}  - page: {} - size: {} - orderColumn: {} - orderType: {}",
                pacidfk, page, size, orderColumn, orderType);
        return null;
    }


    @Override
    public Page<SaludNivCovidView> getSaludNivCovidfechaSearch(String pacidfk,int periodo,String fechaInicio, String fechaFin , Integer page, Integer size, String orderColumn, String orderType) {
        logger.error("Error al OBTENER PÁGINA de NivelesPeso - pacidfk: {} - periodo: {} - fechaInicio: {} - fechaFin: {} - page: {} - size: {} - orderColumn: {} - orderType: {}",
                pacidfk,periodo,fechaInicio,fechaFin, page, size, orderColumn, orderType);
        return null;
    }

    @Override
    public Page<SaludNivCovidView> getSaludNivCovidperiodoSearch(String pacidfk,int periodo,int PeriodoF , Integer page, Integer size, String orderColumn, String orderType) {
        logger.error("Error al OBTENER PÁGINA de NivelesPeso - pacidfk: {} - periodo: {} - PeriodoF: {} - page: {} - size: {} - orderColumn: {} - orderType: {}",
                pacidfk,periodo,PeriodoF, page, size, orderColumn, orderType);
        return null;
    }

   



}
