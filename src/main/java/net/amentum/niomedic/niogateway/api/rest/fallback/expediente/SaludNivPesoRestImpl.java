package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.expediente.views.SaludNivPesoView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.expediente.SaludNivPesoRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

//import org.springframework.data.domain.Page;
public class SaludNivPesoRestImpl extends BaseController implements SaludNivPesoRest {

    private Logger logger = LoggerFactory.getLogger(SaludNivPesoRestImpl.class);

    public void createSaludNivPeso(SaludNivPesoView SaludNivPesoView) {
        logger.error("Error al accesar al servicio para AGREGAR un niveles peso: {}", SaludNivPesoView);
    }


    public void updateSaludNivPeso(String pacidfk, SaludNivPesoView SaludNivPesoView) {
        logger.error("Error al accesar el servicio para MODIFICAR niveles peso {} al paciente {}", SaludNivPesoView, pacidfk);
    }


    public void deleteSaludNivPeso(String pacidfk) {
        logger.error("Error al accesar al servicio para BORRAR niveles peso al paciente {}", pacidfk);
    }

/*
    public SaludNivPesoView getDetailsByPacidfk(String pacidfk) {
        logger.error("Error al accesar al servicio para OBTENER POR ID niveles peso del paciente {}", pacidfk);
        return null;
    }*/



    public List<SaludNivPesoView> findAll() {
        logger.error("Error al accesar al servicio para OBTENER TODOS los niveles peso");
        return null;
    }

    @Override
    public Page<SaludNivPesoView> getSaludNivPesoSearch(String pacidfk, Integer page, Integer size, String orderColumn, String orderType) {
        logger.error("Error al OBTENER PÁGINA de NivelesPeso - pacidfk: {}  - page: {} - size: {} - orderColumn: {} - orderType: {}",
                pacidfk, page, size, orderColumn, orderType);
        return null;
    }


    @Override
    public Page<SaludNivPesoView> getSaludNivPesofechaSearch(String pacidfk,int periodo,String fechaInicio, String fechaFin , Integer page, Integer size, String orderColumn, String orderType) {
        logger.error("Error al OBTENER PÁGINA de NivelesPeso - pacidfk: {} - periodo: {} - fechaInicio: {} - fechaFin: {} - page: {} - size: {} - orderColumn: {} - orderType: {}",
                pacidfk,periodo,fechaInicio,fechaFin, page, size, orderColumn, orderType);
        return null;
    }


}
