package net.amentum.niomedic.niogateway.api.rest.catalogos;

import net.amentum.niomedic.catalogos.views.CatReligionView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.catalogos.CatReligionRestImpl;
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
@FeignClient(value = "http://nio-catalogos", fallback = CatReligionRestImpl.class)
public interface CatReligionRest {
	@PostMapping("catalogo-religion")
	CatReligionView createCatReligion(@RequestBody @Validated CatReligionView catReligionView);

	@PutMapping("catalogo-religion/{idCatReligion}")
	CatReligionView updateCatReligion(@PathVariable("idCatReligion") Integer idCatReligion, @RequestBody @Validated CatReligionView catReligionView);

	@GetMapping("catalogo-religion/{idCatReligion}")
	CatReligionView getDetailsByIdCatReligion(@PathVariable("idCatReligion") Integer idCatReligion);

	@GetMapping("catalogo-religion/findAll")
	List<CatReligionView> findAll();

	@GetMapping("catalogo-religion/search")
	Page<CatReligionView> getCatReligionSearch(@RequestParam(required = false, defaultValue = "", value = "datosBusqueda") String datosBusqueda,
			@RequestParam(required = false, value = "activo") Boolean activo,
			@RequestParam(required = false, defaultValue = "0", value = "page") Integer page,
			@RequestParam(required = false, defaultValue = "10", value = "size") Integer size,
			@RequestParam(required = false, defaultValue = "asc", value = "orderColumn") String orderColumn,
			@RequestParam(required = false, defaultValue = "relDescripcion", value = "orderType") String orderType);

}
