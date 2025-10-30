package net.amentum.niomedic.niogateway.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry;
import org.springframework.security.config.annotation.web.socket.AbstractSecurityWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;

/**
 * Configuración UNIFICADA de WebSocket con dos endpoints:
 * - /refreshsocket: Sistema legacy con autenticación
 * - /ws: Notificaciones push sin autenticación
 *
 * IMPORTANTE: Esta es la ÚNICA configuración de WebSocket.
 * No debe existir WebSocketMessageSecurityConfig ni NotificationWebSocketConfig
 *
 * @author Victor
 * @version 3.0
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractSecurityWebSocketMessageBrokerConfigurer {

    private final Logger logger = LoggerFactory.getLogger(WebSocketConfig.class);

    private InboundMessageInterceptor inboundMessageInterceptor;

    @Autowired
    public void setInboundMessageInterceptor(InboundMessageInterceptor inboundMessageInterceptor) {
        this.inboundMessageInterceptor = inboundMessageInterceptor;
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        logger.info("Configurando Message Broker para WebSocket");

        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(1);
        scheduler.setThreadNamePrefix("ws-heartbeat-thread-");
        scheduler.initialize();

        registry.enableSimpleBroker("/topic")
                .setTaskScheduler(scheduler)
                .setHeartbeatValue(new long[]{10000, 10000});
        registry.setApplicationDestinationPrefixes("/app");
        registry.setUserDestinationPrefix("/user");

        logger.info("Message Broker configurado exitosamente");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Endpoint 1: /refreshsocket (sistema legacy con autenticación)
        logger.info("Registrando endpoint /refreshsocket (con autenticación)");
        registry.addEndpoint("/refreshsocket")
                .setAllowedOrigins("*")
                .withSockJS();

        // Endpoint 2: /ws (notificaciones sin autenticación)
        logger.info("Registrando endpoint /ws (sin autenticación)");

        // WebSocket nativo
        registry.addEndpoint("/ws")
                .setAllowedOrigins("*");

        // WebSocket con SockJS fallback
        registry.addEndpoint("/ws")
                .setAllowedOrigins("*")
                .withSockJS();

        logger.info("Endpoints WebSocket registrados exitosamente");
    }

    @Override
    public void customizeClientInboundChannel(ChannelRegistration registration) {
        logger.info("Registrando interceptor para canal inbound");
        registration.setInterceptors(this.inboundMessageInterceptor);
    }

    @Override
    public void configureWebSocketTransport(WebSocketTransportRegistration registry) {
        registry.setMessageSizeLimit(128 * 1024);
        registry.setSendBufferSizeLimit(512 * 1024);
        registry.setSendTimeLimit(20 * 1000);
    }

    /**
     * CRÍTICO: Esta configuración permite conexiones sin autenticación
     * El interceptor (InboundMessageInterceptor) diferencia entre:
     * - Conexiones con username/deviceId → Valida y guarda en BD
     * - Conexiones sin username/deviceId → Permite sin validar (notificaciones)
     */
    @Override
    protected void configureInbound(MessageSecurityMetadataSourceRegistry messages) {
        logger.info("Configurando seguridad de mensajes STOMP");

        messages
                // Permitir CONNECT sin autenticación (se valida después en el interceptor)
                .nullDestMatcher().permitAll()

                // Suscripciones permitidas sin autenticación
                .simpSubscribeDestMatchers("/topic/**").permitAll()
                .simpSubscribeDestMatchers("/user/**").permitAll()
                .simpSubscribeDestMatchers("/user/queue/errors").permitAll()

                // Mensajes de aplicación permitidos
                .simpDestMatchers("/app/**").permitAll()

                // Permitir todo lo demás (el interceptor se encarga de validar)
                .anyMessage().permitAll();

        logger.info("Seguridad de mensajes STOMP configurada: TODOS los destinos permitidos");
    }

    @Override
    protected boolean sameOriginDisabled() {
        // Deshabilitar verificación same-origin para permitir conexiones cross-origin
        return true;
    }
}