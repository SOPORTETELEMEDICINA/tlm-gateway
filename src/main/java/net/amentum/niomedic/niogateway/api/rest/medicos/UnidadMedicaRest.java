package net.amentum.niomedic.niogateway.api.rest.medicos;

import net.amentum.niomedic.medicos.views.EspecialidadUmView;
import net.amentum.niomedic.medicos.views.ServicioUmView;
import net.amentum.niomedic.medicos.views.UnidadMedicaPageView;
import net.amentum.niomedic.medicos.views.UnidadMedicaView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.medicos.UnidadMedicaRestImpl;
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

import javax.validation.Valid;

@RestController
@FeignClient(value = "http://nio-medicos", fallback = UnidadMedicaRestImpl.class)
public interface UnidadMedicaRest {

	@PostMapping("unidad-medica")
	UnidadMedicaView createUnindadMedica(@RequestBody @Validated UnidadMedicaView unidadMedicaView);
	
	@PutMapping("unidad-medica/{idUnidadMedica}")
	UnidadMedicaView updateUnindadMedica(@PathVariable("idUnidadMedica")Long idUnidadMedica, @RequestBody @Valid UnidadMedicaView unidadMedicaView);
	
	@GetMapping("unidad-medica/search")
	Page<UnidadMedicaPageView> searchUnidadesMedicas(@RequestParam(required = false, defaultValue = "", value = "datosBusqueda") String datosBusqueda,
			  @RequestParam(required = false, value = "activo") Boolean activo,
			  @RequestParam(required = false, defaultValue = "0", value = "page") Integer page,
			  @RequestParam(required = false, defaultValue = "10", value = "size") Integer size,
			  @RequestParam(required = false, defaultValue = "idUnidadMedica", value = "orderColumn") String orderColumn,
			  @RequestParam(required = false, defaultValue = "asc", value = "orderType") String orderType);

	@GetMapping("unidad-medica/searchByRegion")
	List<UnidadMedicaView> searchUnidadesMedicasByRegion(@RequestParam(value = "idRegionSanitaria") Integer idRegionSanitaria);

	@GetMapping("unidad-medica/searchByEntidad")
	List<UnidadMedicaView> searchUnidadesMedicasByEntidad(@RequestParam(value = "idEntidad") Integer idEntidad);
	
	@GetMapping("unidad-medica/{idUnidadMedica}")
	UnidadMedicaView getUnidadMedicaById(@PathVariable("idUnidadMedica") Long idUnidadMedica);

	@GetMapping("unidad-medica/{idUnidadMedica}/servicio")
	List<ServicioUmView> getServiciosByIdUnidadMedica(@PathVariable("idUnidadMedica") Long idUnidadMedica);

	@GetMapping("unidad-medica/{idUnidadMedica}/servicio/{idServicio}")
	ServicioUmView getServicioByIdUnidadMedicaByIdServicio(@PathVariable("idUnidadMedica") Long idUnidadMedica, @PathVariable("idServicio") Long idServicio);


	@GetMapping("unidad-medica/{idUnidadMedica}/especialidad")
	List<EspecialidadUmView> getEspecialidadesByIdUnidadMedica(@PathVariable("idUnidadMedica") Long idUnidadMedica);

	@GetMapping("unidad-medica/{idUnidadMedica}/especialidad/{idEspecialidad}")
	EspecialidadUmView getEspecialidadByIdUnidadMedicaByIdEspecialidad(@PathVariable("idUnidadMedica") Long idUnidadMedica, @PathVariable("idEspecialidad") Long idEspecialidad);

}
