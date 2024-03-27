package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;

import net.amentum.niomedic.expediente.views.DocumentosListView;
import net.amentum.niomedic.expediente.views.DocumentosView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.expediente.DocumentosRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DocumentosRestImpl extends BaseController implements DocumentosRest {

   private Logger logger = LoggerFactory.getLogger(DocumentosRestImpl.class);

   @Override
   public Page<DocumentosListView> getDocumentosPage(String idPaciente,
                                                     Long idConsulta,
                                                     Boolean active,
                                                     Integer page,
                                                     Integer size,
                                                     String orderColumn,
                                                     String orderType) {
      logger.error("Error al OBTENER PÁGINA de documentos - active {} - idPaciente {} - idConsulta {} - page {} - size: {} - orderColumn: {} - orderType: {}",
         active, idPaciente, idConsulta, page, size, orderColumn, orderType);
      return null;
   }

   @Override
   public void subirDocumentosBase64(String idPaciente, DocumentosView documentosView) {
      logger.error("Error al SUBIR el documento: {} del paciente: {}", documentosView, idPaciente);
   }

   @Override
   public void eliminarDocumento(Long idDocumento) {
      logger.error("Error al ELIMINAR documento con el id:{}", idDocumento);
   }

   @Override
   public List<DocumentosListView> getDocumentosPorPadecimiento(Long idPadecimiento) {
      logger.error("Error al OBTENER los documentos con el idPadecimiento:{}", idPadecimiento);
      return null;
   }
}
