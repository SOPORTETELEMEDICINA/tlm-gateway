package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.expediente.views.CatalogoInstitucionMedicaView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.expediente.CatalogoInstitucionMedicaRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

//import org.springframework.data.domain.Page;

public class CatalogoInstitucionMedicaRestImpl extends BaseController implements CatalogoInstitucionMedicaRest {

   private Logger logger = LoggerFactory.getLogger(CatalogoInstitucionMedicaRestImpl.class);

   public void createdCatalogoInstitucionMedica(CatalogoInstitucionMedicaView catalogoInstitucionMedicaView) {
      logger.error("Error al accesar al servicio para AGREGAR al catálogo de institución médica: {}", catalogoInstitucionMedicaView);
   }


   public void updateCatalogoInstitucionMedica(Long idCatalogoInstitucionMedica, CatalogoInstitucionMedicaView catalogoInstitucionMedicaView) {
      logger.error("Error al accesar al servicio para MODIFICAR un catálogo de institución médica: {} al ID: {}", catalogoInstitucionMedicaView, idCatalogoInstitucionMedica);
   }


   public void deleteCatalogoInstitucionMedica(Long idCatalogoInstitucionMedica) {
      logger.error("Error al accesar al servicio para BORRAR un catálogo de institución médica: {}", idCatalogoInstitucionMedica);
   }


   public CatalogoInstitucionMedicaView getDetailsByIdCatalogoInstitucionMedica(Long idCatalogoInstitucionMedica) {
      logger.error("Error al accesar al servicio para OBTENER una catálogo de institución médica por id: {}", idCatalogoInstitucionMedica);
      return null;
   }


   public List<CatalogoInstitucionMedicaView> findAll(Boolean active) {
      logger.error("Error al accesar al servicio para OBTENER TODOS los catálogo de institución médica que el activo sea {}", active);
      return null;
   }


   public Page<CatalogoInstitucionMedicaView> getCatalogoInstitucionMedicaPage(Boolean active,
                                                                               String name,
                                                                               Integer page,
                                                                               Integer size,
                                                                               String orderColumn,
                                                                               String orderType) {
      logger.error("Error al OBTENER PÁGINA de catálogo de institución médica - active: {} - name: {} - page: - {} size: {} - orderColumn: {} - orderType: {}",
         active, name, page, size, orderColumn, orderType);
      return null;
   }


}

