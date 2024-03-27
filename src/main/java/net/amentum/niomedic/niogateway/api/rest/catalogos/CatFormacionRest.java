package net.amentum.niomedic.niogateway.api.rest.catalogos;

import net.amentum.niomedic.catalogos.views.CatFormacionView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.catalogos.CatFormacionRestImpl;
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
@FeignClient(value = "http://nio-catalogos", fallback = CatFormacionRestImpl.class)
public interface CatFormacionRest {
	
	@PostMapping("catalogo-formacion")
	CatFormacionView createCatFormacion(@RequestBody @Validated CatFormacionView catFormacionView);
	
	@PutMapping("catalogo-formacion/{idCatFormacion}")
	CatFormacionView updateCatFormacion(@PathVariable("idCatFormacion")Integer idCatFormacion, @RequestBody @Validated CatFormacionView catFormacionView);
	
	@GetMapping("catalogo-formacion/{idCatFormacion}")
	CatFormacionView getDetailsByIdCatFormacion(@PathVariable("idCatFormacion") Integer idCatFormacion);

	@GetMapping("catalogo-formacion/findAll")
	List<CatFormacionView> findAll();

	@GetMapping("catalogo-formacion/search")
	Page<CatFormacionView> getCatFormacionSearch(@RequestParam(required = false, defaultValue = "", value = "datosBusqueda") String datosBusqueda,
			@RequestParam(required = false, value = "activo") Boolean activo,
			@RequestParam(required = false, defaultValue = "0", value = "page") Integer page,
			@RequestParam(required = false, defaultValue = "10", value = "size") Integer size,
			@RequestParam(required = false, defaultValue = "formDescripcion",value = "orderColumn") String orderColumn,
			@RequestParam(required = false, defaultValue = "asc" ,value = "orderType") String orderType);

}
