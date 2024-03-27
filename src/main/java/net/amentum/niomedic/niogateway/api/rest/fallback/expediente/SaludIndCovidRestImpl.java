package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.expediente.views.SaludIndCovidView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.expediente.SaludIndCovidRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

//import org.springframework.data.domain.Page;

public class SaludIndCovidRestImpl  extends BaseController implements SaludIndCovidRest {

    private Logger logger = LoggerFactory.getLogger(SaludIndCovidRestImpl.class);

    public void createSaludIndCovid(SaludIndCovidView SaludIndCovidView) {
        logger.error("Error al accesar al servicio para AGREGAR un indicadores covid: {}", SaludIndCovidView);
    }


    public void updateSaludIndCovid(String pacidfk, SaludIndCovidView SaludIndCovidView) {
        logger.error("Error al accesar el servicio para MODIFICAR indicadores covid {} al paciente {}", SaludIndCovidView, pacidfk);
    }


    public void deleteSaludIndCovid(String pacidfk) {
        logger.error("Error al accesar al servicio para BORRAR indicadores covid al paciente {}", pacidfk);
    }


    public SaludIndCovidView getDetailsByPacidfk(String pacidfk) {
        logger.error("Error al accesar al servicio para OBTENER POR ID indicadores covid del paciente {}", pacidfk);
        return null;
    }


    public List<SaludIndCovidView> findAll() {
        logger.error("Error al accesar al servicio para OBTENER TODOS los indicadores covid");
        return null;
    }


    public Page<SaludIndCovidView> getSaludIndCovidPage(Boolean active,
                                                        String name,
                                                        Integer page,
                                                        Integer size,
                                                        String orderColumn,
                                                        String orderType) {
        logger.error("Error al OBTENER PÁGINA de indicadores covid - active: {} - name: {} - page: - {} size: {} - orderColumn: {} - orderType: {}",
                active, name, page, size, orderColumn, orderType);
        return null;
    }
}
