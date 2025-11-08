package net.amentum.niomedic.niogateway.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class StompNotifierGateway implements NotifierGateway {

    private final SimpMessagingTemplate template;

    @Autowired
    public StompNotifierGateway(SimpMessagingTemplate template) {
        this.template = template;
    }

    @Override
    public void publishToGroup(Integer idGroup, Object payload) {
        if (idGroup == null) return;
        template.convertAndSend("/topic/grupo-" + idGroup, payload);
    }

    @Override
    public void publishToMedico(String idMedico, Object payload) {
        if (idMedico == null || idMedico.trim().isEmpty()) return;
        template.convertAndSend("/topic/medico-" + idMedico, payload);
    }
}
