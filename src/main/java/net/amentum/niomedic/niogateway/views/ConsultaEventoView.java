package net.amentum.niomedic.niogateway.views;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.amentum.niomedic.expediente.views.ConsultaView;
import net.amentum.niomedic.expediente.views.EventosView;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ConsultaEventoView {
   private ConsultaView consultaView;
   private EventosView eventosView;
}
