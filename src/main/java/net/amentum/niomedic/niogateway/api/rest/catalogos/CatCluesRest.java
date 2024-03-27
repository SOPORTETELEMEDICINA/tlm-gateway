package net.amentum.niomedic.niogateway.api.rest.catalogos;

import net.amentum.niomedic.catalogos.views.CatCluesView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import net.amentum.niomedic.niogateway.api.rest.fallback.catalogos.CatCluesRestImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@FeignClient(value = "http://nio-catalogos", fallback = CatCluesRestImpl.class)

public interface CatCluesRest {


    @GetMapping("catalogo-Clues/{idCatClues}")
    CatCluesView getDetailsByidCatClues(@PathVariable("idCatClues") Integer idCatClues);

    @GetMapping("catalogo-Clues/findAll")
    List<CatCluesView> findAll();

    @GetMapping("catalogo-Clues/search")
    Page<CatCluesView> getCatCluesSearch(@RequestParam(required = false, defaultValue = "", value = "datosBusqueda") String datosBusqueda,
                                                 @RequestParam(required = false, value = "page") Integer page,
                                                 @RequestParam(required = false, value = "size") Integer size,
                                                 @RequestParam(required = false, value = "orderColumn") String orderColumn,
                                                 @RequestParam(required = false, value = "orderType") String orderType);
}
