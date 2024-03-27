package net.amentum.niomedic.niogateway.api.rest.expediente;

import net.amentum.niomedic.expediente.views.SaludIndNutriView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.expediente.SaludIndNutriRestImpl;
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
@FeignClient(value = "http://nio-expediente", fallback = SaludIndNutriRestImpl.class)
public interface SaludIndNutriRest {

    @PostMapping("SaludIndNutri")
    void createSaludIndNutri(@RequestBody @Validated SaludIndNutriView SaludIndNutriView);

    @PutMapping("SaludIndNutri/{pacidfk}")
    void updateSaludIndNutri(@PathVariable("pacidfk") String pacidfk, @RequestBody @Validated SaludIndNutriView SaludIndNutriView);

    @DeleteMapping("SaludIndNutri/{pacidfk}")
    void deleteSaludIndNutri(@PathVariable("pacidfk") String pacidfk);

    @GetMapping("SaludIndNutri/{pacidfk}")
    SaludIndNutriView getDetailsByPacidfk(@PathVariable("pacidfk") String pacidfk);

    @GetMapping("SaludIndNutri/findAll")
    List<SaludIndNutriView> findAll();

    @GetMapping("SaludIndNutri/page")
    Page<SaludIndNutriView> getSaludIndNutriPage(@RequestParam(required = false, value = "active") Boolean active,
                                               @RequestParam(required = false, defaultValue = "", value = "name") String name,
                                               @RequestParam(required = false, value = "page") Integer page,
                                               @RequestParam(required = false, value = "size") Integer size,
                                               @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                               @RequestParam(required = false, value = "orderType") String orderType);



}
