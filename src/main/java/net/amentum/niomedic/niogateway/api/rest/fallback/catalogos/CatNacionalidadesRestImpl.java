package net.amentum.niomedic.niogateway.api.rest.fallback.catalogos;

import net.amentum.niomedic.catalogos.views.CatNacionalidadesView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.catalogos.CatNacionalidadesRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CatNacionalidadesRestImpl extends BaseController implements CatNacionalidadesRest {

   private Logger logger = LoggerFactory.getLogger(CatNacionalidadesRestImpl.class);

   public CatNacionalidadesView getDetailsByIdCatNacionalidades(Integer idCatNacionalidades) {
      logger.error("Error al accesar al servicio para OBTENER POR ID CatNacionalidades {}", idCatNacionalidades);
      return null;
   }

   public List<CatNacionalidadesView> findAll() {
      logger.error("Error al accesar al servicio para OBTENER TODOS los CatNacionalidades");
      return null;
   }

   public Page<CatNacionalidadesView> getCatNacionalidadesSearch(String datosBusqueda,
		   														 Boolean activo,
                                                                 Integer page,
                                                                 Integer size,
                                                                 String orderColumn,
                                                                 String orderType) {
      logger.error("Error al OBTENER PÁGINA de CatNacionalidades - datosBusqueda: {} - page: {} - size: {} - orderColumn: {} - orderType: {}",
         datosBusqueda, page, size, orderColumn, orderType);
      return null;
   }

   @Override
   public CatNacionalidadesView createCatNacionalidades(CatNacionalidadesView catNacionalidadesView) {
	   logger.error("Error al accesar al servicio para Crear una nueva CatNacionalidades");
	   return null;
   }

   @Override
   public CatNacionalidadesView updateCatNacionalidades(Integer idCatNacionalidades,
		   CatNacionalidadesView catNacionalidadesView) {
	   logger.error("Error al accesar al servicio para Actualizar CatNacionalidades");
	   return null;
   }
}
