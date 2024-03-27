package net.amentum.niomedic.niogateway.api.rest.fallback.catalogos;

import net.amentum.niomedic.catalogos.views.CatSubtitulosCie10View;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.catalogos.CatSubtitulosCie10Rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CatSubtitulosCie10RestImpl extends BaseController implements CatSubtitulosCie10Rest {

   private Logger logger = LoggerFactory.getLogger(CatSubtitulosCie10RestImpl.class);

   public CatSubtitulosCie10View getDetailsByIdCatSubtitulosCie10(Integer idCatSubtitulosCie10) {
      logger.error("Error al accesar al servicio para OBTENER POR ID CatSubtitulosCie10 {}", idCatSubtitulosCie10);
      return null;
   }

   public List<CatSubtitulosCie10View> findAll() {
      logger.error("Error al accesar al servicio para OBTENER TODOS los CatSubtitulosCie10");
      return null;
   }

   public Page<CatSubtitulosCie10View> getCatSubtitulosCie10Search(String datosBusqueda,
                                                                   Integer page,
                                                                   Integer size,
                                                                   String orderColumn,
                                                                   String orderType) {
      logger.error("Error al OBTENER PÁGINA de CatSubtitulosCie10 - datosBusqueda: {} - page: {} - size: {} - orderColumn: {} - orderType: {}",
         datosBusqueda, page, size, orderColumn, orderType);
      return null;
   }
}
