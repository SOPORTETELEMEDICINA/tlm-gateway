package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;

//import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.expediente.views.ConsultaView;
import net.amentum.niomedic.expediente.views.PadecimientoView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.expediente.CursoClinicoRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CursoClinicoRestImpl extends BaseController implements CursoClinicoRest {

   private Logger logger = LoggerFactory.getLogger(ConsultaRestImpl.class);

   public Page<PadecimientoView> getCursoClinicoSearch(String idPaciente,
                                                     String datosBusqueda,
                                                     Integer page,
                                                     Integer size,
                                                     String orderColumn,
                                                     String orderType) {
      logger.error("Error al OBTENER PÁGINA de cursoclinico - idPaciente: {} - datosBusqueda: {} - page: - {} size: {} - orderColumn: {} - orderType: {}",
         idPaciente, datosBusqueda, page, size, orderColumn, orderType);
      return null;
   }


   public Page<ConsultaView> listaConsulta(Long idPadecimiento,
		   								   Integer page,
		   								   Integer size,
		   								   String orderColumn,
		   								   String orderType,
		   								   String datosBusqueda) {
	logger.error("Error al OBTENER PÁGINA de cursoclinico por consultas- idPadecimiento {} - page: - {} size: {} - orderColumn: {} - orderType: {} - datosBusqueda: {}",
	         idPadecimiento, page, size, orderColumn, orderType, datosBusqueda);
	return null;
   }

	@Override
	public void updateStatusPadecimiento(Long idPadecimiento) {
		logger.error("Error al ACTUALIZAR Padecimiento en consulta");
	}
}
