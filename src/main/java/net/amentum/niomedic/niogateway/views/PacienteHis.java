package net.amentum.niomedic.niogateway.views;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteHis implements Serializable{

	private static final long serialVersionUID = 8877825439560564164L;
	
	private String idPaciente;
	@Size(min = 3, max = 50)
	@NotBlank(message="Por favor ingrese el nombre del Paciente")
	private String nombrePaciente;
	@Size(min = 3, max = 50)
	@NotBlank(message="Por favor ingrese el apellido paterno")
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String sexo;
	private String estadoCivil;
	private String religion;
	@NotNull(message="Por favor ingrese la fecha de nacimiento")
	private Date fechaNacimiento;
	private String lugarDeNacimiento;
	private String curp;
	private  String email;
	private String telefonoCelular;
	private String telefonoLocal;
	private String numeroAfiliacion;
	private Long numeroExpediente;
	private String tipoSangre;
	

}
