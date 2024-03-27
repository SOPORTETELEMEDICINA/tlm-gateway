package net.amentum.niomedic.niogateway.api.rest.fallback.expediente;

import net.amentum.niomedic.expediente.views.CuestionarioRespuestaView;
import net.amentum.niomedic.niogateway.api.rest.expediente.CuestionarioRespuestaRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CuestionarioRespuestaImpl implements CuestionarioRespuestaRest {

    Logger logger = LoggerFactory.getLogger(CuestionarioRespuestaImpl.class);

    @Override
    public void createCuestionarioRespuesta(CuestionarioRespuestaView view) {
        logger.info("Error al acceder al servicio para AGREGAR una respuesta");
    }

    @Override
    public List<CuestionarioRespuestaView> getRespuestaSearch(String idPaciente, Integer idCuestionario) {
        logger.info("Error al acceder al servicio para OBTENER respuestas");
        return null;
    }
}
