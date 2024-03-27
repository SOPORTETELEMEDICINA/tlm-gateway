package net.amentum.niomedic.niogateway.api.rest.fallback.catalogos;

import net.amentum.niomedic.catalogos.views.CatTipoInsumoMedView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.catalogos.CatTipoInsumoMedRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CatTipoInsumoMedRestImpl extends BaseController implements CatTipoInsumoMedRest {

   private Logger logger = LoggerFactory.getLogger(CatTipoInsumoMedRestImpl.class);

   public CatTipoInsumoMedView getDetailsByIdCatTipoInsumoMed(Integer idCatTipoInsumoMed) {
      logger.error("Error al accesar al servicio para OBTENER POR ID CatTipoInsumoMed {}", idCatTipoInsumoMed);
      return null;
   }

   public List<CatTipoInsumoMedView> findAll() {
      logger.error("Error al accesar al servicio para OBTENER TODOS los CatTipoInsumoMed");
      return null;
   }

   public Page<CatTipoInsumoMedView> getCatTipoInsumoMedSearch(String datosBusqueda,
                                                               Integer page,
                                                               Integer size,
                                                               String orderColumn,
                                                               String orderType) {
      logger.error("Error al OBTENER PÁGINA de CatTipoInsumoMed - datosBusqueda: {} - page: {} - size: {} - orderColumn: {} - orderType: {}",
         datosBusqueda, page, size, orderColumn, orderType);
      return null;
   }
}
