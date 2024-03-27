package net.amentum.niomedic.niogateway.api.rest.views.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InfoBasicResponseView implements Serializable {

   private Long idUser;
   private String username;
   private String name;
   private UserImageView image = new UserImageView();
}


