package net.amentum.niomedic.niogateway.api.rest.fallback.catalogos;

import net.amentum.niomedic.catalogos.views.CatTipoAsentamientoDomView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.catalogos.CatTipoAsentamientoDomRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CatTipoAsentamientoDomRestImpl extends BaseController implements CatTipoAsentamientoDomRest {

   private Logger logger = LoggerFactory.getLogger(CatTipoAsentamientoDomRestImpl.class);

   public CatTipoAsentamientoDomView getDetailsByIdCatTipoAsentamientoDom(Integer idCatTipoAsentamientoDom) {
      logger.error("Error al accesar al servicio para OBTENER POR ID CatTipoAsentamientoDom {}", idCatTipoAsentamientoDom);
      return null;
   }

   public List<CatTipoAsentamientoDomView> findAll() {
      logger.error("Error al accesar al servicio para OBTENER TODOS los CatTipoAsentamientoDom");
      return null;
   }

   public Page<CatTipoAsentamientoDomView> getCatTipoAsentamientoDomSearch(String datosBusqueda,
                                                                           Integer page,
                                                                           Integer size,
                                                                           String orderColumn,
                                                                           String orderType) {
      logger.error("Error al OBTENER PÁGINA de CatTipoAsentamientoDom - datosBusqueda: {} - page: {} - size: {} - orderColumn: {} - orderType: {}",
         datosBusqueda, page, size, orderColumn, orderType);
      return null;
   }
}
