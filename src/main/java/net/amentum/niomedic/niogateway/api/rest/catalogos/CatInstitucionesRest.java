package net.amentum.niomedic.niogateway.api.rest.catalogos;


import net.amentum.niomedic.catalogos.views.CatInstitucionesView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.catalogos.CatInstitucionesRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@FeignClient(value = "http://nio-catalogos", fallback = CatInstitucionesRestImpl.class)
public interface CatInstitucionesRest {

    @GetMapping("catalogo-Instituciones/{idinstitucion}")
    CatInstitucionesView getDetailsByidinstitucion(@PathVariable("idinstitucion") Integer idinstitucion);

    @GetMapping("catalogo-Instituciones/findAll")
    List<CatInstitucionesView> findAll();

    @GetMapping("catalogo-Instituciones/search")
    Page<CatInstitucionesView> getCatInstitucionesSearch(@RequestParam(required = false, defaultValue = "", value = "datosBusqueda") String datosBusqueda,
                                                 @RequestParam(required = false, value = "page") Integer page,
                                                 @RequestParam(required = false, value = "size") Integer size,
                                                 @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                                 @RequestParam(required = false, value = "orderType") String orderType);


}
