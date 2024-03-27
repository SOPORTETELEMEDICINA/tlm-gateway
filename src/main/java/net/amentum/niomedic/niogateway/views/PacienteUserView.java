package net.amentum.niomedic.niogateway.views;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import net.amentum.niomedic.niogateway.api.rest.views.security.UserAppView;
import net.amentum.niomedic.pacientes.views.PacienteView;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PacienteUserView {
	private PacienteView pacienteVIew;
	private UserAppView userAppView;
    private Long selectedGroup; // Sre03072020 Agregado para usarlo como grupo del medico que crea
	private String code;
}
