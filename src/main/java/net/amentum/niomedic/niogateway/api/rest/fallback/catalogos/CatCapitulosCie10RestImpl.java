package net.amentum.niomedic.niogateway.api.rest.fallback.catalogos;

import net.amentum.niomedic.catalogos.views.CatCapitulosCie10View;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.catalogos.CatCapitulosCie10Rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CatCapitulosCie10RestImpl extends BaseController implements CatCapitulosCie10Rest {

   private Logger logger = LoggerFactory.getLogger(CatCapitulosCie10RestImpl.class);

   public CatCapitulosCie10View getDetailsByIdCatCapitulosCie10(Integer idCatCapitulosCie10) {
      logger.error("Error al accesar al servicio para OBTENER POR ID CatCapitulosCie10 {}", idCatCapitulosCie10);
      return null;
   }

   public List<CatCapitulosCie10View> findAll() {
      logger.error("Error al accesar al servicio para OBTENER TODOS los CatCapitulosCie10");
      return null;
   }

   public Page<CatCapitulosCie10View> getCatCapitulosCie10Search(String datosBusqueda,
                                                                 Integer page,
                                                                 Integer size,
                                                                 String orderColumn,
                                                                 String orderType) {
      logger.error("Error al OBTENER PÁGINA de CatCapitulosCie10 - datosBusqueda: {} - page: {} - size: {} - orderColumn: {} - orderType: {}",
         datosBusqueda, page, size, orderColumn, orderType);
      return null;
   }
}
