package net.amentum.niomedic.niogateway.api.rest.fallback.medicos;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.medicos.views.EspecialidadView;
import net.amentum.niomedic.niogateway.api.rest.medicos.EspecialidadRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

public class EspecialidadRestImpl extends BaseController implements EspecialidadRest {

   private Logger logger = LoggerFactory.getLogger(EspecialidadRestImpl.class);

   public void createEspecialidad(String idMedico, ArrayList<EspecialidadView> especialidadViewArrayList) {
      logger.error("Error al accesar al servicio para AGREGAR especialidad: {} al médico: {}", especialidadViewArrayList, idMedico);
   }

   public void updateEspecialidad(String idMedico, ArrayList<EspecialidadView> especialidadViewArrayList) {
      logger.error("Error al accesar al servicio para MODIFICAR especialidad: {} al médico: {}", especialidadViewArrayList, idMedico);
   }

   public void deleteEspecialidad(String idMedico, ArrayList<EspecialidadView> especialidadViewArrayList) {
      logger.error("Error al accesar al servicio para BORRAR especialidad: {} al médico: {}", especialidadViewArrayList, idMedico);
   }

   public void subirCedula(MultipartFile[] file, String idMedico) {
      logger.error("Error al SUBIR cédula: {} del médico: {}", file, idMedico);
   }

   public void subirDiploma(MultipartFile[] file, String idMedico) {
      logger.error("Error al SUBIR diploma: {} del médico: {}", file, idMedico);
   }
}
