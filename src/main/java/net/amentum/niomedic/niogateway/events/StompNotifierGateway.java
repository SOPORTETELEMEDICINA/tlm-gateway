package net.amentum.niomedic.niogateway.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class StompNotifierGateway implements NotifierGateway {

    private final SimpMessagingTemplate template;

    @Autowired
    public StompNotifierGateway(SimpMessagingTemplate template) {
        this.template = template;
    }

    @Override
    public void publishToMedico(UUID idMedico, Object payload) {
        template.convertAndSend("/topic/medico-" + idMedico, payload);
    }
}
