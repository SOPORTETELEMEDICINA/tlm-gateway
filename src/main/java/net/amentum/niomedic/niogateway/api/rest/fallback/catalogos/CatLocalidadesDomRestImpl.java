package net.amentum.niomedic.niogateway.api.rest.fallback.catalogos;

import net.amentum.niomedic.catalogos.views.CatLocalidadesDomView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.catalogos.CatLocalidadesDomRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CatLocalidadesDomRestImpl extends BaseController implements CatLocalidadesDomRest {

   private Logger logger = LoggerFactory.getLogger(CatLocalidadesDomRestImpl.class);

   public CatLocalidadesDomView getDetailsByIdCatLocalidadesDom(Integer idCatLocalidadesDom) {
      logger.error("Error al accesar al servicio para OBTENER POR ID CatLocalidadesDom {}", idCatLocalidadesDom);
      return null;
   }

   public List<CatLocalidadesDomView> findAll() {
      logger.error("Error al accesar al servicio para OBTENER TODOS los CatLocalidadesDom");
      return null;
   }

   public Page<CatLocalidadesDomView> getCatLocalidadesDomSearch(String datosBusqueda,
                                                                 Integer page,
                                                                 Integer size,
                                                                 String orderColumn,
                                                                 String orderType) {
      logger.error("Error al OBTENER PÁGINA de CatLocalidadesDom - datosBusqueda: {} - page: {} - size: {} - orderColumn: {} - orderType: {}",
         datosBusqueda, page, size, orderColumn, orderType);
      return null;
   }
}
