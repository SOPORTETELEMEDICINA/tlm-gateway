package net.amentum.niomedic.niogateway.api.rest.catalogos;


import net.amentum.niomedic.catalogos.views.CatTipocontratoView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.catalogos.CatTipocontratoRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@FeignClient(value = "http://nio-catalogos", fallback = CatTipocontratoRestImpl.class)
public interface CatTipocontratoRest {

    @GetMapping("catalogo-Tipocontrato/{conid}")
    CatTipocontratoView getDetailsByconid(@PathVariable("conid") Integer conid);

    @GetMapping("catalogo-Tipocontrato/findAll")
    List<CatTipocontratoView> findAll();

    @GetMapping("catalogo-Tipocontrato/search")
    Page<CatTipocontratoView> getCatTipocontratoSearch(@RequestParam(required = false, defaultValue = "", value = "datosBusqueda") String datosBusqueda,
                                                 @RequestParam(required = false, value = "page") Integer page,
                                                 @RequestParam(required = false, value = "size") Integer size,
                                                 @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                                 @RequestParam(required = false, value = "orderType") String orderType);


}
