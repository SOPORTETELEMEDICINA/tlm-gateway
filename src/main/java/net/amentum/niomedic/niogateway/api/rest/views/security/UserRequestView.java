package net.amentum.niomedic.niogateway.api.rest.views.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserRequestView implements Serializable {

   private String name;
   private Integer page;
   private Integer size;
   private String orderColumn;
   private String orderType;
   //@NotEmpty(message = "Es requerido la lista de grupos.")
   private List<Long> idGroups;
   // @NotEmpty(message = "Es requerido la lista de usuarios.")
   private List<Long> users = new ArrayList<>();
}