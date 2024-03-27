package net.amentum.niomedic.niogateway.api.rest.views.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RecoverPasswordRequestView implements Serializable{
   @NotEmpty(message="Debe proporcionar el nombre de usuario")
   private String username;
   @NotEmpty(message="Ingrese la contraseña")
   private String password;
   @NotEmpty(message="Falta ingresar la contraseña")
   private String hash;
}