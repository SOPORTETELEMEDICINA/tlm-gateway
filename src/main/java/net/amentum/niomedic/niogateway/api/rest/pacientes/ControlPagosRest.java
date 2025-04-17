package net.amentum.niomedic.niogateway.api.rest.pacientes;

import net.amentum.niomedic.niogateway.api.rest.fallback.pacientes.ControlPagosRestImpl;
import net.amentum.niomedic.pacientes.views.ControlPagosView;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@FeignClient(value = "http://nio-pacientes", fallback = ControlPagosRestImpl.class)
public interface ControlPagosRest {

    @PostMapping("control_pagos")
    void addFolioVenta(@RequestBody @Validated ControlPagosView view);

    @PutMapping("control_pagos/atender")
    void atenderFolioVenta(@RequestParam("folioVenta") String folioVenta,
                           @RequestParam("numeroSucursal") Long numeroSucursal);

    @PutMapping("control_pagos/cancelar")
    void cancelarFolioVenta(@RequestParam("folioVenta") String folioVenta,
                            @RequestParam("numeroSucursal") Long numeroSucursal);

    @PutMapping("control_pagos/finalizar")
    void finalizarFolioVenta(@RequestParam("folioVenta") String folioVenta,
                             @RequestParam("numeroSucursal") Long numeroSucursal);

    @GetMapping("control_pagos")
    ControlPagosView getFolioVenta(@RequestParam("folioVenta") String folioVenta,
                                   @RequestParam("numeroSucursal") Long numeroSucursal);
}
