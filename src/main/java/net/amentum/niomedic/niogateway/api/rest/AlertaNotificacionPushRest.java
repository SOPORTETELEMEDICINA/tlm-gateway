package net.amentum.niomedic.niogateway.api.rest;

import net.amentum.niomedic.expediente.views.AlertaNotificacionView;
import net.amentum.niomedic.niogateway.events.NotifierGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/push/alertas")
public class AlertaNotificacionPushRest {

    private final NotifierGateway notifier;

    @Autowired
    public AlertaNotificacionPushRest(NotifierGateway notifier) {
        this.notifier = notifier;
    }

    @PostMapping("/notificaciones")
    public void pushAlerta(@RequestBody AlertaNotificacionView view) {
        if (view == null) return;
        notifier.publishToBoth(view.idMedico, view.idGroup, view);
    }
}
