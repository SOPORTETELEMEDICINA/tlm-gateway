package net.amentum.niomedic.niogateway.api.rest.fallback.catalogos;

import net.amentum.niomedic.catalogos.views.CatCuadroIoMedView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.catalogos.CatCuadroIoMedRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CatCuadroIoMedRestImpl extends BaseController implements CatCuadroIoMedRest {

   private Logger logger = LoggerFactory.getLogger(CatCuadroIoMedRestImpl.class);

   public CatCuadroIoMedView getDetailsByIdCatCuadroIoMed(Integer idCatCuadroIoMed) {
      logger.error("Error al accesar al servicio para OBTENER POR ID CatCuadroIoMed {}", idCatCuadroIoMed);
      return null;
   }

   public List<CatCuadroIoMedView> findAll() {
      logger.error("Error al accesar al servicio para OBTENER TODOS los CatCuadroIoMed");
      return null;
   }

   public Page<CatCuadroIoMedView> getCatCuadroIoMedSearch(String datosBusqueda,
                                                           Integer page,
                                                           Integer size,
                                                           String orderColumn,
                                                           String orderType) {
      logger.error("Error al OBTENER PÁGINA de CatCuadroIoMed - datosBusqueda: {} - page: {} - size: {} - orderColumn: {} - orderType: {}",
         datosBusqueda, page, size, orderColumn, orderType);
      return null;
   }
}
