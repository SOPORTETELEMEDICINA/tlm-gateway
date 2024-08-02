package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;

import net.amentum.niomedic.expediente.views.CatCie10FiltradoView;
import net.amentum.niomedic.expediente.views.CatCie10View;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.expediente.CatCie10Rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CatCie10RestImpl extends BaseController implements CatCie10Rest {

   private Logger logger = LoggerFactory.getLogger(CatCie10RestImpl.class);

   public CatCie10View getDetailsByIdCie10(Long idCie10) {
      logger.error("Error al accesar al servicio para OBTENER catálogo CIE-10 por id: {}", idCie10);
      return null;
   }

   public List<CatCie10FiltradoView> findAll() {
      logger.error("Error al accesar al servicio para OBTENER TODOS catálogo CIE-10");
      return null;
   }

   public Page<CatCie10FiltradoView> getCatCie10Search(String datosBusqueda,
                                                       Boolean activo,
                                                       Integer page,
                                                       Integer size,
                                                       String orderColumn,
                                                       String orderType,
                                                       String sexo,
                                                       Integer edad) {
      logger.error("Error al OBTENER PÁGINA de CIE-10 - datosBusqueda: {} - activo: {} - page: - {} size: {} - orderColumn: {} - orderType: {} - sexo: {} - edad: {}",
         datosBusqueda, activo, page, size, orderColumn, orderType, sexo, edad);
      return null;
   }

   @Override
   public CatCie10View createCatCie10(CatCie10View catCie10View) {
      logger.error("Error al accesar al servicio para CREAR un CatCie10: {}", catCie10View);
      return null;
   }

   @Override
   public CatCie10View updateCatCie10(Long idCie10, CatCie10View catCie10View) {
      logger.error("Error al accesar al servicio para ACTUALIZAR un CatCie10: {} para el id: {}", catCie10View, idCie10);
      return null;
   }

}
