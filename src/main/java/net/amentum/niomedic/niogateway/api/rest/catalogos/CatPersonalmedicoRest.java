package net.amentum.niomedic.niogateway.api.rest.catalogos;


import net.amentum.niomedic.catalogos.views.CatPersonalmedicoView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.catalogos.CatPersonalmedicoRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@FeignClient(value = "http://nio-catalogos", fallback = CatPersonalmedicoRestImpl.class)
public interface CatPersonalmedicoRest {

    @GetMapping("catalogo-Personalmedico/{perid}")
    CatPersonalmedicoView getDetailsByperid(@PathVariable("perid") Integer perid);

    @GetMapping("catalogo-Personalmedico/findAll")
    List<CatPersonalmedicoView> findAll();

    @GetMapping("catalogo-Personalmedico/search")
    Page<CatPersonalmedicoView> getCatPersonalmedicoSearch(@RequestParam(required = false, defaultValue = "", value = "datosBusqueda") String datosBusqueda,
                                                 @RequestParam(required = false, value = "page") Integer page,
                                                 @RequestParam(required = false, value = "size") Integer size,
                                                 @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                                 @RequestParam(required = false, value = "orderType") String orderType);

}
