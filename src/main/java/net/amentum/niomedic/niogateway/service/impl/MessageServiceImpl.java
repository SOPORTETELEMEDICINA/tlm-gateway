package net.amentum.niomedic.niogateway.service.impl;

import net.amentum.niomedic.niogateway.exception.ExceptionServiceCode;
import net.amentum.niomedic.niogateway.exception.MessageException;
import net.amentum.niomedic.niogateway.persistence.MessageRepository;
import net.amentum.niomedic.niogateway.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MessageServiceImpl implements MessageService {

   private final Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);

   private MessageRepository messageRepository;

   @Autowired
   public void setMessageRepository(MessageRepository messageRepository) {
      this.messageRepository = messageRepository;
   }

//   @Transactional(readOnly = false, rollbackFor = {MessageException.class})
//   public void deleteMessage(List<Long> listIdMessage) throws MessageException {
//      try{
//         for (Long idMessage: listIdMessage) {
//            logger.info(" - Eliminar mensaje con id: {}", idMessage);
//            messageRepository.delete(idMessage);
//         }
//      }catch (Exception ex){
//         MessageException messageException = new MessageException(ex,"Error al eliminar la lista de mensajes",MessageException.LAYER_SERVICE,MessageException.ACTION_DELETE);
//         logger.error(ExceptionServiceCode.MESSAGE+"- Error al eliminar la lista de mensajes - CODE: {} - {}",messageException.getExceptionCode(),listIdMessage,ex);
//         throw  messageException;
//      }
//   }
}
