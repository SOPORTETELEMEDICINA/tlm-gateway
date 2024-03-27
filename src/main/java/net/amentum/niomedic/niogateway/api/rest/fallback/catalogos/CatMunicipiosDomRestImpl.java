package net.amentum.niomedic.niogateway.api.rest.fallback.catalogos;

import net.amentum.niomedic.catalogos.views.CatMunicipiosDomView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.catalogos.CatMunicipiosDomRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CatMunicipiosDomRestImpl extends BaseController implements CatMunicipiosDomRest {

   private Logger logger = LoggerFactory.getLogger(CatMunicipiosDomRestImpl.class);

   public CatMunicipiosDomView getDetailsByIdCatMunicipiosDom(Integer idCatMunicipiosDom) {
      logger.error("Error al accesar al servicio para OBTENER POR ID CatMunicipiosDom {}", idCatMunicipiosDom);
      return null;
   }

   public List<CatMunicipiosDomView> findAll() {
      logger.error("Error al accesar al servicio para OBTENER TODOS los CatMunicipiosDom");
      return null;
   }

   public Page<CatMunicipiosDomView> getCatMunicipiosDomSearch(String datosBusqueda,
                                                               Integer page,
                                                               Integer size,
                                                               String orderColumn,
                                                               String orderType) {
      logger.error("Error al OBTENER PÁGINA de CatMunicipiosDom - datosBusqueda: {} - page: {} - size: {} - orderColumn: {} - orderType: {}",
         datosBusqueda, page, size, orderColumn, orderType);
      return null;
   }
}
