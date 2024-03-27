package net.amentum.niomedic.niogateway.api.rest.fallback.catalogos;

import net.amentum.niomedic.catalogos.views.CatGpoTerapeuticoMedView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.catalogos.CatGpoTerapeuticoMedRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CatGpoTerapeuticoMedRestImpl extends BaseController implements CatGpoTerapeuticoMedRest {

   private Logger logger = LoggerFactory.getLogger(CatGpoTerapeuticoMedRestImpl.class);

   public CatGpoTerapeuticoMedView getDetailsByIdCatGpoTerapeuticoMed(Integer idCatGpoTerapeuticoMed) {
      logger.error("Error al accesar al servicio para OBTENER POR ID CatGpoTerapeuticoMed {}", idCatGpoTerapeuticoMed);
      return null;
   }

   public List<CatGpoTerapeuticoMedView> findAll() {
      logger.error("Error al accesar al servicio para OBTENER TODOS los CatGpoTerapeuticoMed");
      return null;
   }

   public Page<CatGpoTerapeuticoMedView> getCatGpoTerapeuticoMedSearch(String datosBusqueda,
                                                                       Integer page,
                                                                       Integer size,
                                                                       String orderColumn,
                                                                       String orderType) {
      logger.error("Error al OBTENER PÁGINA de CatGpoTerapeuticoMed - datosBusqueda: {} - page: {} - size: {} - orderColumn: {} - orderType: {}",
         datosBusqueda, page, size, orderColumn, orderType);
      return null;
   }
}
