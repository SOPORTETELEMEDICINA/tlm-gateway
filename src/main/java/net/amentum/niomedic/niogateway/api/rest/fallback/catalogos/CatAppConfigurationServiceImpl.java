package net.amentum.niomedic.niogateway.api.rest.fallback.catalogos;

import net.amentum.niomedic.catalogos.views.CatAppConfigurationView;
import net.amentum.niomedic.catalogos.views.CatAreatrabajoView;
import net.amentum.niomedic.niogateway.api.rest.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CatAppConfigurationServiceImpl {
    private Logger logger = LoggerFactory.getLogger(CatAppConfigurationServiceImpl.class);

    public CatAppConfigurationView getUserByidCliente(Integer IdCliente) {
        logger.error("Error al accesar al servicio para OBTENER POR ID CatAppConfiguration {}", IdCliente);
        return null;
    }




}
