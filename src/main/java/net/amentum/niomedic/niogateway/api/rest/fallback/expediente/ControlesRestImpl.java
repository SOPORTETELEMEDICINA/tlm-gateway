package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;

import lombok.extern.slf4j.Slf4j;
import net.amentum.niomedic.expediente.views.ControlesView;
import net.amentum.niomedic.niogateway.api.rest.expediente.ControlesRest;

@Slf4j
public class ControlesRestImpl implements ControlesRest {

	@Override
	public ControlesView createControles(ControlesView controlesView) {
		log.error("Ocurrio un error al Crear el control:{}", controlesView);
		return null;
	}

	@Override
	public ControlesView updateControles(String idPaciente, ControlesView controlesView) {
		log.error("Ocurrio un error al Actualizar el control:{}", controlesView);
		return null;
	}

	@Override
	public ControlesView getControles(String idPaciente) {
		log.error("Ocurrio un error al Obtener el control por idPaciente:{}", idPaciente);
		return null;
	}

	@Override
	public void deleteControles(String idPaciente) {
		log.error("Ocurrio un error al Eliminar el control por idPaciente:{}", idPaciente);
		
	}

}
