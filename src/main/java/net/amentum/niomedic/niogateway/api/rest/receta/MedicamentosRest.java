package net.amentum.niomedic.niogateway.api.rest.receta;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.amentum.niomedic.niogateway.api.rest.fallback.receta.RecetaRestImpl;

@RestController
@RequestMapping("medicamento")
@FeignClient(value = "http://nio-receta", fallback = RecetaRestImpl.class)
public interface MedicamentosRest {
	
	@GetMapping(value="/search", produces = "application/json")
	public String getMedicamentos(@RequestParam(required=true, value = "textoBusqueda") String textoBusqueda) ;

	@GetMapping(value="/sustancia/{substanceId}", produces = "application/json")
	public String getMedicamentoBySustanceId(@PathVariable("substanceId") Long substanceId);

	@GetMapping(value="/{ProductId}", produces = "application/json")
	public String getDetailsMedicamento(@PathVariable("ProductId") Long ProductId, @RequestParam(required=true, value = "categoryId") Long categoryId ,@RequestParam(required=true, value = "pharmaFormId") Long pharmaFormId,@RequestParam(required=true, value = "divisionId") Long divisionId );


}
