package net.amentum.niomedic.niogateway.api.rest.catalogos;

import net.amentum.niomedic.catalogos.views.CatActividadprinView;
import net.amentum.niomedic.catalogos.views.CatAppConfigurationView;
import net.amentum.niomedic.niogateway.api.rest.fallback.catalogos.CatAppConfigurationServiceImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@FeignClient(value = "http://nio-catalogos", fallback = CatAppConfigurationServiceImpl.class)
public interface CatAppConfigurationRest {

    @GetMapping("AppConfiguration/IdAppConfiguration/{idCliente}")
    CatAppConfigurationView getUserByidCliente(@PathVariable("idCliente") Integer idCliente);
}
