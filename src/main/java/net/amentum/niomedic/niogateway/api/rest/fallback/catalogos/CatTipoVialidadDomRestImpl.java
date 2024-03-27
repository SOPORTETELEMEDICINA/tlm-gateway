package net.amentum.niomedic.niogateway.api.rest.fallback.catalogos;

import net.amentum.niomedic.catalogos.views.CatTipoVialidadDomView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.catalogos.CatTipoVialidadDomRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CatTipoVialidadDomRestImpl extends BaseController implements CatTipoVialidadDomRest {

   private Logger logger = LoggerFactory.getLogger(CatTipoVialidadDomRestImpl.class);

   public CatTipoVialidadDomView getDetailsByIdCatTipoVialidadDom(Integer idCatTipoVialidadDom) {
      logger.error("Error al accesar al servicio para OBTENER POR ID CatTipoVialidadDom {}", idCatTipoVialidadDom);
      return null;
   }

   public List<CatTipoVialidadDomView> findAll() {
      logger.error("Error al accesar al servicio para OBTENER TODOS los CatTipoVialidadDom");
      return null;
   }

   public Page<CatTipoVialidadDomView> getCatTipoVialidadDomSearch(String datosBusqueda,
                                                                   Integer page,
                                                                   Integer size,
                                                                   String orderColumn,
                                                                   String orderType) {
      logger.error("Error al OBTENER PÁGINA de CatTipoVialidadDom - datosBusqueda: {} - page: {} - size: {} - orderColumn: {} - orderType: {}",
         datosBusqueda, page, size, orderColumn, orderType);
      return null;
   }
}
