package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.expediente.views.DatosClinicosView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.expediente.DatosClinicosRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

//import org.springframework.data.domain.Page;

public class DatosClinicosRestImpl extends BaseController implements DatosClinicosRest {

   private Logger logger = LoggerFactory.getLogger(DatosClinicosRestImpl.class);

   public void createDatosClinicos(DatosClinicosView datosClinicosView) {
      logger.error("Error al accesar al servicio para AGREGAR un datos clinicos: {}", datosClinicosView);
   }


   public void updateDatosClinicos(String idPaciente, DatosClinicosView datosClinicosView) {
      logger.error("Error al accesar el servicio para MODIFICAR datos clinicos {} al paciente {}", datosClinicosView, idPaciente);
   }


   public void deleteDatosClinicos(String idPaciente) {
      logger.error("Error al accesar al servicio para BORRAR datos clinicos al paciente {}", idPaciente);
   }


   public DatosClinicosView getDetailsByIdDatosClinicos(String idPaciente) {
      logger.error("Error al accesar al servicio para OBTENER POR ID datos clinicos del paciente {}", idPaciente);
      return null;
   }


   public List<DatosClinicosView> findAll(Boolean active) {
      logger.error("Error al accesar al servicio para OBTENER TODOS los datos clinicos que el activo sea {}", active);
      return null;
   }


   public Page<DatosClinicosView> getDatosClinicosPage(Boolean active,
                                                       String name,
                                                       Integer page,
                                                       Integer size,
                                                       String orderColumn,
                                                       String orderType) {
      logger.error("Error al OBTENER PÁGINA de datos clinicos - active: {} - name: {} - page: - {} size: {} - orderColumn: {} - orderType: {}",
         active, name, page, size, orderColumn, orderType);
      return null;
   }

}

