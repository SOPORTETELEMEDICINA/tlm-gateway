package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.expediente.views.SaludIndPaView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.expediente.SaludIndPaRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

//import org.springframework.data.domain.Page;

public class SaludIndPaRestImpl  extends BaseController implements SaludIndPaRest {

    private Logger logger = LoggerFactory.getLogger(SaludIndPaRestImpl.class);

    public void createSaludIndPa(SaludIndPaView SaludIndPaView) {
        logger.error("Error al accesar al servicio para AGREGAR un indicadores  presion arterial: {}", SaludIndPaView);
    }


    public void updateSaludIndPa(String pacidfk, SaludIndPaView SaludIndPaView) {
        logger.error("Error al accesar el servicio para MODIFICAR indicadores  presion arterial {} al paciente {}", SaludIndPaView, pacidfk);
    }


    public void deleteSaludIndPa(String pacidfk) {
        logger.error("Error al accesar al servicio para BORRAR indicadores  presion arterial al paciente {}", pacidfk);
    }


    public SaludIndPaView getDetailsByPacidfk(String pacidfk) {
        logger.error("Error al accesar al servicio para OBTENER POR ID indicadores  presion arterial del paciente {}", pacidfk);
        return null;
    }


    public List<SaludIndPaView> findAll() {
        logger.error("Error al accesar al servicio para OBTENER TODOS los indicadores  presion arterial");
        return null;
    }


    public Page<SaludIndPaView> getSaludIndPaPage(Boolean active,
                                                        String name,
                                                        Integer page,
                                                        Integer size,
                                                        String orderColumn,
                                                        String orderType) {
        logger.error("Error al OBTENER PÁGINA de indicadores  presion arterial - active: {} - name: {} - page: - {} size: {} - orderColumn: {} - orderType: {}",
                active, name, page, size, orderColumn, orderType);
        return null;
    }



}
