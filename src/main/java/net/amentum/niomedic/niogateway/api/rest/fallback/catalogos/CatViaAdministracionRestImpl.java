package net.amentum.niomedic.niogateway.api.rest.fallback.catalogos;

import net.amentum.niomedic.catalogos.views.CatViaAdministracionView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.catalogos.CatViaAdministracionRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CatViaAdministracionRestImpl extends BaseController implements CatViaAdministracionRest {

   private Logger logger = LoggerFactory.getLogger(CatViaAdministracionRestImpl.class);

   public CatViaAdministracionView getDetailsByIdCatViaAdministracion(Integer idCatViaAdministracion) {
      logger.error("Error al accesar al servicio para OBTENER POR ID CatViaAdministracion {}", idCatViaAdministracion);
      return null;
   }

   public List<CatViaAdministracionView> findAll() {
      logger.error("Error al accesar al servicio para OBTENER TODOS los CatViaAdministracion");
      return null;
   }

   public Page<CatViaAdministracionView> getCatViaAdministracionSearch(String datosBusqueda,
		   															   Boolean activo,
                                                                       Integer page,
                                                                       Integer size,
                                                                       String orderColumn,
                                                                       String orderType) {
      logger.error("Error al OBTENER PÁGINA de CatViaAdministracion - datosBusqueda: {} - page: {} - size: {} - orderColumn: {} - orderType: {}",
         datosBusqueda, page, size, orderColumn, orderType);
      return null;
   }

   @Override
	public CatViaAdministracionView createCatViaAdministracion(CatViaAdministracionView catViaAdministracion) {
	   logger.error("Error al accesar al servicio para CREAR un nuevo registro en CatViaAdministracion");
		return null;
	}

   @Override
   public CatViaAdministracionView updateCatViaAdministracion(Integer idCatViaAdministracion,
		CatViaAdministracionView catViaAdministracion) {
	   logger.error("Error al accesar al servicio para ACTUALIZAR un registro en CatViaAdministracion");
	   return null;
   }
}
