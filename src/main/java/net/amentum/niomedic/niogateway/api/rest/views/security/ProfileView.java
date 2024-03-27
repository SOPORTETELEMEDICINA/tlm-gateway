package net.amentum.niomedic.niogateway.api.rest.views.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProfileView implements Serializable {

   private Long profileId;
   @NotEmpty(message = "Agreggue el nombre del perfil")
   private String profileName;
   private Date createdDate = new Date();
   @NotEmpty(message = "Agregue al menos un permiso")
   private List<PermissionView> profilePermissions;
   private Boolean active = Boolean.TRUE;
   private Boolean allowEdition = Boolean.TRUE;
   private List<NodeTree> tree;

}