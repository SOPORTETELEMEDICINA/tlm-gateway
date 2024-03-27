package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.expediente.views.CatEstadoConsultaView;
import net.amentum.niomedic.niogateway.api.rest.expediente.CatEstadoConsultaRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CatEstadoConsultaRestImpl extends BaseController implements CatEstadoConsultaRest {

   private Logger logger = LoggerFactory.getLogger(CatEstadoConsultaRestImpl.class);

   public List<CatEstadoConsultaView> getAll(){
      logger.error("Error al accesar al servicio para OBTENER catálogo estado consulta");
      return null;
   }

}
