package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.expediente.views.CatalogoEspecialidadView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.expediente.CatalogoEspecialidadRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

//import org.springframework.data.domain.Page;

public class CatalogoEspecialidadRestImpl extends BaseController implements CatalogoEspecialidadRest {

   private Logger logger = LoggerFactory.getLogger(CatalogoEspecialidadRestImpl.class);


   public void createdCatalogoEspecialidad(CatalogoEspecialidadView catalogoEspecialidadView) {
      logger.error("Error al accesar al servicio para AGREGAR al catálogo de especialidad: {}", catalogoEspecialidadView);
   }


   public void updateCatalogoEspecialidad(Long idCatalogoEspecialidad, CatalogoEspecialidadView catalogoEspecialidadView) {
      logger.error("Error al accesar al servicio para MODIFICAR un catálogo de especialidad: {} al ID: {}", catalogoEspecialidadView, idCatalogoEspecialidad);
   }


   public void deleteCatalogoEspecialidad(Long idCatalogoEspecialidad) {
      logger.error("Error al accesar al servicio para BORRAR un catálogo de especialidad: {}", idCatalogoEspecialidad);
   }


   public CatalogoEspecialidadView getDetailsByIdCatalogoEspecialidad(Long idCatalogoEspecialidad) {
      logger.error("Error al accesar al servicio para OBTENER una catálogo de especialidad por id: {}", idCatalogoEspecialidad);
      return null;
   }


   public List<CatalogoEspecialidadView> findAll(Boolean active) {
      logger.error("Error al accesar al servicio para OBTENER TODOS los catálogo de especialidad que el activo sea {}", active);
      return null;
   }


   public Page<CatalogoEspecialidadView> getCatalogoEspecialidadPage(Boolean active,
                                                                     String name,
                                                                     Integer page,
                                                                     Integer size,
                                                                     String orderColumn,
                                                                     String orderType) {
      logger.error("Error al OBTENER PÁGINA de catálogo de especialidad - active: {} - name: {} - page: - {} size: {} - orderColumn: {} - orderType: {}",
         active, name, page, size, orderColumn, orderType);
      return null;
   }


}

