package net.amentum.niomedic.niogateway.api.rest.fallback.catalogos;

import net.amentum.niomedic.catalogos.views.CatMotivosEnvioView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.catalogos.CatMotivosEnvioRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CatMotivosEnvioRestImpl extends BaseController implements CatMotivosEnvioRest {

   private Logger logger = LoggerFactory.getLogger(CatMotivosEnvioRestImpl.class);

   public CatMotivosEnvioView getDetailsByIdCatMotivosEnvio(Integer idCatMotivosEnvio) {
      logger.error("Error al accesar al servicio para OBTENER catálogo Motivos Envio por id: {}", idCatMotivosEnvio);
      return null;
   }

   public List<CatMotivosEnvioView> findAll() {
      logger.error("Error al accesar al servicio para OBTENER TODOS catálogo Motivos Envio");
      return null;
   }

   public Page<CatMotivosEnvioView> getCatMotivosEnvioSearch(String datosBusqueda,
                                                             Boolean activo,
                                                             Integer page,
                                                             Integer size,
                                                             String orderColumn,
                                                             String orderType) {
      logger.error("Error al OBTENER PÁGINA de Motivos Envio - datosBusqueda: {} - activo: {} - page: - {} size: {} - orderColumn: {} - orderType: {}",
         datosBusqueda, activo, page, size, orderColumn, orderType);
      return null;
   }

   @Override
   public CatMotivosEnvioView createCatMotivosEnvio(CatMotivosEnvioView catCifView) {
      logger.error("Error al accesar al servicio para CREAR un CatMotivosEnvio: {}", catCifView);
      return null;
   }

   @Override
   public CatMotivosEnvioView updateCatMotivosEnvio(Integer idCatMotivosEnvio, CatMotivosEnvioView catCifView) {
      logger.error("Error al accesar al servicio para ACTUALIZAR un CatMotivosEnvio: {} para el id: {}", catCifView, idCatMotivosEnvio);
      return null;
   }

}
