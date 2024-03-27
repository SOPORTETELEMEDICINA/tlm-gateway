package net.amentum.niomedic.niogateway.events;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.amentum.niomedic.niogateway.model.MessageQueue;
import net.amentum.niomedic.niogateway.model.Session;
import net.amentum.niomedic.niogateway.persistence.MessageRepository;
import net.amentum.niomedic.niogateway.persistence.SessionRepositoy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Predicate;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class EventProcessor {

   private SimpMessagingTemplate simpMessagingTemplate;

   private final Logger logger = LoggerFactory.getLogger(EventProcessor.class);

   private SessionRepositoy sessionRepositoy;

   private MessageRepository messageRepository;

   @Autowired
   public void setSessionRepositoy(SessionRepositoy sessionRepositoy) {
      this.sessionRepositoy = sessionRepositoy;
   }

   @Autowired
   public void setMessageRepository(MessageRepository messageRepository) {
      this.messageRepository = messageRepository;
   }

   @Autowired
   public EventProcessor(SimpMessagingTemplate simpMessagingTemplate){
      this.simpMessagingTemplate = simpMessagingTemplate;
   }

   private ObjectMapper objectMapper;

   @Autowired
   public void setObjectMapper(ObjectMapper objectMapper) {
      this.objectMapper = objectMapper;
   }

   //@Autowired
   //@Output(Processor.OUTPUT)
   private MessageChannel output;

   public void sendMessage(Map<String,Object> sendMessage){
      logger.info("Enviar mensaje a microservicio de seguridad: {}",sendMessage);
      output.send(MessageBuilder.withPayload(sendMessage).build());
   }

   //@StreamListener(Processor.INPUT)
   public void streamListener(EventMessage eventMessage){
      switch (eventMessage.getCode()){
         case EventMessageType.CONNECTED:
         case EventMessageType.DISCONNECTED:
            simpMessagingTemplate.convertAndSend("/topic/messages/"+eventMessage.getQueue(),MessageBuilder.withPayload(eventMessage.getMessages()).build());
            break;
         case EventMessageType.MESSAGES:
            String destinationSplit []= eventMessage.getQueue().split("/");
            String agent = destinationSplit[destinationSplit.length-1];
            Specification<MessageQueue> specification = Specifications.where(
               ((root, query, cb) -> {
                  Predicate tc = null;
                  tc = cb.equal(root.get("toAgent"), agent);
                  return tc;
               } )
            );
            List<MessageQueue> messageList = messageRepository.findAll(specification);
            if(messageList.size()>0) {
               List<Map<String, Object>> allMessages = new ArrayList<>();
               for (MessageQueue msg : messageList) {
                  Map<String, Object> addMensaje = new HashMap<>();
                  addMensaje.put("code", msg.getCode());
                  addMensaje.put("idMensaje", msg.getIdMessage());
                  try {
                     addMensaje.put("content", objectMapper.readValue(msg.getContent(), new TypeReference<Map<String,Object>>(){}));
                  } catch (IOException e) {
                     e.printStackTrace();
                  }
                  allMessages.add(addMensaje);
               }
               simpMessagingTemplate.convertAndSend(eventMessage.getQueue(), MessageBuilder.withPayload(allMessages).build());
            }
            break;
         default:
            if(eventMessage.getToAgent()!=null && !eventMessage.getToAgent().isEmpty()){

               Specification<Session> spec = Specifications.where(
                  (root, query, cb) -> {
                     Predicate tc = null;
                     tc = cb.equal(root.get("username"), eventMessage.getToAgent());
                     return tc;
                  }
               );
               Long sessionsUser = sessionRepositoy.count(Specifications.where(spec));
               logger.info(" num session : {}", sessionsUser);

               if(sessionsUser > 0){
                  logger.info("Enviar mensaje a agente:{}",eventMessage.getToAgent());
                  simpMessagingTemplate.convertAndSend("/topic/messages/"+eventMessage.getToAgent(),MessageBuilder.withPayload(eventMessage.getMessages()).build());
               } else {
                  MessageQueue message = new MessageQueue();
                  message.setQueue(eventMessage.getQueue());
                  message.setCode(eventMessage.getCode());
                  message.setToAgent(eventMessage.getToAgent());
                  for ( Map<String,Object> contenidoMsg: eventMessage.getMessages()){
                     try {
                        message.setContent(objectMapper.writeValueAsString((LinkedHashMap<String,Object>)contenidoMsg.get(EventMessageType.CONTENT)));
                     } catch (JsonProcessingException e) {
                        e.printStackTrace();
                     }
                  }
                  messageRepository.save(message);
               }
            }
            logger.info("Enviar trabajo de agente a controladores",eventMessage.getQueue());
            simpMessagingTemplate.convertAndSend("/topic/messages/"+eventMessage.getQueue(),MessageBuilder.withPayload(eventMessage.getMessages()).build());
            break;
      }
   }
}

