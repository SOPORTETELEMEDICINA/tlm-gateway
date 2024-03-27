package net.amentum.niomedic.niogateway.api.rest.fallback.pacientes;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.pacientes.PacienteRest;
import net.amentum.niomedic.pacientes.views.PacientePageView;
import net.amentum.niomedic.pacientes.views.PacienteView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PacienteRestImpl extends BaseController implements PacienteRest {

   private Logger logger = LoggerFactory.getLogger(PacienteRestImpl.class);

   public PacienteView createPaciente(PacienteView pacienteView) {
      logger.error("Error al accesar al servicio para AGREGAR un paciente: {}", pacienteView);
      return null;
   }

   public PacienteView updatePaciente(String idPaciente, PacienteView pacienteView) {
      logger.error("Error al accesar al servicio para MODIFICAR un paciente: {}", pacienteView);
      return null;
   }

   public PacienteView getPacienteById(String idPaciente) {
      logger.error("Error al accesar al servicio para OBTENER POR ID un paciente: {}", idPaciente);
      return null;
   }

   public PacienteView getPacienteByIdUsuario(Integer idUsuario) {
      logger.error("Error al accesar al servicio para OBTENER POR ID USUARIO  un paciente: {}", idUsuario);
      return null;
   }

   public PacienteView getDetailsPacienteByCurp(String curp) {
      logger.error("Error al accesar al servicio para OBTENER POR CURP un paciente: {}", curp);
      return null;
   }

   //   public Page<PacientePageView> getPacientePage(Boolean active,
//                                                 String name,
//                                                 Integer page,
//                                                 Integer size,
//                                                 String orderColumn,
//                                                 String orderType){
//
   public Page<PacientePageView> getPacientePage(String datosBusqueda,
                                                 Boolean active,
//                                                 String name,
                                                 Integer page,
                                                 Integer size,
                                                 String orderColumn,
                                                 String orderType,
                                                 Long selectGroup) {  // GGR20200618 Agrego grupo seleccionado
      logger.error("Error al OBTENER PÁGINA de pacientes - active: {} - page: - {} size: {} - orderColumn: {} - orderType: {} - selectGroup: {}",
         active, page, size, orderColumn, orderType, selectGroup);
//      return new Page<PacienteView>();
      return null;
   }

@Override
public Page<PacientePageView> getPacienteSearch(Boolean active, String datosBusqueda, String nombre,
		String apellidoPaterno, String apellidoMaterno, String telefonoMovil, String telefonoFijo, String correo,
		String rfc, String curp, Integer page, Integer size, String orderColumn, String orderType) {
	logger.info("Error al OBTENER PÁGINA de pacientes  " +
            "- active {} - datosBusqueda: {} - nombre: {} - apellidoPaterno: {} - apellidoMaterno: {} - telefonoMovil: {} - telefonoFijo: {} - correo: {} - rfc: {} - curp: {} - " +
            "page: {} - size: {} - orderColumn: {} - orderType: {}",
         active, datosBusqueda, nombre, apellidoPaterno, apellidoMaterno, telefonoMovil, telefonoFijo, correo, rfc, curp, page, size, orderColumn, orderType);
	return null;
}

    // Sre19062020 Nuevo para actualizar grupos de medicos
    public void updatePacienteGroups(Long idUserApp, List<Long> medicoGroups) {
        logger.error("Error al accesar al servicio para actualizar grupos de un paciente: {}", idUserApp);
    }

   @Override
   public Page<PacientePageView> getPacientePageCanalizados(String datosBusqueda,
                                                            Boolean active,
                                                            Integer page,
                                                            Integer size,
                                                            String orderColumn,
                                                            String orderType,
                                                            Long idUser) {
      logger.error("Error al OBTENER PÁGINA de pacientes - active: {} - page: - {} size: {} - orderColumn: {} - orderType: {} - idUser: {}",
              active, page, size, orderColumn, orderType, idUser);
      return null;
   }

   @Override
   public void deleteRollback(Long idUserApp) {
      logger.error("Error al acceder al servicio para hacer rollback");
   }

   @Override
   public void setIdDevice(Integer idUsuario, String idDevice) {
      logger.error("Error al acceder al servicio para hacer update del id de dispositivo");
   }
}

