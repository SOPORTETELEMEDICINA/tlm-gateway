package net.amentum.niomedic.niogateway.api.rest.fallback.catalogos;

import net.amentum.niomedic.catalogos.views.CatFormacionView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.catalogos.CatFormacionRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CatFormacionRestImpl extends BaseController implements CatFormacionRest {

	private Logger logger = LoggerFactory.getLogger(CatFormacionRestImpl.class);

	public CatFormacionView getDetailsByIdCatFormacion(Integer idCatFormacion) {
		logger.error("Error al accesar al servicio para OBTENER POR ID CatFormacion {}", idCatFormacion);
		return null;
	}

	public List<CatFormacionView> findAll() {
		logger.error("Error al accesar al servicio para OBTENER TODOS los CatFormacion");
		return null;
	}

	public Page<CatFormacionView> getCatFormacionSearch(String datosBusqueda,
													    Boolean activo,
													    Integer page,
													    Integer size,
													    String orderColumn,
													    String orderType) {
		logger.error("Error al OBTENER PÁGINA de CatFormacion - datosBusqueda: {} - page: {} - size: {} - orderColumn: {} - orderType: {}",
				datosBusqueda, page, size, orderColumn, orderType);
		return null;
	}

	@Override
	public CatFormacionView createCatFormacion(CatFormacionView catFormacionView) {
		logger.error("Error al c al servicio para CREAR un CatFormacion");
		return null;
	}

	@Override
	public CatFormacionView updateCatFormacion(Integer idCatFormacion, CatFormacionView catFormacionView) {
		logger.error("Error al accesar al servicio para ACTUALIZAR un CatFormacion");
		return null;
	}


}
