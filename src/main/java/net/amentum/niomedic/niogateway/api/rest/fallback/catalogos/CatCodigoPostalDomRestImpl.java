package net.amentum.niomedic.niogateway.api.rest.fallback.catalogos;

import net.amentum.niomedic.catalogos.views.CatCodigoPostalDomView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.catalogos.CatCodigoPostalDomRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CatCodigoPostalDomRestImpl extends BaseController implements CatCodigoPostalDomRest {

   private Logger logger = LoggerFactory.getLogger(CatCodigoPostalDomRestImpl.class);

   public CatCodigoPostalDomView getDetailsByIdCatCodigoPostalDom(Long idCatCodigoPostalDom) {
      logger.error("Error al accesar al servicio para OBTENER POR ID CatCodigoPostalDom {}", idCatCodigoPostalDom);
      return null;
   }

   public List<CatCodigoPostalDomView> findAll() {
      logger.error("Error al accesar al servicio para OBTENER TODOS los CatCodigoPostalDom");
      return null;
   }

   public Page<CatCodigoPostalDomView> getCatCodigoPostalDomSearch(String datosBusqueda,
                                                                   Integer page,
                                                                   Integer size,
                                                                   String orderColumn,
                                                                   String orderType) {
      logger.error("Error al OBTENER PÁGINA de CatCodigoPostalDom - datosBusqueda: {} - page: {} - size: {} - orderColumn: {} - orderType: {}",
         datosBusqueda, page, size, orderColumn, orderType);
      return null;
   }
}
