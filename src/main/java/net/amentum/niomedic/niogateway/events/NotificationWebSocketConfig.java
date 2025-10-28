package net.amentum.niomedic.niogateway.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.handler.invocation.HandlerMethodArgumentResolver;
import org.springframework.messaging.handler.invocation.HandlerMethodReturnValueHandler;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptorAdapter;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.socket.config.annotation.*;

import java.util.List;

@Configuration
@EnableWebSocketMessageBroker
public class NotificationWebSocketConfig implements WebSocketMessageBrokerConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(NotificationWebSocketConfig.class);

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(1);
        scheduler.setThreadNamePrefix("ws-heartbeat-thread-");
        scheduler.initialize();

        config.enableSimpleBroker("/topic")
                .setTaskScheduler(scheduler)
                .setHeartbeatValue(new long[]{10000, 10000});
        config.setApplicationDestinationPrefixes("/app");
        config.setUserDestinationPrefix("/user");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").setAllowedOrigins("*");
        registry.addEndpoint("/ws").setAllowedOrigins("*").withSockJS();
    }

    // 🔹 Agrega este interceptor para diagnosticar y evitar NPEs
    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.setInterceptors(new ChannelInterceptorAdapter() {
            @Override
            public Message<?> preSend(Message<?> message, MessageChannel channel) {
                try {
                    StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(
                            message, StompHeaderAccessor.class);

                    if (accessor != null) {
                        StompCommand command = accessor.getCommand();
                        String dest = accessor.getDestination();
                        logger.info("📡 WS INBOUND → Command: {} | Destino: {}", command, dest);

                        // Revisa si el token viene en el header CONNECT
                        if (StompCommand.CONNECT.equals(command)) {
                            String auth = getFirst(accessor, "Authorization");
                            logger.info("🩺 Header Authorization: {}", auth);
                            // aquí podrías validar el token si fuera necesario
                        }
                    }
                } catch (Exception ex) {
                    logger.error("❌ Error en preSend de canal inbound:", ex);
                }
                return message; // deja pasar el mensaje
            }

            private String getFirst(StompHeaderAccessor accessor, String key) {
                List<String> list = accessor.getNativeHeader(key);
                return (list != null && !list.isEmpty()) ? list.get(0) : null;
            }
        });
    }

    @Override
    public void configureWebSocketTransport(WebSocketTransportRegistration registry) { }

    @Override
    public void configureClientOutboundChannel(ChannelRegistration registration) { }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) { }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) { }

    @Override
    public boolean configureMessageConverters(List<MessageConverter> messageConverters) {
        return false;
    }
}
