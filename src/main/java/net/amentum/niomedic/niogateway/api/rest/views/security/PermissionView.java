package net.amentum.niomedic.niogateway.api.rest.views.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PermissionView implements Serializable {

   private static final long serialVersionUID = 5987094396907921890L;
   private Long permissionId;
   @NotEmpty(message = "Debe ingresar el nombre del permiso")
   private String namePermission;
   @NotEmpty(message = "Debe ingresar el codigo del permiso")
   private String codePermission;

}
