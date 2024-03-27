package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.expediente.views.CatalogoDosisVacunaView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.expediente.CatalogoDosisVacunaRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

//import org.springframework.data.domain.Page;

public class CatalogoDosisVacunaRestImpl extends BaseController implements CatalogoDosisVacunaRest {

   private Logger logger = LoggerFactory.getLogger(CatalogoDosisVacunaRestImpl.class);


   public void createCatalogoDosisVacuna(Long idCatalogoVacuna, CatalogoDosisVacunaView catalogoDosisVacunaView) {
      logger.error("Error al accesar al servicio para AGREGAR una dosis de vacunas: {} al catalogo de vacuna: {}", catalogoDosisVacunaView, idCatalogoVacuna);
   }


   public void updateCatalogoDosisVacuna(Long idCatalogoVacuna, CatalogoDosisVacunaView catalogoDosisVacunaView) {
      logger.error("Error al accesar al servicio para MODIFICAR una dosis de vacunas: {} al catalogo de vacuna: {}",catalogoDosisVacunaView, idCatalogoVacuna);
   }


   public void deleteCatalogoDosisVacuna(Long idCatalogoVacuna) {
      logger.error("Error al accesar al servicio para BORRAR una dosis de vacunas: {}",idCatalogoVacuna);
   }


   public CatalogoDosisVacunaView getDetailsByIdCatalogoDosisVacuna(Long idCatalogoVacuna) {
      logger.error("Error al accesar al servicio para OBTENER una dosis de vacunas por id: {}",idCatalogoVacuna);
      return null;
   }


   public List<CatalogoDosisVacunaView> findAll(Boolean active) {
      logger.error("Error al accesar al servicio para OBTENER TODOS los dosis de vacunas que el activo sea {}", active);
      return null;
   }


   public Page<CatalogoDosisVacunaView> getCatalogoDosisVacunaPage(Boolean active,
                                                                   String name,
                                                                   Integer page,
                                                                   Integer size,
                                                                   String orderColumn,
                                                                   String orderType) {
      logger.error("Error al OBTENER PÁGINA de dosis de vacunas - active: {} - name: {} - page: - {} size: {} - orderColumn: {} - orderType: {}",
         active, name, page, size, orderColumn, orderType);
      return null;
   }


}
