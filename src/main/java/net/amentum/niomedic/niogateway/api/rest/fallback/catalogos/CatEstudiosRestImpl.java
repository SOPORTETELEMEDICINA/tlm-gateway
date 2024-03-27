package net.amentum.niomedic.niogateway.api.rest.fallback.catalogos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.catalogos.views.CatEstudiosView;
import net.amentum.niomedic.niogateway.api.rest.catalogos.CatEstudiosRest;

public class CatEstudiosRestImpl implements CatEstudiosRest {
	private Logger logger = LoggerFactory.getLogger(CatEstudiosRestImpl.class);
	
	@Override
	public CatEstudiosView createCatEstudio(CatEstudiosView catEstudiosView) {
		logger.error("Error al accesar al servicio para CREAR {}", catEstudiosView);
		return null;
	}

	@Override
	public CatEstudiosView updateCatEstudio(Integer idCatEstudio, CatEstudiosView catEstudiosView) {
		logger.error("Error al accesar al servicio para ACTUALIZAR POR ID CatEstudio {} - {}", idCatEstudio, catEstudiosView);
		return null;
	}

	@Override
	public CatEstudiosView getCatEstudio(Integer idCatEstudio) {
		logger.error("Error al accesar al servicio para OBTENER POR ID CatEstudio {}", idCatEstudio);
		return null;
	}

	@Override
	public Page<CatEstudiosView> searchCatEstudios(String datosBusqueda, 
												   Boolean activo, 
												   Integer page, 
												   Integer size,
												   String orderColumn,
												   String orderType) {
		   logger.error("Error al OBTENER PÁGINA de CatEstudio - datosBusqueda: {} - activo: {} - page: {} - size: {} - orderColumn: {} - orderType: {}",
			         datosBusqueda, activo, page, size, orderColumn, orderType);
		return null;
	}

}
