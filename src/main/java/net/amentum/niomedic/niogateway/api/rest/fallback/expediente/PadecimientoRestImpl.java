package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.expediente.views.PadecimientoView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.expediente.PadecimientoRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

//import org.springframework.data.domain.Page;

public class PadecimientoRestImpl extends BaseController implements PadecimientoRest {

   private Logger logger = LoggerFactory.getLogger(PadecimientoRestImpl.class);

   public void createPadecimiento(PadecimientoView padecimientoView) {
      logger.error("Error al accesar al servicio para AGREGAR un Padecimiento: {}", padecimientoView);
   }

   public void updatePadecimiento(Long idPadecimiento, PadecimientoView padecimientoView){
      logger.error("Error al accesar el servicio para MODIFICAR Padecimiento {} al padecimiento {}",padecimientoView,idPadecimiento);
   }


   public void deletePadecimiento(String idPaciente) {
      logger.error("Error al accesar al servicio para BORRAR Padecimiento al paciente {}", idPaciente);
   }

   public PadecimientoView getDetailsByIdPadecimiento(Long idPadecimiento) {
      logger.error("Error al accesar al servicio para OBTENER POR ID Padecimiento del paciente {}", idPadecimiento);
      return null;
   }

   public PadecimientoView getDetailsByIdPadecimientoAndIdPaciente(Long idPadecimiento, String idPaciente) {
      logger.error("Error al OBTENER DETALLES por ID padecimiento: {} y por ID paciente: {}", idPadecimiento, idPaciente);
      return null;
   }

   public List<PadecimientoView> findAll(Boolean active) {
      logger.error("Error al accesar al servicio para OBTENER TODOS los Padecimiento que el activo sea {}", active);
      return null;
   }


   public Page<PadecimientoView> getPadecimientoPage(Boolean active,
                                                     String name,
                                                     Integer page,
                                                     Integer size,
                                                     String orderColumn,
                                                     String orderType) {
      logger.error("Error al OBTENER PÁGINA de Padecimiento - active: {} - name: {} - page: - {} size: {} - orderColumn: {} - orderType: {}",
         active, name, page, size, orderColumn, orderType);
      return null;
   }




}
