package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.amentum.niomedic.expediente.views.EstudiosYResultadosView;
import net.amentum.niomedic.expediente.views.ResultadoEstudioView;
import net.amentum.niomedic.niogateway.api.rest.expediente.ResultadoEstudioRest;

public class ResultadoEstudioRestImpl implements ResultadoEstudioRest {

	private Logger log = LoggerFactory.getLogger(AsuetosRestImpl.class);

	@Override
	public ResultadoEstudioView createResultadoEstudio(ResultadoEstudioView resultadoEstudioView) {
		log.error("Error al accesar al servicio para AGREGAR resultado de estudios: {}", resultadoEstudioView);
		return null;
	}

	@Override
	public EstudiosYResultadosView getResultadoEstudioPorConsulta(Long idConsulta) {
		log.error("Error al accesar al servicio para OBTENER resultado de estudios por idConsulta: {}", idConsulta);
		return null;
	}

}
