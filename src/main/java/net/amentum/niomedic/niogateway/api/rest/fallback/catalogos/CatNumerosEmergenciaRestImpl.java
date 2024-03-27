package net.amentum.niomedic.niogateway.api.rest.fallback.catalogos;

import net.amentum.niomedic.catalogos.views.CatNumerosEmergenciaView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.catalogos.CatNumerosEmergenciaRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CatNumerosEmergenciaRestImpl extends BaseController implements CatNumerosEmergenciaRest {

   private Logger logger = LoggerFactory.getLogger(CatNumerosEmergenciaRestImpl.class);

   public CatNumerosEmergenciaView getDetailsByIdCatNumerosEmergencia(Integer idCatNumerosEmergencia) {
      logger.error("Error al accesar al servicio para OBTENER POR ID CatNumerosEmergencia {}", idCatNumerosEmergencia);
      return null;
   }

   public List<CatNumerosEmergenciaView> findAll() {
      logger.error("Error al accesar al servicio para OBTENER TODOS los CatNumerosEmergencia");
      return null;
   }

   public Page<CatNumerosEmergenciaView> getCatNumerosEmergenciaSearch(String datosBusqueda,
                                           Integer page,
                                           Integer size,
                                           String orderColumn,
                                           String orderType) {
      logger.error("Error al OBTENER PÁGINA de CatNumerosEmergencia - datosBusqueda: {} - page: {} - size: {} - orderColumn: {} - orderType: {}",
         datosBusqueda, page, size, orderColumn, orderType);
      return null;
   }
}
