package net.amentum.niomedic.niogateway.api.rest.fallback.catalogos;

import net.amentum.niomedic.catalogos.views.CatLenguasIndigenasView;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.catalogos.CatLenguasIndigenasRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CatLenguasIndigenasRestImpl extends BaseController implements CatLenguasIndigenasRest {

	private Logger logger = LoggerFactory.getLogger(CatLenguasIndigenasRestImpl.class);


	@Override
	public CatLenguasIndigenasView createCatLenguasIndigena(CatLenguasIndigenasView catLenguasIndigenasView) {
		logger.error("Error al accesar al servicio para CREAR un CatLenguasIndigenas {} ",  catLenguasIndigenasView);
		return null;
	}

	@Override
	public CatLenguasIndigenasView updateCatLenguasIndigena(Integer idCatLenguasIndigenas,
			CatLenguasIndigenasView catLenguasIndigenasView) {
		logger.error("Error al accesar al servicio para ACTUALIZAR POR ID CatLenguasIndigenas {} - {}", idCatLenguasIndigenas, catLenguasIndigenasView);
		return null;
	}

	public CatLenguasIndigenasView getDetailsByIdCatLenguasIndigenas(Integer idCatLenguasIndigenas) {
		logger.error("Error al accesar al servicio para OBTENER POR ID CatLenguasIndigenas {}", idCatLenguasIndigenas);
		return null;
	}

	public List<CatLenguasIndigenasView> findAll() {
		logger.error("Error al accesar al servicio para OBTENER TODOS los CatLenguasIndigenas");
		return null;
	}

	public Page<CatLenguasIndigenasView> getCatLenguasIndigenasSearch(String datosBusqueda,
			Boolean activo,
			Integer page,
			Integer size,
			String orderColumn,
			String orderType) {
		logger.error("Error al OBTENER PÁGINA de CatLenguasIndigenas - datosBusqueda: {} - page: {} - size: {} - orderColumn: {} - orderType: {}",
				datosBusqueda, page, size, orderColumn, orderType);
		return null;
	}

}
