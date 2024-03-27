package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.expediente.views.CatalogoServicioMedicoView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.expediente.CatalogoServicioMedicoRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

//import org.springframework.data.domain.Page;

public class CatalogoServicioMedicoRestImpl extends BaseController implements CatalogoServicioMedicoRest {

   private Logger logger = LoggerFactory.getLogger(CatalogoServicioMedicoRestImpl.class);

   public void createdCatalogoServicioMedico(CatalogoServicioMedicoView catalogoServicioMedicoView) {
      logger.error("Error al accesar al servicio para AGREGAR al catálogo de servicio médico: {}", catalogoServicioMedicoView);
   }


   public void updateCatalogoServicioMedico(Long idCatalogoServicioMedico, CatalogoServicioMedicoView catalogoServicioMedicoView) {
      logger.error("Error al accesar al servicio para MODIFICAR un catálogo de servicio médico: {} al ID: {}", catalogoServicioMedicoView, idCatalogoServicioMedico);
   }


   public void deleteCatalogoServicioMedico(Long idCatalogoServicioMedico) {
      logger.error("Error al accesar al servicio para BORRAR un catálogo de servicio médico: {}", idCatalogoServicioMedico);
   }


   public CatalogoServicioMedicoView getDetailsByIdCatalogoServicioMedico(Long idCatalogoServicioMedico) {
      logger.error("Error al accesar al servicio para OBTENER una catálogo de servicio médico por id: {}", idCatalogoServicioMedico);
      return null;
   }


   public List<CatalogoServicioMedicoView> findAll(Boolean active) {
      logger.error("Error al accesar al servicio para OBTENER TODOS los catálogo de servicio médico que el activo sea {}", active);
      return null;
   }


   public Page<CatalogoServicioMedicoView> getCatalogoServicioMedicoPage(Boolean active,
                                                                         String name,
                                                                         Integer page,
                                                                         Integer size,
                                                                         String orderColumn,
                                                                         String orderType) {
      logger.error("Error al OBTENER PÁGINA de catálogo de servicio médico - active: {} - name: {} - page: - {} size: {} - orderColumn: {} - orderType: {}",
         active, name, page, size, orderColumn, orderType);
      return null;
   }
}

