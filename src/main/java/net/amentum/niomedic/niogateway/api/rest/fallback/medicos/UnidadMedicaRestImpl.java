package net.amentum.niomedic.niogateway.api.rest.fallback.medicos;

import lombok.extern.slf4j.Slf4j;
import net.amentum.common.v2.RestBaseController;
import net.amentum.niomedic.medicos.views.EspecialidadUmView;
import net.amentum.niomedic.medicos.views.ServicioUmView;
import net.amentum.niomedic.medicos.views.UnidadMedicaPageView;
import net.amentum.niomedic.medicos.views.UnidadMedicaView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.medicos.UnidadMedicaRest;

import java.util.List;

@Slf4j
public class UnidadMedicaRestImpl extends RestBaseController implements UnidadMedicaRest {

	@Override
	public UnidadMedicaView getUnidadMedicaById(Long idUnidadMedica){
		log.error("Error al Obtener los detalles de una Unidad Médica para el idUnidadMedica: {}", idUnidadMedica);
		return null;
	}

	@Override
	public List<ServicioUmView> getServiciosByIdUnidadMedica(Long idUnidadMedica){
		log.error("Error al Obtener los Servicios de una Unidad Médica para el idUnidadMedica: {}", idUnidadMedica);
		return null;
	}

	@Override
	public ServicioUmView getServicioByIdUnidadMedicaByIdServicio(Long idUnidadMedica, Long idServicio){
		log.error("Error al Obtener el Servicio: {} de una Unidad Médica: {}",idServicio, idUnidadMedica);
		return null;
	}

	@Override
	public List<EspecialidadUmView> getEspecialidadesByIdUnidadMedica(Long idUnidadMedica){
		log.error("Error al Obtener las Especialidades de una Unidad Médica para el idUnidadMedica: {}", idUnidadMedica);
		return null;
	}

	@Override
	public EspecialidadUmView getEspecialidadByIdUnidadMedicaByIdEspecialidad(Long idUnidadMedica, Long idEspecialidad){
		log.error("Error al Obtener la Especialidad: {} de una Unidad Médica: {}",idEspecialidad, idUnidadMedica);
		return null;
	}

	@Override
	public UnidadMedicaView createUnindadMedica(UnidadMedicaView unidadMedicaView) {
		log.error("Error al Crear la una Unidad Médica: {} - {}",unidadMedicaView);
		return null;
	}

	@Override
	public UnidadMedicaView updateUnindadMedica(Long idUnidadMedica, UnidadMedicaView unidadMedicaView) {
		log.error("Error al Actualizar la una Unidad Médica: {} - {}",idUnidadMedica, unidadMedicaView);
		return null;
	}

	@Override
	public Page<UnidadMedicaPageView> searchUnidadesMedicas(String datosBusqueda, 
						                                    Boolean activo,
						                                    Integer page,
						                                    Integer size,
						                                    String orderColumn,
						                                    String orderType) {
		log.error("Error al Filtrar las una Unidades Médicas");
		return null;
	}

	@Override
	public List<UnidadMedicaView> searchUnidadesMedicasByRegion(Integer idRegionSanitaria) {
		log.error("Error al obtener las Unidades Médicas");
		return null;
	}

	@Override
	public List<UnidadMedicaView> searchUnidadesMedicasByEntidad(Integer idEntidad) {
		log.error("Error al Obtener los Servicios de una Unidad Médica para el idEntidad: {}", idEntidad);
		return null;
	}

}
