package net.amentum.niomedic.niogateway.api.rest.catalogos;

import org.springframework.cloud.netflix.feign.FeignClient;
import net.amentum.niomedic.niogateway.api.rest.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.amentum.niomedic.catalogos.views.CatEstudiosView;
import net.amentum.niomedic.niogateway.api.rest.fallback.catalogos.CatEstudiosRestImpl;

@RestController
@FeignClient(value = "http://nio-catalogos", fallback = CatEstudiosRestImpl.class)
public interface CatEstudiosRest {
	
	@PostMapping("catalogo-estudios")
	public CatEstudiosView createCatEstudio(@RequestBody @Validated CatEstudiosView catEstudiosView);

	@PutMapping("catalogo-estudios/{idCatEstudio}")
	public CatEstudiosView updateCatEstudio(@PathVariable("idCatEstudio")Integer idCatEstudio, @RequestBody @Validated CatEstudiosView catEstudiosView);

	@GetMapping("catalogo-estudios/{idCatEstudio}")
	public CatEstudiosView getCatEstudio(@PathVariable("idCatEstudio")Integer idCatEstudio);
	
	@GetMapping("catalogo-estudios/search")
	public Page<CatEstudiosView> searchCatEstudios(@RequestParam(required = false, defaultValue = "", value = "datosBusqueda") String datosBusqueda,
												   @RequestParam(required = false, value = "activo") Boolean activo,
												   @RequestParam(required = false, defaultValue = "0", value = "page") Integer page,
												   @RequestParam(required = false, defaultValue = "10", value = "size") Integer size,
												   @RequestParam(required = false, defaultValue = "descripcion", value = "orderColumn") String orderColumn,
												   @RequestParam(required = false, defaultValue = "asc", value = "orderType") String orderType) ;
}
