package net.amentum.niomedic.niogateway.api.rest.catalogos;

import net.amentum.niomedic.catalogos.views.CatLenguasIndigenasView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.catalogos.CatLenguasIndigenasRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
@FeignClient(value = "http://nio-catalogos", fallback = CatLenguasIndigenasRestImpl.class)
public interface CatLenguasIndigenasRest {

	@PostMapping("catalogo-lenguas-indigenas")
	CatLenguasIndigenasView createCatLenguasIndigena(@RequestBody() @Validated CatLenguasIndigenasView catLenguasIndigenasView );

	@PutMapping("catalogo-lenguas-indigenas/{idCatLenguasIndigenas}")
	CatLenguasIndigenasView updateCatLenguasIndigena(@PathVariable("idCatLenguasIndigenas") Integer idCatLenguasIndigenas, @RequestBody() @Validated CatLenguasIndigenasView catLenguasIndigenasView );

	@GetMapping("catalogo-lenguas-indigenas/{idCatLenguasIndigenas}")
	CatLenguasIndigenasView getDetailsByIdCatLenguasIndigenas(@PathVariable("idCatLenguasIndigenas") Integer idCatLenguasIndigenas);

	@GetMapping("catalogo-lenguas-indigenas/findAll")
	List<CatLenguasIndigenasView> findAll();

	@GetMapping("catalogo-lenguas-indigenas/search")
	Page<CatLenguasIndigenasView> getCatLenguasIndigenasSearch(@RequestParam(required = false, defaultValue = "", value="datosBusqueda") String datosBusqueda,
															   @RequestParam(required = false, value = "activo") Boolean activo,
															   @RequestParam(required = false, defaultValue="0", value = "page") Integer page,
															   @RequestParam(required = false, defaultValue="10", value = "size") Integer size,
															   @RequestParam(required = false, defaultValue="lengDescripcion", value = "orderColumn") String orderColumn,
															   @RequestParam(required = false, defaultValue="asc", value = "orderType") String orderType);

}
