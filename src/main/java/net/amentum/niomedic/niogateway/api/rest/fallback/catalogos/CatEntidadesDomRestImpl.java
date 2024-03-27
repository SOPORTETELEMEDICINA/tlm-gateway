package net.amentum.niomedic.niogateway.api.rest.fallback.catalogos;

import net.amentum.niomedic.catalogos.views.CatEntidadesDomView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.catalogos.CatEntidadesDomRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CatEntidadesDomRestImpl extends BaseController implements CatEntidadesDomRest {

   private Logger logger = LoggerFactory.getLogger(CatEntidadesDomRestImpl.class);

   public CatEntidadesDomView getDetailsByIdCatEntidadesDom(Integer idCatEntidadesDom) {
      logger.error("Error al accesar al servicio para OBTENER POR ID CatEntidadesDom {}", idCatEntidadesDom);
      return null;
   }

   public List<CatEntidadesDomView> findAll() {
      logger.error("Error al accesar al servicio para OBTENER TODOS los CatEntidadesDom");
      return null;
   }

   public Page<CatEntidadesDomView> getCatEntidadesDomSearch(String datosBusqueda,
                                                             Integer page,
                                                             Integer size,
                                                             String orderColumn,
                                                             String orderType) {
      logger.error("Error al OBTENER PÁGINA de CatEntidadesDom - datosBusqueda: {} - page: {} - size: {} - orderColumn: {} - orderType: {}",
         datosBusqueda, page, size, orderColumn, orderType);
      return null;
   }
}
