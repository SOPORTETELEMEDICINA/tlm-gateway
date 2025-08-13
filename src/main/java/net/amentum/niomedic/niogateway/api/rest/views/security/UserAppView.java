package net.amentum.niomedic.niogateway.api.rest.views.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAppView implements Serializable {
   /**
    *
    */
   private static final long serialVersionUID = 1502536465883625299L;
   private Long idUserApp;
   @NotEmpty(message = "Debe agregar un username")
   private String username;
   private String email;
   private String curp;
   private String password;
   private String password2;
   private String password3;
   private String telefono;
   private Date createdDate;
   @NotEmpty(message = "Debe ingresar el nombre del usuario")
   private String name;
   private String status;
   private String motivo;
   private Long customerId;
   private List<UserExtraInfoView>  extraList =  new ArrayList<>();
   //@NotNull(message = "Debe ingresar el id del perfil")
   private Long profileId;
   private List<Long> groupList = new ArrayList<>();
   private List<Long> permissionsList = new ArrayList<>();
   private Long idWorkShift;
   private String nameWorkShift;
   private UserImageView imageProfile;
   private String connectionStatus;
   private String profileName;
   private List<GroupView> groups = new ArrayList<>();
   private List<Long> idUsersAssigned = new ArrayList<>();

   private List<UsersAssignedView> infoUsers = new ArrayList<>();

   ////////////////////////////////////////////// catalogo tipo usuario
   private Integer idTipoUsuario;
   private String descripcion;
   ////////////////////////////////////////////// catalogo tipo usuario

   @Override
   public String toString() {
      return "UserAppView{" +
         "idUserApp=" + idUserApp +
         ", username='" + username + '\'' +
         ", email='" + email + '\'' +
         ", password='" + password + '\'' +
         ", password2='" + password2 + '\'' +
         ", password3='" + password3 + '\'' +
         ", telefono='" + telefono + '\'' +
         ", createdDate=" + createdDate +
         ", name='" + name + '\'' +
         ", status='" + status + '\'' +
         ", motivo='" + motivo + '\'' +
         ", customerId=" + customerId +
         ", extraList=" + extraList +
         ", profileId=" + profileId +
         ", groupList=" + groupList +
         ", permissionsList=" + permissionsList +
         ", image="+imageProfile+
         ", idUsersAssigned=" + idUsersAssigned +
         ", idTipoUsuario=" + idTipoUsuario +
         ", descripcion=" + descripcion +
         '}';
   }
}

