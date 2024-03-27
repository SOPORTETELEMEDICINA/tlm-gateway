package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;


import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.expediente.views.SaludIndGlucView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.expediente.SaludIndGlucRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

//import org.springframework.data.domain.Page;

public class SaludIndGlucRestImpl   extends BaseController implements SaludIndGlucRest {

    private Logger logger = LoggerFactory.getLogger(SaludIndGlucRestImpl.class);

    public void createSaludIndGluc(SaludIndGlucView SaludIndGlucView) {
        logger.error("Error al accesar al servicio para AGREGAR un indicadores glucosa: {}", SaludIndGlucView);
    }


    public void updateSaludIndGluc(String pacidfk, SaludIndGlucView SaludIndGlucView) {
        logger.error("Error al accesar el servicio para MODIFICAR indicadores glucosa {} al paciente {}", SaludIndGlucView, pacidfk);
    }


    public void deleteSaludIndGluc(String pacidfk) {
        logger.error("Error al accesar al servicio para BORRAR indicadores glucosa al paciente {}", pacidfk);
    }


    public SaludIndGlucView getDetailsByPacidfk(String pacidfk) {
        logger.error("Error al accesar al servicio para OBTENER POR ID indicadores glucosa del paciente {}", pacidfk);
        return null;
    }


    public List<SaludIndGlucView> findAll() {
        logger.error("Error al accesar al servicio para OBTENER TODOS los indicadores glucosa");
        return null;
    }


    public Page<SaludIndGlucView> getSaludIndGlucPage(Boolean active,
                                                        String name,
                                                        Integer page,
                                                        Integer size,
                                                        String orderColumn,
                                                        String orderType) {
        logger.error("Error al OBTENER PÁGINA de indicadores glucosa - active: {} - name: {} - page: - {} size: {} - orderColumn: {} - orderType: {}",
                active, name, page, size, orderColumn, orderType);
        return null;
    }
}
