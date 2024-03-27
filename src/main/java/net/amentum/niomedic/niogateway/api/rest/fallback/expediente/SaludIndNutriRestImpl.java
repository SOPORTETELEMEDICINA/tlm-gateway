package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.expediente.views.SaludIndNutriView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.expediente.SaludIndNutriRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

//import org.springframework.data.domain.Page;

public class SaludIndNutriRestImpl    extends BaseController implements SaludIndNutriRest {

    private Logger logger = LoggerFactory.getLogger(SaludIndNutriRestImpl.class);

    public void createSaludIndNutri(SaludIndNutriView SaludIndNutriView) {
        logger.error("Error al accesar al servicio para AGREGAR un indicadores nutricional: {}", SaludIndNutriView);
    }


    public void updateSaludIndNutri(String pacidfk, SaludIndNutriView SaludIndNutriView) {
        logger.error("Error al accesar el servicio para MODIFICAR indicadores nutricional {} al paciente {}", SaludIndNutriView, pacidfk);
    }


    public void deleteSaludIndNutri(String pacidfk) {
        logger.error("Error al accesar al servicio para BORRAR indicadores nutricional al paciente {}", pacidfk);
    }


    public SaludIndNutriView getDetailsByPacidfk(String pacidfk) {
        logger.error("Error al accesar al servicio para OBTENER POR ID indicadores nutricional del paciente {}", pacidfk);
        return null;
    }


    public List<SaludIndNutriView> findAll() {
        logger.error("Error al accesar al servicio para OBTENER TODOS los indicadores nutricional");
        return null;
    }


    public Page<SaludIndNutriView> getSaludIndNutriPage(Boolean active,
                                                      String name,
                                                      Integer page,
                                                      Integer size,
                                                      String orderColumn,
                                                      String orderType) {
        logger.error("Error al OBTENER PÁGINA de indicadores nutricional - active: {} - name: {} - page: - {} size: {} - orderColumn: {} - orderType: {}",
                active, name, page, size, orderColumn, orderType);
        return null;
    }

}
