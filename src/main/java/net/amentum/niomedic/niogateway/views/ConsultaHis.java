package net.amentum.niomedic.niogateway.views;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaHis implements Serializable{
	
	private static final long serialVersionUID = -6923131527918429895L;
	private String idConsulta;
	private String Sintonmas;
	@NotBlank(message="Por favor ingrese una especialidad")
	private String especialidad;
	@NotNull(message="Por favor ingrese la Fecha de Fin")
	private Date fechaFin;
	@NotNull(message="Por favor ingrese la Fecha de Inicio")
	private Date fechaInicio;
	private String motivoConsulta;
	private String tipoConsulta;
	private String MedicoSolicitante;
	private String cleusUnidadSolicitante;
	
	
}
