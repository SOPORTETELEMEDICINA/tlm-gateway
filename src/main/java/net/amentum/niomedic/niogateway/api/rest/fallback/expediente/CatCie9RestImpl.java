package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;

import net.amentum.niomedic.expediente.views.CatCie9FiltradoView;
import net.amentum.niomedic.expediente.views.CatCie9View;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.expediente.CatCie9Rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CatCie9RestImpl extends BaseController implements CatCie9Rest {

   private Logger logger = LoggerFactory.getLogger(CatCie9RestImpl.class);

   public CatCie9View getDetailsByIdCie9(Long idCie9) {
      logger.error("Error al accesar al servicio para OBTENER catálogo CIE-9 por id: {}", idCie9);
      return null;
   }

   public List<CatCie9FiltradoView> findAll() {
      logger.error("Error al accesar al servicio para OBTENER TODOS catálogo CIE-9");
      return null;
   }

   public Page<CatCie9FiltradoView> getCatCie9Search(String datosBusqueda,
                                                     Boolean activo,
                                                     Integer page,
                                                     Integer size,
                                                     String orderColumn,
                                                     String orderType,
                                                     String sexo,
                                                     Integer edad) {
      logger.error("Error al OBTENER PÁGINA de CIE-9 - datosBusqueda: {} - activo: {} - page: - {} size: {} - orderColumn: {} - orderType: {} - sexo: {} - edad: {}",
         datosBusqueda, activo, page, size, orderColumn, orderType, sexo, edad);
      return null;
   }

   @Override
   public CatCie9View createCatCie9(CatCie9View catCie9View) {
      logger.error("Error al accesar al servicio para CREAR un CatCie9: {}", catCie9View);
      return null;
   }

   @Override
   public CatCie9View updateCatCie9(Long idCie9, CatCie9View catCie9View) {
      logger.error("Error al accesar al servicio para ACTUALIZAR un CatCie9: {} para el id: {}", catCie9View, idCie9);
      return null;
   }
}

