package net.amentum.niomedic.niogateway.api.rest.fallback.catalogos;

import net.amentum.niomedic.catalogos.views.CatTitulosCie10View;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.catalogos.CatTitulosCie10Rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CatTitulosCie10RestImpl extends BaseController implements CatTitulosCie10Rest {

   private Logger logger = LoggerFactory.getLogger(CatTitulosCie10RestImpl.class);

   public CatTitulosCie10View getDetailsByIdCatTitulosCie10(Integer idCatTitulosCie10) {
      logger.error("Error al accesar al servicio para OBTENER POR ID CatTitulosCie10 {}", idCatTitulosCie10);
      return null;
   }

   public List<CatTitulosCie10View> findAll() {
      logger.error("Error al accesar al servicio para OBTENER TODOS los CatTitulosCie10");
      return null;
   }

   public Page<CatTitulosCie10View> getCatTitulosCie10Search(String datosBusqueda,
                                                             Integer page,
                                                             Integer size,
                                                             String orderColumn,
                                                             String orderType) {
      logger.error("Error al OBTENER PÁGINA de CatTitulosCie10 - datosBusqueda: {} - page: {} - size: {} - orderColumn: {} - orderType: {}",
         datosBusqueda, page, size, orderColumn, orderType);
      return null;
   }
}
