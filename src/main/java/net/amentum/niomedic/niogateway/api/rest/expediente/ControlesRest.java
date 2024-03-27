package net.amentum.niomedic.niogateway.api.rest.expediente;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.amentum.niomedic.expediente.views.ControlesView;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.ControlesRestImpl;

@RestController
@FeignClient(value = "http://nio-expediente", fallback = ControlesRestImpl.class)
public interface ControlesRest {
	
	@PostMapping("controles")
	public ControlesView createControles(@RequestBody @Validated ControlesView controlesView);
	
	@PutMapping("controles/{idPaciente}")
	public ControlesView updateControles(@PathVariable("idPaciente") String idPaciente, @RequestBody @Validated ControlesView controlesView);

	@GetMapping("controles/{idPaciente}")
	public ControlesView getControles(@PathVariable("idPaciente") String idPaciente) ;

	@DeleteMapping("controles/{idPaciente}")
	public void deleteControles(@PathVariable("idPaciente") String idPaciente);
}
