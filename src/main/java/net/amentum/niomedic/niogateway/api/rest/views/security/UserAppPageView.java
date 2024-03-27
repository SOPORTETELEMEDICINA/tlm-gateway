package net.amentum.niomedic.niogateway.api.rest.views.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserAppPageView implements Serializable {

   private static final long serialVersionUID = -3103560388405536704L;
   private Long idUserApp;
   private String username;
   private String email;
   private String name;
   private String profileName;
   private String status;
   private ArrayList<GroupView> groups;

}