package net.amentum.niomedic.niogateway.events;

import java.util.UUID;

public interface NotifierGateway {
    void publishToMedico(UUID idMedico, Object payload);
}
