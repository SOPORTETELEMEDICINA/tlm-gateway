package net.amentum.niomedic.niogateway.api.rest.views.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuariosCanalizadosView implements Serializable {

    private Long idUsuarioEmisor;
    private Long idUsuarioReceptor;
    private Long idUsuarioPaciente;
    private Date fechaInicial;
    private Date fechaFinal;
    private Long usuariosCanalizadosId;
    private String nombrePaciente;
    private String nombreEmisor;
    private String nombreReceptor;

    @Override
    public String toString() {
        return "UsuariosCanalizadosView{" +
                "usuariosCanalizadosId=" + usuariosCanalizadosId +
                "idUsuarioEmisor=" + idUsuarioEmisor +
                ", idUsuarioReceptor='" + idUsuarioReceptor + '\'' +
                ", idUsuarioPaciente='" + idUsuarioPaciente + '\'' +
                ", fechaInicial='" + fechaInicial + '\'' +
                ", fechaFinal=" + fechaFinal +
                ", nombrePaciente=" + nombrePaciente +
                ", nombreEmisor=" + nombreEmisor +
                ", nombreReceptor=" + nombreReceptor +
                '}';
    }

}
