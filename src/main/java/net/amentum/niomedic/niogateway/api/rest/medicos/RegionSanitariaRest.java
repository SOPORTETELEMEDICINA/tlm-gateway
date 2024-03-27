package net.amentum.niomedic.niogateway.api.rest.medicos;

import net.amentum.niomedic.medicos.views.RegionSanitariaView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.medicos.RegionSanitariaRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@FeignClient(value = "http://nio-medicos", fallback = RegionSanitariaRestImpl.class)
public interface RegionSanitariaRest {

    @PostMapping("regionSanitaria")
    RegionSanitariaView createRegionSanitaria(@RequestBody @Validated RegionSanitariaView regionSanitariaView);

    @PutMapping("regionSanitaria/{idRegionSanitaria}")
    RegionSanitariaView updateRegionSanitaria(@PathVariable("idRegionSanitaria") Integer idRegionSanitaria, @RequestBody @Validated RegionSanitariaView view);

    @GetMapping("regionSanitaria/{idRegionSanitaria}")
    RegionSanitariaView getRegionSanitariaById(@PathVariable("idRegionSanitaria") Integer idRegionSanitaria);

    @GetMapping("regionSanitaria/page")
    Page<RegionSanitariaView> getMRegionSanitariaPage(@RequestParam(required = false, value = "idMedico") String idMedico,
                                        @RequestParam(required = false, value = "page") Integer page,
                                       @RequestParam(required = false, value = "size") Integer size,
                                       @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                       @RequestParam(required = false, value = "orderType") String orderType);

    @GetMapping("regionSanitaria/searchByEstado")
    List<RegionSanitariaView> getRegionSanitariaByEstado(@RequestParam(value = "idEstado") Integer idEstado);

}
