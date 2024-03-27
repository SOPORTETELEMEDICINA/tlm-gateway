package net.amentum.niomedic.niogateway.views;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.amentum.niomedic.medicos.views.MedicoView;
import net.amentum.niomedic.niogateway.api.rest.views.security.UserAppView;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MedicoUserView {
   private MedicoView medicoView;
   private UserAppView userAppView;
}
