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
import java.util.Map;


@Component
public class InboundMessageInterceptor extends ChannelInterceptorAdapter{

   private final Logger logger = LoggerFactory.getLogger(InboundMessageInterceptor.class);

   private EventProcessor eventProcessor;

   private SessionRepositoy sessionRepositoy;

   @Autowired
   public void setSessionRepositoy(SessionRepositoy sessionRepositoy) {
      this.sessionRepositoy = sessionRepositoy;
   }

   @Autowired
   public void setSocketSessionRest(EventProcessor eventProcessor) {
      this.eventProcessor = eventProcessor;
   }

   @Override
   public Message<?> preSend(Message<?> message, MessageChannel channel) {
      StompHeaderAccessor accessor =StompHeaderAccessor.wrap(message);
      String sessionId = (String)message.getHeaders().get("simpSessionId");
      logger.info("Getting security context for: {} - sessionId: {}",accessor,sessionId);
      if(accessor.getCommand().equals(StompCommand.CONNECT)){
         String username = accessor.getNativeHeader("username").get(0);
         String deviceId = accessor.getNativeHeader("deviceId").get(0);
         logger.info("Load username pending data: {}",username);

         if(username != null && !username.isEmpty()){
            SocketSessionView sessionView = new SocketSessionView();
            sessionView.setDeviceId(deviceId);
            sessionView.setSessionId(sessionId);
            sessionView.setUsername(username);
            Map<String,Object> params = new HashMap<>();
            params.put(EventMessageType.CONTENT,sessionView);
            params.put(EventMessageType.CODE,EventMessageType.CONNECTED);
            eventProcessor.sendMessage(params);

            Session session = new Session();
            session.setConnection_status("Online");
            session.setDeviceId(deviceId);
            session.setSessionId(sessionId);
            session.setUsername(username);
            sessionRepositoy.save(session);
         }

      }else if(accessor.getCommand().equals(StompCommand.DISCONNECT)){
         logger.info("Remove session: {} from database",sessionId);
         try{
            sessionRepositoy.delete(sessionId);
         }catch (DataAccessException e){

         }catch (Exception e){}


         Map<String,Object> params = new HashMap<>();
         params.put(EventMessageType.CONTENT,sessionId);
         params.put(EventMessageType.CODE,EventMessageType.DISCONNECTED);
         eventProcessor.sendMessage(params);
      }else if(accessor.getCommand().equals(StompCommand.SUBSCRIBE)){
         String destination = accessor.getNativeHeader("destination").get(0);
         logger.info("SUBSCRIBE TO: {}",destination);
         Map<String,Object> params = new HashMap<>();
         SocketSessionView sessionView = new SocketSessionView();
         sessionView.setSessionId(sessionId);
         sessionView.setUsername(destination);
         params.put(EventMessageType.CODE,EventMessageType.MESSAGES);
         params.put(EventMessageType.CONTENT,sessionView);
         eventProcessor.sendMessage(params);
      }
      return super.preSend(message, channel);
   }

   @Bean
   public RequestContextListener requestContextListener(){
      return new RequestContextListener();
   }
}
