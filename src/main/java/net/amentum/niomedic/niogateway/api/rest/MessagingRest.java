package net.amentum.niomedic.niogateway.api.rest;

//import net.amentum.intouch.gateway.events.EventProcessor;
import net.amentum.niomedic.niogateway.events.EventProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("message-test")
public class MessagingRest {

   private SimpMessagingTemplate simpMessagingTemplate;

   private final Logger logger = LoggerFactory.getLogger(EventProcessor.class);

   @Autowired
   public MessagingRest(SimpMessagingTemplate simpMessagingTemplate){
      this.simpMessagingTemplate = simpMessagingTemplate;
   }

   @PostMapping()
   @PreAuthorize(value = "permitAll()")
   void sendMessage(@RequestBody()Map<String,Object> message){
      String queue = (String)message.get("queue");
      message.remove("queue");
      logger.info("queue:{} - message: {}",queue,message);
      this.simpMessagingTemplate.convertAndSend(queue, MessageBuilder.withPayload(message).build());
   }
}

