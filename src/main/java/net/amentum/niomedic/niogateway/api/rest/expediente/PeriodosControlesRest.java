package net.amentum.niomedic.niogateway.api.rest.expediente;

import java.util.Set;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.amentum.niomedic.expediente.views.PeriodosControlesView;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.PeriodosControlesRestImpl;


@RestController
@FeignClient(value = "http://nio-expediente", fallback = PeriodosControlesRestImpl.class)
public interface PeriodosControlesRest {
	
	@PostMapping("controles/{idControl}/periodos")
	public Set<PeriodosControlesView> createPeriodosControles(@PathVariable("idControl")Long idControl,@RequestBody @Validated Set<PeriodosControlesView>periodosControlesView) ;

	@PutMapping("controles/{idControl}/periodos")
	public Set<PeriodosControlesView> updatePeriodosControles(@PathVariable("idControl")Long idControl,@RequestBody @Validated Set<PeriodosControlesView>periodosControlesView) ;

	@GetMapping("controles/{idControl}/periodos")
	public Set<PeriodosControlesView> getPeriodosControles(@PathVariable("idControl")Long idControl);

	@DeleteMapping("controles/{idControl}/periodos")
	public void deletePeriodosControles(@PathVariable("idControl")Long idControl);
	
	@GetMapping("controles/periodos/{idPaciente}")
	public Set<PeriodosControlesView> getPeriodosPorPaciente(@PathVariable("idPaciente")String idPaciente) ;
}
