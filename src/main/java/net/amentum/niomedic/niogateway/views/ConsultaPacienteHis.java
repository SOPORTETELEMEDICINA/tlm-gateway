package net.amentum.niomedic.niogateway.views;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaPacienteHis implements Serializable{
	private static final long serialVersionUID = 5393119250079667738L;
	@NotNull(message="Por favor ingrese la informacion de consulta")
	@Valid
	private ConsultaHis consultaHis;
	@NotNull(message="Por favor ingrese la informacion del paciente")
	@Valid
	private PacienteHis pacienteHis;
	

}
