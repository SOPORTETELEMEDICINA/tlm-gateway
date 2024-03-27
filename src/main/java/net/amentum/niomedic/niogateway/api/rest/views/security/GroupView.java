package net.amentum.niomedic.niogateway.api.rest.views.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList; // Sre22052020 Nuevo
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GroupView implements Serializable {
   private Long groupId;
   @NotEmpty(message = "Ingrese el nombre del grupo")
   private String groupName;
   @NotNull(message = "El campo no debe ser nulo")
   private Boolean active = Boolean.TRUE;
   private Date createdDate= new Date();
   // Sre22052020 El ticket es opcional y no está en el UI de Grupos:
   //@Valid
   //@NotEmpty(message = "Debe ingresar al menos un tipo de ticket.")
   private List<TicketTypeView> ticketTypeView = new ArrayList<>();

   //GGR20200612
   private String imagen;


   public String toStringResume() {
      return "GroupView{" +
         "groupId=" + groupId +
         ", groupName='" + groupName + '\'' +
         '}';
   }
}
