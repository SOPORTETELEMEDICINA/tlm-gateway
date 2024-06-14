package net.amentum.niomedic.niogateway.api.rest.fallback.pacientes;

import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.api.rest.pacientes.RelacionTutoresRest;
import net.amentum.niomedic.pacientes.views.RelacionTutoresView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class RelacionTutoresRestImpl extends BaseController implements RelacionTutoresRest {

    private Logger logger = LoggerFactory.getLogger(RelacionTutoresRestImpl.class);

    @Override
    public void createRelacionTutores(RelacionTutoresView tutoresView) {
        logger.error("Error al accesar al servicio para agregar ua nueva relación de tutor");
    }

    @Override
    public List<RelacionTutoresView> findAll() {
        logger.error("Error al accesar al servicio para obtener relaciones de tutor");
        return null;
    }

    @Override
    public RelacionTutoresView getRelacionTutor(String idPaciente) {
        logger.error("Error al accesar al servicio para obtener relaciones de tutor por paciente");
        return null;
    }

    @Override
    public RelacionTutoresView getRelacionTutorByTutor(String idTutor) {
        logger.error("Error al accesar al servicio para obtener relaciones de paciente por tutor");
        return null;
    }
}
