package net.amentum.niomedic.niogateway.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

public class UserFeignClientInterceptor implements RequestInterceptor {
   private static final String AUTHORIZATION_HEADER = "Authorization";
   private static final String BEARER_TOKEN_TYPE = "Bearer";

   @Override
   public void apply(RequestTemplate template) {
      SecurityContext securityContext = SecurityContextHolder.getContext();
      if(securityContext.getAuthentication() instanceof AnonymousAuthenticationToken) {
         AnonymousAuthenticationToken token = (AnonymousAuthenticationToken) securityContext.getAuthentication();
         /*System.out.println(token.getDetails());*/
      }
      else if(securityContext.getAuthentication() instanceof OAuth2Authentication) {
         OAuth2Authentication authentication = (OAuth2Authentication) securityContext.getAuthentication();
         if (authentication != null && authentication.getDetails() instanceof OAuth2AuthenticationDetails) {
            OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
            Object decoded = details.getDecodedDetails();
            /*System.out.println(decoded);
            template.header(AUTHORIZATION_HEADER, String.format("%s %s", BEARER_TOKEN_TYPE, details.getTokenValue()));*/
         }
      }
   }

}
