package net.amentum.niomedic.niogateway.api.rest.views.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UsuariosCanalizadosPageView implements Serializable {

    private Long idUsuarioEmisor;
    private Long idUsuarioReceptor;
    private Long idUsuarioPaciente;
    private Date fechaInicial;
    private Date fechaFinal;
    private Long usuariosCanalizadosId;
    private Integer idGroup;
    private String groupName;
}
