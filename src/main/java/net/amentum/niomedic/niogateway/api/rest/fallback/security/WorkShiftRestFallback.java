package net.amentum.niomedic.niogateway.api.rest.fallback.security;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.security.WorkShiftRest;
import net.amentum.niomedic.niogateway.api.rest.views.security.WorkShiftView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Collection;
import java.util.Collections;

public class WorkShiftRestFallback extends BaseController implements WorkShiftRest {

   private final Logger logger = LoggerFactory.getLogger(WorkShiftRestFallback.class);


   @Override
   public void addWorkShift(WorkShiftView workShiftView) {
      logger.error("Error al agregar turno laboral - {}", workShiftView);
   }

   @Override
   public void updateWorkShift(Long idWorkShift, WorkShiftView workShiftView) {
      logger.error("Error al actualizar turno laboral - {} - {}", idWorkShift, workShiftView);
   }

   @Override
   public void deleteWorkShift(Long idWorkShift) {
      logger.error("Error al eliminar turno laboral: {}", idWorkShift);
   }

   @Override
   public WorkShiftView findWorkShiftById(Long idWorkShift) {
      logger.error("Error al obtener turno laboral: {}", idWorkShift);
      return null;
   }

   @Override
   public Collection<WorkShiftView> findAllWorkShifts() {
      logger.error("Error al obtener turnos laborales");
      return Collections.emptyList();
   }

   @Override
   public Page<WorkShiftView> findWorkShiftPage(Boolean active, String name, Integer page, Integer size, String orderColumn, String orderType) {
      logger.error("Error al obtener pagina de turnos laborales");
      return new Page<>();
//      return null;
   }
}
