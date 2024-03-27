package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;

import net.amentum.niomedic.expediente.views.ImagenLaboratorioListView;
import net.amentum.niomedic.expediente.views.ImagenLaboratorioView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.expediente.ImagenLaboratorioRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ImagenLaboratorioRestImpl extends BaseController implements ImagenLaboratorioRest {

   private Logger logger = LoggerFactory.getLogger(ImagenLaboratorioRestImpl.class);


   public Page<ImagenLaboratorioListView> getImagenLaboratorioPage(String idPaciente,
                                                                   Long idConsulta,
                                                                   Boolean active,
                                                                   Integer page,
                                                                   Integer size,
                                                                   String orderColumn,
                                                                   String orderType) {
      logger.error("Error al OBTENER PÁGINA de imagen de laboratorio - active {} - idPaciente {} - idConsulta {} - page {} - size: {} - orderColumn: {} - orderType: {}",
         active, idPaciente, idConsulta, page, size, orderColumn, orderType);
      return null;
   }

   public void subirArchivo(String idPaciente, ImagenLaboratorioView archivobase64) {
      logger.error("Error al subir el archivo en base64: {} del paciente: {}", archivobase64, idPaciente);
   }

   @Override
   public void eliminarImagenLaboratorio(Long idImagenLaboratorio) {
      logger.error("Error al ELIMINAR imagen con el id:{}", idImagenLaboratorio);
   }

   @Override
   public List<ImagenLaboratorioListView> getDocumentosPorPadecimiento(Long idPadecimiento) {
      logger.error("Error al OBTENER las imagenes con el idPadecimiento:{}", idPadecimiento);
      return null;
   }
}
