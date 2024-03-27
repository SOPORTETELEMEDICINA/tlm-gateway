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
public class OauthClientDetailsView implements Serializable{
   private Integer accessTokenValidity;
   private String additionaInformation;
   private String authorities;
   private String authorizedGrantTypes;
   private String autoaprove;
   private String clientId;
   private String clientSecret;
   private Long id;
   private Integer refreshTokenValidity;
   private String resourceIds;
   private String scope;
   private String webServerRedirectUri;
}
