package net.amentum.niomedic.niogateway.api.rest.fallback.catalogos;

import net.amentum.niomedic.catalogos.views.CatReligionView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.catalogos.CatReligionRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CatReligionRestImpl extends BaseController implements CatReligionRest {

	private Logger logger = LoggerFactory.getLogger(CatReligionRestImpl.class);

	public CatReligionView getDetailsByIdCatReligion(Integer idCatReligion) {
		logger.error("Error al accesar al servicio para OBTENER POR ID CatReligion {}", idCatReligion);
		return null;
	}

	public List<CatReligionView> findAll() {
		logger.error("Error al accesar al servicio para OBTENER TODOS los CatReligion");
		return null;
	}

	public Page<CatReligionView> getCatReligionSearch(String datosBusqueda,
													  Boolean activo,
													  Integer page,
													  Integer size,
													  String orderColumn,
													  String orderType) {
		logger.error("Error al OBTENER PÁGINA de CatReligion - datosBusqueda: {} - page: {} - size: {} - orderColumn: {} - orderType: {}",
				datosBusqueda, page, size, orderColumn, orderType);
		return null;
	}

	@Override
	public CatReligionView createCatReligion(CatReligionView catReligionView) {
		logger.error("Error al CREAR una nueva Religion:{}",catReligionView);
		return null;
	}

	@Override
	public CatReligionView updateCatReligion(Integer idCatReligion, CatReligionView catReligionView) {
		logger.error("Error al ACTUALIZAR la Religion con el ID:{} - {}",idCatReligion ,catReligionView);
		return null;
	}
}
