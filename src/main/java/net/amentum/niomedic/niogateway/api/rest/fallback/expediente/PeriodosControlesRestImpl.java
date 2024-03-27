package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;

import java.util.Set;

import lombok.extern.slf4j.Slf4j;
import net.amentum.niomedic.expediente.views.PeriodosControlesView;
import net.amentum.niomedic.niogateway.api.rest.expediente.PeriodosControlesRest;
@Slf4j
public class PeriodosControlesRestImpl implements PeriodosControlesRest{

	@Override
	public Set<PeriodosControlesView> createPeriodosControles(Long idControl,
			Set<PeriodosControlesView> periodosControlesView) {
		log.error("Ocurrio un error al Crear un periodo:{} para el idControl", periodosControlesView, idControl);
		return null;
	}

	@Override
	public Set<PeriodosControlesView> updatePeriodosControles(Long idControl,
			Set<PeriodosControlesView> periodosControlesView) {
		log.error("Ocurrio un error al Actualizar un periodo:{} para el idControl", periodosControlesView, idControl);
		return null;
	}

	@Override
	public Set<PeriodosControlesView> getPeriodosControles(Long idControl) {
		log.error("Ocurrio un error al Obtener los periodos para el idControl", idControl);
		return null;
	}

	@Override
	public void deletePeriodosControles(Long idControl) {
		log.error("Ocurrio un error al Eliminar un periodo:{} para el idControl", idControl);
		
	}

	@Override
	public Set<PeriodosControlesView> getPeriodosPorPaciente(String idPaciente) {
		log.error("Ocurrio un error al Obtener los periodos por el idPaciente", idPaciente);
		return null;
	}

}
