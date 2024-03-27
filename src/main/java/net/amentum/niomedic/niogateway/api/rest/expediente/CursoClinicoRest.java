package net.amentum.niomedic.niogateway.api.rest.expediente;


import net.amentum.niomedic.expediente.views.ConsultaView;
import net.amentum.niomedic.expediente.views.PadecimientoView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.CursoClinicoRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@RestController
@FeignClient(value = "http://nio-expediente", fallback = CursoClinicoRestImpl.class)
public interface CursoClinicoRest {

   @GetMapping("cursoclinico/search")
   Page<PadecimientoView> getCursoClinicoSearch(@RequestParam(required = true, value = "idPaciente") String idPaciente,
                                              @RequestParam(required = false, defaultValue = "", value = "datosBusqueda") String datosBusqueda,
                                              @RequestParam(required = false, value = "page") Integer page,
                                              @RequestParam(required = false, value = "size") Integer size,
                                              @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                              @RequestParam(required = false, value = "orderType") String orderType);
   
   @GetMapping(value = "cursoclinico/lista-consultas")
   Page<ConsultaView> listaConsulta(@RequestParam(required = true, value="idPadecimiento") Long idPadecimiento,
									@RequestParam(required = false, value="page") Integer page,
									@RequestParam(required = false, value="size") Integer size, 
									@RequestParam(required = false, value="orderColumn") String orderColumn,
									@RequestParam(required = false, value="orderType") String orderType,
									@RequestParam(required = false, defaultValue = "", value="datosBusqueda") String datosBusqueda);

	@PutMapping("cursoclinico/actualizar-estatus")
	void updateStatusPadecimiento(@RequestParam(value = "idPadecimiento") Long idPadecimiento);
}
