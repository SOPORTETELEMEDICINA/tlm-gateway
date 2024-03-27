package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;
import net.amentum.niomedic.expediente.views.VacacionesView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;

import net.amentum.niomedic.niogateway.api.rest.expediente.VacacionesRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.UUID;
public class VacacionesRestImpl extends BaseController implements VacacionesRest {

   private Logger logger = LoggerFactory.getLogger(VacacionesRestImpl.class);

   public void createVacaciones(VacacionesView vacacionesView){
      logger.error("Error al accesar al servicio para AGREGAR vacaciones: {}", vacacionesView);
   }

   public void updateVacaciones(Long idVacaciones, VacacionesView vacacionesView){
      logger.error("Error al accesar el servicio para MODIFICAR vacaciones {} al idVacaciones {}", vacacionesView, idVacaciones);
   }

   public List<VacacionesView> getDetailsByIdUsuario(Long idUsuario){
      logger.error("Error al accesar al servicio para OBTENER POR ID vacaciones {}", idUsuario);
      return null;
   }
}
