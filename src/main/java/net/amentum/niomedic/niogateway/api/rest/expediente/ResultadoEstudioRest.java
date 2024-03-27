package net.amentum.niomedic.niogateway.api.rest.expediente;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.amentum.niomedic.expediente.views.EstudiosYResultadosView;
import net.amentum.niomedic.expediente.views.ResultadoEstudioView;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.ResultadoEstudioRestImpl;


@RestController
@FeignClient(value = "http://nio-expediente", fallback = ResultadoEstudioRestImpl.class )
public interface ResultadoEstudioRest {

	@PostMapping("resultado-estudio")
	ResultadoEstudioView createResultadoEstudio(@RequestBody @Validated ResultadoEstudioView resultadoEstudioView);

	@GetMapping("resultado-estudio/por-consulta/{idConsulta}")
	EstudiosYResultadosView getResultadoEstudioPorConsulta(@PathVariable("idConsulta") Long idConsulta);

}
