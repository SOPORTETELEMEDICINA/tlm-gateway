package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.expediente.views.CatalogoDrogasView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.expediente.CatalogoDrogasRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

//import org.springframework.data.domain.Page;

public class CatalogoDrogasRestImpl extends BaseController implements CatalogoDrogasRest {

   private Logger logger = LoggerFactory.getLogger(CatalogoDrogasRestImpl.class);


   public void createdCatalogoDrogas(CatalogoDrogasView catalogoDrogasView) {
      logger.error("Error al accesar al servicio para AGREGAR al catálogo drogas: {}", catalogoDrogasView);
   }


   public void updateCatalogoDrogas(Long idCatalogoDroga, CatalogoDrogasView catalogoDrogasView) {
      logger.error("Error al accesar al servicio para MODIFICAR un catálogo de drogas: {} al ID: {}", catalogoDrogasView, idCatalogoDroga);
   }


   public void deleteCatalogoDrogas(Long idCatalogoDroga) {
      logger.error("Error al accesar al servicio para BORRAR un catálogo de drogas: {}", idCatalogoDroga);
   }


   public CatalogoDrogasView getDetailsByIdCatalogoDrogas(Long idCatalogoDroga) {
      logger.error("Error al accesar al servicio para OBTENER una catálogo de drogas por id: {}", idCatalogoDroga);
      return null;
   }


   public List<CatalogoDrogasView> findAll(Boolean active) {
      logger.error("Error al accesar al servicio para OBTENER TODOS los catálogo de drogas que el activo sea {}", active);
      return null;
   }


   public Page<CatalogoDrogasView> getCatalogoDrogasPage(Boolean active,
                                                         String name,
                                                         Integer page,
                                                         Integer size,
                                                         String orderColumn,
                                                         String orderType) {
      logger.error("Error al OBTENER PÁGINA de catálogo de drogas - active: {} - name: {} - page: - {} size: {} - orderColumn: {} - orderType: {}",
         active, name, page, size, orderColumn, orderType);
      return null;
   }


}
