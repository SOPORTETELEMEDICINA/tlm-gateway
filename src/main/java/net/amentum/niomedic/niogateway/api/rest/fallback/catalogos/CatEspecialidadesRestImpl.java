package net.amentum.niomedic.niogateway.api.rest.fallback.catalogos;

import net.amentum.niomedic.catalogos.views.CatEspecialidadesView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.catalogos.CatEspecialidadesRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;

public class CatEspecialidadesRestImpl extends BaseController implements CatEspecialidadesRest {

   private Logger logger = LoggerFactory.getLogger(CatEspecialidadesRestImpl.class);

   @Override
   public List<CatEspecialidadesView> getEspecialidadesActivas() {
      logger.error("Error al acceder al servicio para obtener especialidades activas");
      return Collections.emptyList();  // Devolvemos una lista vacía en caso de error
   }

   public CatEspecialidadesView getDetailsByIdCatEspecialidades(Integer idCatEspecialidades) {
      logger.error("Error al accesar al servicio para OBTENER catálogo Especialidades por id: {}", idCatEspecialidades);
      return null;
   }

   public List<CatEspecialidadesView> findAll() {
      logger.error("Error al accesar al servicio para OBTENER TODOS catálogo Especialidades");
      return null;
   }

   public Page<CatEspecialidadesView> getCatEspecialidadesSearch(String datosBusqueda,
                                                             Boolean activo,
                                                             Integer page,
                                                             Integer size,
                                                             String orderColumn,
                                                             String orderType) {
      logger.error("Error al OBTENER PÁGINA de Especialidades - datosBusqueda: {} - activo: {} - page: - {} size: {} - orderColumn: {} - orderType: {}",
         datosBusqueda, activo, page, size, orderColumn, orderType);
      return null;
   }

   @Override
   public CatEspecialidadesView createCatEspecialidades(CatEspecialidadesView catCifView) {
      logger.error("Error al accesar al servicio para CREAR un CatEspecialidades: {}", catCifView);
      return null;
   }

   @Override
   public CatEspecialidadesView updateCatEspecialidades(Integer idCatEspecialidades, CatEspecialidadesView catCifView) {
      logger.error("Error al accesar al servicio para ACTUALIZAR un CatEspecialidades: {} para el id: {}", catCifView, idCatEspecialidades);
      return null;
   }

}
