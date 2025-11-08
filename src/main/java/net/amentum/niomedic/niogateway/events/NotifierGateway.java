package net.amentum.niomedic.niogateway.events;

public interface NotifierGateway {
    void publishToGroup(Integer idGroup, Object payload);
    void publishToMedico(String idMedico, Object payload);

    // Opcional: helper para publicar a ambos
    default void publishToBoth(String idMedico, Integer idGroup, Object payload) {
        if (idGroup != null) publishToGroup(idGroup, payload);
        if (idMedico != null) publishToMedico(idMedico, payload);
    }
}
