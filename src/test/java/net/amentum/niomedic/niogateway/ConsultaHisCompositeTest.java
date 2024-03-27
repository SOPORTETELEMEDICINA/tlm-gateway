package net.amentum.niomedic.niogateway;

import java.io.IOException;
import java.util.Date;

import org.junit.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;

import net.amentum.niomedic.niogateway.views.ConsultaHis;
import net.amentum.niomedic.niogateway.views.ConsultaPacienteHis;
import net.amentum.niomedic.niogateway.views.PacienteHis;

public class ConsultaHisCompositeTest extends NioGatewayApplicationTests {
	@Test
	public void crearConsulta() throws Exception {
		ConsultaPacienteHis consulta = new ConsultaPacienteHis();
		ConsultaHis consultaHis = new ConsultaHis();
		PacienteHis pacienteHis = new PacienteHis();
		consultaHis.setSintonmas("Dolor de cabeza");
		consultaHis.setEspecialidad("MEDICINA GENERAL");
		consultaHis.setFechaFin(new Date());
		consultaHis.setFechaInicio(new Date());
		consultaHis.setMotivoConsulta("Doler de cabeza");
		consultaHis.setTipoConsulta("Precencial");
		consultaHis.setCleusUnidadSolicitante("unidad");
		
		pacienteHis.setNombrePaciente("Mariano");
		pacienteHis.setApellidoPaterno("Barajas");
		pacienteHis.setFechaNacimiento(new Date());
		
		consulta.setConsultaHis(consultaHis);
		consulta.setPacienteHis(pacienteHis);
	      mockMvc.perform(MockMvcRequestBuilders.post("/consulta-his")
	    	         .contentType(JSON)
	    	         .content(MAPPER.writeValueAsString(consulta)))
	    	         .andExpect(MockMvcResultMatchers.status().isCreated())
	    	         .andDo(MockMvcResultHandlers.print());
	}
}
