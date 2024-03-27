package net.amentum.niomedic.niogateway.api.rest.fallback.catalogos;

import net.amentum.niomedic.catalogos.views.CatCie10View;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.catalogos.CatCie10Rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CatCie10RestImpl extends BaseController implements CatCie10Rest {

   private Logger logger = LoggerFactory.getLogger(CatCie10RestImpl.class);

   public CatCie10View getDetailsByIdCatCie10(Integer idCatCie10) {
      logger.error("Error al accesar al servicio para OBTENER POR ID CatCie10 {}", idCatCie10);
      return null;
   }

   public List<CatCie10View> findAll() {
      logger.error("Error al accesar al servicio para OBTENER TODOS los CatCie10");
      return null;
   }

   public Page<CatCie10View> getCatCie10Search(String datosBusqueda,
                                               Integer page,
                                               Integer size,
                                               String orderColumn,
                                               String orderType) {
      logger.error("Error al OBTENER PÁGINA de CatCie10 - datosBusqueda: {} - page: {} - size: {} - orderColumn: {} - orderType: {}",
         datosBusqueda, page, size, orderColumn, orderType);
      return null;
   }
}
