package net.amentum.niomedic.niogateway.api.rest.fallback.catalogos;

import net.amentum.niomedic.catalogos.views.CatCifView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.catalogos.CatCifRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CatCifRestImpl extends BaseController implements CatCifRest {

   private Logger logger = LoggerFactory.getLogger(CatCifRestImpl.class);

   public CatCifView getDetailsByIdCatCif(Integer idCatCif) {
      logger.error("Error al accesar al servicio para OBTENER catálogo CIF por id: {}", idCatCif);
      return null;
   }

   public List<CatCifView> findAll() {
      logger.error("Error al accesar al servicio para OBTENER TODOS catálogo CIF");
      return null;
   }

   public Page<CatCifView> getCatCifSearch(String datosBusqueda,
                                         Boolean activo,
                                         Integer page,
                                         Integer size,
                                         String orderColumn,
                                         String orderType) {
      logger.error("Error al OBTENER PÁGINA de CIF - datosBusqueda: {} - activo: {} - page: - {} size: {} - orderColumn: {} - orderType: {}",
         datosBusqueda, activo, page, size, orderColumn, orderType);
      return null;
   }

   @Override
   public CatCifView createCatCif(CatCifView catCifView) {
      logger.error("Error al accesar al servicio para CREAR un CatCif: {}", catCifView);
      return null;
   }

   @Override
   public CatCifView updateCatCif(Integer idCatCif, CatCifView catCifView) {
      logger.error("Error al accesar al servicio para ACTUALIZAR un CatCif: {} para el id: {}", catCifView, idCatCif);
      return null;
   }

}
