package net.amentum.niomedic.niogateway.api.rest.expediente;


import net.amentum.niomedic.expediente.views.SaludNivPesoView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.SaludNivPesoRestImpl;
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



@RestController
@FeignClient(value = "http://nio-expediente", fallback = SaludNivPesoRestImpl.class)
public interface SaludNivPesoRest {

    @PostMapping("SaludNivPeso")
    void createSaludNivPeso(@RequestBody @Validated SaludNivPesoView SaludNivPesoView);

    @PutMapping("SaludNivPeso/{pacidfk}")
    void updateSaludNivPeso(@PathVariable("pacidfk") String pacidfk, @RequestBody @Validated SaludNivPesoView SaludNivPesoView);

    @DeleteMapping("SaludNivPeso/{pacidfk}")
    void deleteSaludNivPeso(@PathVariable("pacidfk") String pacidfk);


    @GetMapping("SaludNivPeso/findAll")
    List<SaludNivPesoView> findAll();

    @GetMapping({"SaludNivPeso/search"})
    Page<SaludNivPesoView> getSaludNivPesoSearch(@RequestParam(required = true, value = "pacidfk") String pacidfk,
                                               @RequestParam(required = false, value = "page") Integer page,
                                               @RequestParam(required = false, value = "size") Integer size,
                                               @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                               @RequestParam(required = false, value = "orderType") String orderType);

    @GetMapping({"SaludNivPeso/busqueda"})
    Page<SaludNivPesoView> getSaludNivPesofechaSearch(@RequestParam(required = true, value = "pacidfk") String pacidfk,
                                                      @RequestParam(required = true, value = "periodo") int periodo,
                                                      @RequestParam(required = true, value = "fechaInicio") String fechaInicio,
                                                      @RequestParam(required = true, value = "fechaFin") String fechaFin,
                                                      @RequestParam(required = false, value = "page") Integer page,
                                                      @RequestParam(required = false, value = "size") Integer size,
                                                      @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                                      @RequestParam(required = false, value = "orderType") String orderType);
}

