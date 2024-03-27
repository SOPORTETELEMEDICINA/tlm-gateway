package net.amentum.niomedic.niogateway.api.rest.fallback.medicos;

import net.amentum.niomedic.medicos.views.RegionSanitariaView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.medicos.RegionSanitariaRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class RegionSanitariaRestImpl extends BaseController implements RegionSanitariaRest {

    private Logger logger = LoggerFactory.getLogger(RegionSanitariaRestImpl.class);

    @Override
    public RegionSanitariaView createRegionSanitaria(RegionSanitariaView regionSanitariaView) {
        logger.error("Error al accesar al servicio para agregar una región sanitaria");
        return null;
    }

    @Override
    public RegionSanitariaView updateRegionSanitaria(Integer idRegionSanitaria, RegionSanitariaView view) {
        logger.error("Error al accesar al servicio para actualizar una región sanitaria");
        return null;
    }

    @Override
    public RegionSanitariaView getRegionSanitariaById(Integer idRegionSanitaria) {
        logger.error("Error al accesar al servicio para buscar una región sanitaria");
        return null;
    }

    @Override
    public Page<RegionSanitariaView> getMRegionSanitariaPage(String idMedico, Integer page, Integer size, String orderColumn, String orderType) {
        logger.error("Error al accesar al servicio para buscar una región sanitaria");
        return null;
    }

    @Override
    public List<RegionSanitariaView> getRegionSanitariaByEstado(Integer idEstado) {
        logger.error("Error al accesar al servicio para buscar una región sanitaria");
        return null;
    }


}
