package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;


import net.amentum.niomedic.expediente.views.TurnosLaboralesView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;

import net.amentum.niomedic.niogateway.api.rest.expediente.TurnosLaboralesRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class TurnosLaboralesRestImpl extends BaseController implements TurnosLaboralesRest {

   private Logger logger = LoggerFactory.getLogger(TurnosLaboralesRestImpl.class);

   public void createTurnosLaborales(TurnosLaboralesView turnosLaboralesView){
      logger.error("Error al accesar al servicio para AGREGAR turnosLaborales: {}", turnosLaboralesView);
   }

   public void updateTurnosLaborales(Long idTurnosLaborales, TurnosLaboralesView turnosLaboralesView){
      logger.error("Error al accesar el servicio para MODIFICAR turnosLaborales {} al idTurnosLaborales {}", turnosLaboralesView, idTurnosLaborales);
   }

   public TurnosLaboralesView getDetailsByIdUsuario(Long idUsuario){
      logger.error("Error al accesar al servicio para OBTENER POR ID turnosLaborales {}", idUsuario);
      return null;
   }

}
