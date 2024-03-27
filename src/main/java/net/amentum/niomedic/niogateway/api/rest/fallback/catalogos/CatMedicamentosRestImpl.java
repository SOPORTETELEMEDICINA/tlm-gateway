package net.amentum.niomedic.niogateway.api.rest.fallback.catalogos;

import net.amentum.niomedic.catalogos.views.CatMedicamentosView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.catalogos.CatMedicamentosRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CatMedicamentosRestImpl extends BaseController implements CatMedicamentosRest {

   private Logger logger = LoggerFactory.getLogger(CatMedicamentosRestImpl.class);

   public CatMedicamentosView getDetailsByIdCatMedicamentos(Integer idCatMedicamentos) {
      logger.error("Error al accesar al servicio para OBTENER catálogo Medicamentos por id: {}", idCatMedicamentos);
      return null;
   }

   public List<CatMedicamentosView> findAll() {
      logger.error("Error al accesar al servicio para OBTENER TODOS catálogo Medicamentos");
      return null;
   }

   public Page<CatMedicamentosView> getCatMedicamentosSearch(String datosBusqueda,
                                                                 Boolean activo,
                                                                 Integer page,
                                                                 Integer size,
                                                                 String orderColumn,
                                                                 String orderType) {
      logger.error("Error al OBTENER PÁGINA de Medicamentos - datosBusqueda: {} - activo: {} - page: - {} size: {} - orderColumn: {} - orderType: {}",
         datosBusqueda, activo, page, size, orderColumn, orderType);
      return null;
   }

   @Override
   public CatMedicamentosView createCatMedicamentos(CatMedicamentosView catCifView) {
      logger.error("Error al accesar al servicio para CREAR un CatMedicamentos: {}", catCifView);
      return null;
   }

   @Override
   public CatMedicamentosView updateCatMedicamentos(Integer idCatMedicamentos, CatMedicamentosView catCifView) {
      logger.error("Error al accesar al servicio para ACTUALIZAR un CatMedicamentos: {} para el id: {}", catCifView, idCatMedicamentos);
      return null;
   }

}
