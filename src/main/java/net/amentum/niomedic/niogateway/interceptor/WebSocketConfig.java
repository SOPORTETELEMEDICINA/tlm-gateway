package net.amentum.niomedic.niogateway.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry;
import org.springframework.security.config.annotation.web.socket.AbstractSecurityWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * Clase necesaria para configurar el WebSocket
 * @author Victor
 * @version 1.0
 * */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractSecurityWebSocketMessageBrokerConfigurer {

   private final String ENDPOINT = "/refreshsocket";

   private final Logger logger = LoggerFactory.getLogger(WebSocketConfig.class);

   private InboundMessageInterceptor inboundMessageInterceptor;

   @Autowired
   public void setInboundMessageInterceptor(InboundMessageInterceptor inboundMessageInterceptor) {
      this.inboundMessageInterceptor = inboundMessageInterceptor;
   }

   @Override
   public void configureMessageBroker(MessageBrokerRegistry registry) {
      registry.enableSimpleBroker("/topic");
      registry.setApplicationDestinationPrefixes("/app");
   }

   @Override
   public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
      logger.info("Configurando web socker: {}",ENDPOINT);
      stompEndpointRegistry.addEndpoint(ENDPOINT)
         .setAllowedOrigins("*")
         .withSockJS();
   }

   @Override
   public void customizeClientInboundChannel(ChannelRegistration registration) {
      registration.setInterceptors(this.inboundMessageInterceptor);
   }

   @Override
   protected void configureInbound(MessageSecurityMetadataSourceRegistry messages) {
      messages.nullDestMatcher().authenticated()
         .simpSubscribeDestMatchers("/user/queue/errors").permitAll()
         .simpDestMatchers("/app/**").authenticated()
         // .simpSubscribeDestMatchers("/refreshsocket**").authenticated()
         .simpSubscribeDestMatchers("/topic/**").authenticated()
         .simpTypeMatchers(SimpMessageType.MESSAGE,SimpMessageType.SUBSCRIBE).denyAll()
         .anyMessage().denyAll();
      //super.configureInbound(messages);
   }

   @Override
   protected boolean sameOriginDisabled() {
      return Boolean.TRUE;
   }
}

