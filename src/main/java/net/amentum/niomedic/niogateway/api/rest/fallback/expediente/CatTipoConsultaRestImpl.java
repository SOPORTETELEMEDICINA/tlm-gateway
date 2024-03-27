package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.expediente.views.CatTipoConsultaView;
import net.amentum.niomedic.niogateway.api.rest.expediente.CatTipoConsultaRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CatTipoConsultaRestImpl extends BaseController implements CatTipoConsultaRest {

   private Logger logger = LoggerFactory.getLogger(CatTipoConsultaRestImpl.class);

   public List<CatTipoConsultaView> getAll(){
      logger.error("Error al accesar al servicio para OBTENER catálogo tipo consulta");
      return null;
   }

}
