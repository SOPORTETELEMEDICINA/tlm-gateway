package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;

import net.amentum.niomedic.expediente.views.EstudioLaboratorioListView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.expediente.EstudioLaboratorioRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class EstudioLaboratorioRestImpl extends BaseController implements EstudioLaboratorioRest {

   private Logger logger = LoggerFactory.getLogger(EstudioLaboratorioRestImpl.class);

   public Page<EstudioLaboratorioListView> getEstudioLaboratorioPage(Boolean active,
                                                                     String name,
                                                                     Integer page,
                                                                     Integer size,
                                                                     String orderColumn,
                                                                     String orderType) {
      logger.error("Error al OBTENER PÁGINA de estudios de laboratorio - active: {} - name: {} - page: - {} size: {} - orderColumn: {} - orderType: {}",
         active, name, page, size, orderColumn, orderType);
      return null;
   }


   @Override
   public List<List<Map<String, Object>>> getEstudioLaboratorioPorPadecimiento(Long idPadecimiento) {
      logger.error("Error al OBTENER los estudios con el idPadecimiento:{}", idPadecimiento);
      return null;
   }
}