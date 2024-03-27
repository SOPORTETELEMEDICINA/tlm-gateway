package net.amentum.niomedic.niogateway.api.rest.fallback.catalogos;

import net.amentum.niomedic.catalogos.views.CatEstadoConsultaView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.catalogos.CatEstadoConsultaRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CatEstadoConsultaRestImpl extends BaseController implements CatEstadoConsultaRest {

   private Logger logger = LoggerFactory.getLogger(CatEstadoConsultaRestImpl.class);

   public CatEstadoConsultaView getDetailsByIdCatEstadoConsulta(Integer idEstadoConsulta) {
      logger.error("Error al accesar al servicio para OBTENER POR ID CatEstadoConsulta {}", idEstadoConsulta);
      return null;
   }

   public List<CatEstadoConsultaView> findAll() {
      logger.error("Error al accesar al servicio para OBTENER TODOS los CatEstadoConsulta");
      return null;
   }

   public Page<CatEstadoConsultaView> getCatEstadoConsultaSearch(String datosBusqueda,
                                                                 Integer page,
                                                                 Integer size,
                                                                 String orderColumn,
                                                                 String orderType) {
      logger.error("Error al OBTENER PÁGINA de CatEstadoConsulta - datosBusqueda: {} - page: {} - size: {} - orderColumn: {} - orderType: {}",
         datosBusqueda, page, size, orderColumn, orderType);
      return null;
   }
}
