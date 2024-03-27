package net.amentum.niomedic.niogateway.api.rest.fallback.catalogos;

import net.amentum.niomedic.catalogos.views.CatDolometroView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.catalogos.CatDolometroRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CatDolometroRestImpl extends BaseController implements CatDolometroRest {

   private Logger logger = LoggerFactory.getLogger(CatDolometroRestImpl.class);

   public CatDolometroView getDetailsByIdCatDolometro(Integer idCatDolometro) {
      logger.error("Error al accesar al servicio para OBTENER POR ID CatDolometro {}", idCatDolometro);
      return null;
   }

   public List<CatDolometroView> findAll() {
      logger.error("Error al accesar al servicio para OBTENER TODOS los CatDolometro");
      return null;
   }

   public Page<CatDolometroView> getCatDolometroSearch(String datosBusqueda,
                                           Integer page,
                                           Integer size,
                                           String orderColumn,
                                           String orderType) {
      logger.error("Error al OBTENER PÁGINA de CatDolometro - datosBusqueda: {} - page: {} - size: {} - orderColumn: {} - orderType: {}",
         datosBusqueda, page, size, orderColumn, orderType);
      return null;
   }
}
