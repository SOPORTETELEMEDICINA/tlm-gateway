package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;


import net.amentum.niomedic.expediente.views.CatalogoTipoEventoView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.expediente.CatalogoTipoEventoRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CatalogoTipoEventoRestImpl extends BaseController implements CatalogoTipoEventoRest {

   private Logger logger = LoggerFactory.getLogger(CatalogoTipoEventoRestImpl.class);

   public void createCatalogoTipoEvento(CatalogoTipoEventoView catalogoTipoEventoView){
      logger.error("Error al accesar al servicio para AGREGAR catalogoTipoEvento: {}", catalogoTipoEventoView);
   }

   public void updateCatalogoTipoEvento(Integer idCatalogoTipoEvento, CatalogoTipoEventoView catalogoTipoEventoView){
      logger.error("Error al accesar el servicio para MODIFICAR catalogoTipoEvento {} al idAgenda {}", catalogoTipoEventoView, idCatalogoTipoEvento);
   }

   public CatalogoTipoEventoView getDetailsByIdCatalogoTipoEvento(Integer idCatalogoTipoEvento){
      logger.error("Error al accesar al servicio para OBTENER POR ID catalogoTipoEvento {}", idCatalogoTipoEvento);
      return null;
   }

   public List<CatalogoTipoEventoView> findAll(){
      logger.error("Error al accesar al servicio para OBTENER TODOS los catalogoTipoEvento");
      return null;
   }
}
