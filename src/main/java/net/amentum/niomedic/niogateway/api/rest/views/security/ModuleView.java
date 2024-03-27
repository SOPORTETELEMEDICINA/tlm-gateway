package net.amentum.niomedic.niogateway.api.rest.views.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ModuleView implements Serializable {

   private static final long serialVersionUID = 8664058450514272123L;
   private Long moduleId;
   private Long parentalId;
   @NotEmpty(message = "Agregue el nombre del módulo")
   private String moduleName;
   private Date createdDate;

   @NotEmpty(message = "Agregue al menos un permiso al módulo")
   private List<PermissionView> modulePermissions = new ArrayList<>();
}
