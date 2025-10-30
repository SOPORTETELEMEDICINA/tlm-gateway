package net.amentum.niomedic.niogateway.interceptor;

import net.amentum.niomedic.niogateway.api.views.SocketSessionView;
import net.amentum.niomedic.niogateway.events.EventMessageType;
import net.amentum.niomedic.niogateway.events.EventProcessor;
import net.amentum.niomedic.niogateway.model.Session;
import net.amentum.niomedic.niogateway.persistence.SessionRepositoy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptorAdapter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextListener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class InboundMessageInterceptor extends ChannelInterceptorAdapter {

    private final Logger logger = LoggerFactory.getLogger(InboundMessageInterceptor.class);

    private EventProcessor eventProcessor;
    private SessionRepositoy sessionRepositoy;

    @Autowired(required = false) // ⭐ Hacerlo opcional
    public void setSessionRepositoy(SessionRepositoy sessionRepositoy) {
        this.sessionRepositoy = sessionRepositoy;
    }

    @Autowired(required = false) // ⭐ Hacerlo opcional
    public void setSocketSessionRest(EventProcessor eventProcessor) {
        this.eventProcessor = eventProcessor;
    }

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        try {
            StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
            String sessionId = (String) message.getHeaders().get("simpSessionId");

            // ✅ Validación null-safe del comando
            if (accessor == null || accessor.getCommand() == null) {
                return message;
            }

            logger.info("Getting security context for: {} - sessionId: {}", accessor, sessionId);

            if (accessor.getCommand().equals(StompCommand.CONNECT)) {
                // ✅ Validación null-safe de headers
                List<String> usernameHeader = accessor.getNativeHeader("username");
                List<String> deviceIdHeader = accessor.getNativeHeader("deviceId");

                if (usernameHeader == null || usernameHeader.isEmpty() ||
                        deviceIdHeader == null || deviceIdHeader.isEmpty()) {
                    logger.warn("CONNECT sin username o deviceId - permitiendo conexión sin autenticación");
                    return message;
                }

                String username = usernameHeader.get(0);
                String deviceId = deviceIdHeader.get(0);

                logger.info("Load username pending data: {}", username);

                if (username != null && !username.isEmpty()) {
                    SocketSessionView sessionView = new SocketSessionView();
                    sessionView.setDeviceId(deviceId);
                    sessionView.setSessionId(sessionId);
                    sessionView.setUsername(username);

                    // ⭐ Validar eventProcessor antes de usar
                    if (eventProcessor != null) {
                        Map<String, Object> params = new HashMap<>();
                        params.put(EventMessageType.CONTENT, sessionView);
                        params.put(EventMessageType.CODE, EventMessageType.CONNECTED);
                        eventProcessor.sendMessage(params);
                    } else {
                        logger.warn("EventProcessor no disponible - saltando notificación CONNECTED");
                    }

                    // ⭐ Validar sessionRepositoy antes de usar
                    if (sessionRepositoy != null) {
                        Session session = new Session();
                        session.setConnection_status("Online");
                        session.setDeviceId(deviceId);
                        session.setSessionId(sessionId);
                        session.setUsername(username);
                        sessionRepositoy.save(session);
                    } else {
                        logger.warn("SessionRepository no disponible - saltando guardado de sesión");
                    }
                }

            } else if (accessor.getCommand().equals(StompCommand.DISCONNECT)) {
                logger.info("Remove session: {} from database", sessionId);

                // ⭐ Validar sessionRepositoy antes de usar
                if (sessionRepositoy != null) {
                    try {
                        sessionRepositoy.delete(sessionId);
                    } catch (DataAccessException e) {
                        logger.warn("Error deleting session: {}", e.getMessage());
                    } catch (Exception e) {
                        logger.warn("Unexpected error deleting session: {}", e.getMessage());
                    }
                }

                // ⭐ Validar eventProcessor antes de usar
                if (eventProcessor != null) {
                    Map<String, Object> params = new HashMap<>();
                    params.put(EventMessageType.CONTENT, sessionId);
                    params.put(EventMessageType.CODE, EventMessageType.DISCONNECTED);
                    eventProcessor.sendMessage(params);
                } else {
                    logger.warn("EventProcessor no disponible - saltando notificación DISCONNECTED");
                }

            } else if (accessor.getCommand().equals(StompCommand.SUBSCRIBE)) {
                // ✅ Validación null-safe de destination
                List<String> destinationHeader = accessor.getNativeHeader("destination");

                if (destinationHeader != null && !destinationHeader.isEmpty()) {
                    String destination = destinationHeader.get(0);
                    logger.info("SUBSCRIBE TO: {}", destination);

                    // ⭐ Validar eventProcessor antes de usar
                    if (eventProcessor != null) {
                        Map<String, Object> params = new HashMap<>();
                        SocketSessionView sessionView = new SocketSessionView();
                        sessionView.setSessionId(sessionId);
                        sessionView.setUsername(destination);
                        params.put(EventMessageType.CODE, EventMessageType.MESSAGES);
                        params.put(EventMessageType.CONTENT, sessionView);
                        eventProcessor.sendMessage(params);
                    } else {
                        logger.warn("EventProcessor no disponible - saltando notificación SUBSCRIBE");
                    }
                }
            }
        } catch (Exception e) {
            logger.error("Error en interceptor, permitiendo mensaje", e);
        }

        return message;
    }

    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }
}