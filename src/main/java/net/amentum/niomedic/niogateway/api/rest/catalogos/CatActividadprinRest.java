package net.amentum.niomedic.niogateway.api.rest.catalogos;


import net.amentum.niomedic.catalogos.views.CatActividadprinView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.catalogos.CatActividadprinRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@FeignClient(value = "http://nio-catalogos", fallback = CatActividadprinRestImpl.class)

public interface CatActividadprinRest {



    @GetMapping("catalogo-Actividadprincipal/{actid}")
    CatActividadprinView getDetailsByactid(@PathVariable("actid") Integer actid);

    @GetMapping("catalogo-Actividadprincipal/findAll")
    List<CatActividadprinView> findAll();

    @GetMapping("catalogo-Actividadprincipal/search")
    Page<CatActividadprinView> getCatActividadprinSearch(@RequestParam(required = false, defaultValue = "", value = "datosBusqueda") String datosBusqueda,
                                                 @RequestParam(required = false, value = "page") Integer page,
                                                 @RequestParam(required = false, value = "size") Integer size,
                                                 @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                                 @RequestParam(required = false, value = "orderType") String orderType);
}
