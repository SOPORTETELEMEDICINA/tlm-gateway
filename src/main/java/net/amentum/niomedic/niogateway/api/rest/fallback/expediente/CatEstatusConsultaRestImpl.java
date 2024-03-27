package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.expediente.views.CatEstatusConsultaView;
import net.amentum.niomedic.niogateway.api.rest.expediente.CatEstatusConsultaRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CatEstatusConsultaRestImpl extends BaseController implements CatEstatusConsultaRest {

   private Logger logger = LoggerFactory.getLogger(CatEstatusConsultaRestImpl.class);

   public List<CatEstatusConsultaView> getAll(){
      logger.error("Error al accesar al servicio para OBTENER catálogo estatus consulta");
      return null;
   }

}
