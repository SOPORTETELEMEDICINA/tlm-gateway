package net.amentum.niomedic.niogateway.api.rest.expediente;


import net.amentum.niomedic.expediente.views.SaludIndGlucView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.SaludIndGlucRestImpl;
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

import java.util.List;

//import org.springframework.data.domain.Page;

@RestController
@FeignClient(value = "http://nio-expediente", fallback = SaludIndGlucRestImpl.class)
public interface SaludIndGlucRest {

    @PostMapping("SaludIndGluc")
    void createSaludIndGluc(@RequestBody @Validated SaludIndGlucView SaludIndGlucView);

    @PutMapping("SaludIndGluc/{pacidfk}")
    void updateSaludIndGluc(@PathVariable("pacidfk") String pacidfk, @RequestBody @Validated SaludIndGlucView SaludIndGlucView);

    @DeleteMapping("SaludIndGluc/{pacidfk}")
    void deleteSaludIndGluc(@PathVariable("pacidfk") String pacidfk);

    @GetMapping("SaludIndGluc/{pacidfk}")
    SaludIndGlucView getDetailsByPacidfk(@PathVariable("pacidfk") String pacidfk);

    @GetMapping("SaludIndGluc/findAll")
    List<SaludIndGlucView> findAll();

    @GetMapping("SaludIndGluc/page")
    Page<SaludIndGlucView> getSaludIndGlucPage(@RequestParam(required = false, value = "active") Boolean active,
                                                 @RequestParam(required = false, defaultValue = "", value = "name") String name,
                                                 @RequestParam(required = false, value = "page") Integer page,
                                                 @RequestParam(required = false, value = "size") Integer size,
                                                 @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                                 @RequestParam(required = false, value = "orderType") String orderType);



}
