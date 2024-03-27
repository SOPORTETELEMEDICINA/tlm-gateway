package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.expediente.views.CatalogoVacunaView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.expediente.CatalogoVacunaRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

//import org.springframework.data.domain.Page;

public class CatalogoVacunaRestImpl extends BaseController implements CatalogoVacunaRest {

   private Logger logger = LoggerFactory.getLogger(CatalogoVacunaRestImpl.class);

   public void createdCatalogoVacuna(CatalogoVacunaView catalogoVacunaView) {
      logger.error("Error al accesar al servicio para AGREGAR al catálogo de vacuna: {}", catalogoVacunaView);
   }


   public void updateCatalogoVacuna(Long idCatalogoVacuna, CatalogoVacunaView catalogoVacunaView) {
      logger.error("Error al accesar al servicio para MODIFICAR un catálogo de vacuna: {} al ID: {}", catalogoVacunaView, idCatalogoVacuna);
   }


   public void deleteCatalogoVacuna(Long idCatalogoVacuna) {
      logger.error("Error al accesar al servicio para BORRAR un catálogo de vacuna: {}", idCatalogoVacuna);
   }


   public CatalogoVacunaView getDetailsByIdCatalogoVacuna(Long idCatalogoVacuna) {
      logger.error("Error al accesar al servicio para OBTENER una catálogo de vacuna por id: {}", idCatalogoVacuna);
      return null;
   }


   public List<CatalogoVacunaView> findAll(Boolean active) {
      logger.error("Error al accesar al servicio para OBTENER TODOS los catálogo de vacuna que el activo sea {}", active);
      return null;
   }


   public Page<CatalogoVacunaView> getCatalogoVacunaPage(Boolean active,
                                                         String name,
                                                         Integer page,
                                                         Integer size,
                                                         String orderColumn,
                                                         String orderType) {
      logger.error("Error al OBTENER PÁGINA de catálogo de vacuna - active: {} - name: {} - page: - {} size: {} - orderColumn: {} - orderType: {}",
         active, name, page, size, orderColumn, orderType);
      return null;
   }
}
