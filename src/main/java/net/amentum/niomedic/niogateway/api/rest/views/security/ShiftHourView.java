package net.amentum.niomedic.niogateway.api.rest.views.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ShiftHourView implements Serializable {

   private Long idHour;
   @NotNull(message = "La hora de inicio es requerida.")
   private String startTime;
   @NotNull(message = "La hora final es requerida.")
   private String endTime;
   @NotNull(message = "El dia requerido.")
   private Long day;



}