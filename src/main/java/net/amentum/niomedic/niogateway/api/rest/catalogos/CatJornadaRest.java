package net.amentum.niomedic.niogateway.api.rest.catalogos;


import net.amentum.niomedic.catalogos.views.CatJornadaView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.catalogos.CatJornadaRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@FeignClient(value = "http://nio-catalogos", fallback = CatJornadaRestImpl.class)
public interface CatJornadaRest {


    @GetMapping("catalogo-Jornada/{jorid}")
    CatJornadaView getDetailsByjorid(@PathVariable("jorid") Integer jorid);

    @GetMapping("catalogo-Jornada/findAll")
    List<CatJornadaView> findAll();

    @GetMapping("catalogo-Jornada/search")
    Page<CatJornadaView> getCatJornadaSearch(@RequestParam(required = false, defaultValue = "", value = "datosBusqueda") String datosBusqueda,
                                                 @RequestParam(required = false, value = "page") Integer page,
                                                 @RequestParam(required = false, value = "size") Integer size,
                                                 @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                                 @RequestParam(required = false, value = "orderType") String orderType);


}
