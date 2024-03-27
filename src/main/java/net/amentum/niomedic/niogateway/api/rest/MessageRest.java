package net.amentum.niomedic.niogateway.api.rest;

import io.swagger.annotations.Api;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import net.amentum.niomedic.niogateway.exception.MessageException;
import net.amentum.niomedic.niogateway.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "Mensajes", description = "Servicios REST para eliminar mensajes")
@RestController
@RequestMapping("messages")
public class MessageRest extends BaseController {

   private final Logger logger = LoggerFactory.getLogger(MessageRest.class);

   private MessageService messageService;

   @Autowired
   public void setMessageService(MessageService messageService) {
      this.messageService = messageService;
   }

//   @RequestMapping(method = RequestMethod.DELETE)
//   @ResponseStatus(HttpStatus.OK)
//   public void deleteMessages(@RequestBody()List<Long> listIdMessage) throws MessageException {
//      logger.info("Eliminar lista de mensajes con id: {}", listIdMessage);
//      messageService.deleteMessage(listIdMessage);
//   }
}

