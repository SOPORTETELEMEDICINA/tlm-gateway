package net.amentum.niomedic.niogateway.api.rest.expediente;

import net.amentum.niomedic.expediente.views.SaludNivCovidView;
import net.amentum.niomedic.expediente.views.SaludNivCovidView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.SaludNivCovidRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

//import org.springframework.data.domain.Page;

@RestController
@FeignClient(value = "http://nio-expediente", fallback = SaludNivCovidRestImpl.class)
public interface SaludNivCovidRest {


    @PostMapping("SaludNivCovid")
    void createSaludNivCovid(@RequestBody @Validated SaludNivCovidView SaludNivCovidView);

    @PutMapping("SaludNivCovid/{pacidfk}")
    void updateSaludNivCovid(@PathVariable("pacidfk") String pacidfk, @RequestBody @Validated SaludNivCovidView SaludNivCovidView);

    @DeleteMapping("SaludNivCovid/{pacidfk}")
    void deleteSaludNivCovid(@PathVariable("pacidfk") String pacidfk);

    @GetMapping("SaludNivCovid/findAll")
    List<SaludNivCovidView> findAll();

    @GetMapping({"SaludNivCovid/search"})
    Page<SaludNivCovidView> getSaludNivCovidSearch(@RequestParam(required = true, value = "pacidfk") String pacidfk,
                                                 @RequestParam(required = false, value = "page") Integer page,
                                                 @RequestParam(required = false, value = "size") Integer size,
                                                 @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                                 @RequestParam(required = false, value = "orderType") String orderType);

    @GetMapping({"SaludNivCovid/busqueda"})
    Page<SaludNivCovidView> getSaludNivCovidfechaSearch(@RequestParam(required = true, value = "pacidfk") String pacidfk,
                                                      @RequestParam(required = true, value = "periodo") int periodo,
                                                      @RequestParam(required = true, value = "fechaInicio") String fechaInicio,
                                                      @RequestParam(required = true, value = "fechaFin") String fechaFin,
                                                      @RequestParam(required = false, value = "page") Integer page,
                                                      @RequestParam(required = false, value = "size") Integer size,
                                                      @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                                      @RequestParam(required = false, value = "orderType") String orderType);


    @GetMapping({"SaludNivCovid/periodo"})
    Page<SaludNivCovidView> getSaludNivCovidperiodoSearch(@RequestParam(required = true, value = "pacidfk") String pacidfk,
                                                        @RequestParam(required = true, value = "periodo") int periodo,
                                                        @RequestParam(required = true, value = "PeriodoF") int PeriodoF,
                                                        @RequestParam(required = false, value = "page") Integer page,
                                                        @RequestParam(required = false, value = "size") Integer size,
                                                        @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                                        @RequestParam(required = false, value = "orderType") String orderType);


}


