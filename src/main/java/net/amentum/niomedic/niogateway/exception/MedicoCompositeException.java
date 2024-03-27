package net.amentum.niomedic.niogateway.exception;

import lombok.Getter;
import lombok.Setter;
import net.amentum.common.GenericException;

public class MedicoCompositeException extends GenericException {
//   private final ExceptionServiceCode MODULE_CODE = ExceptionServiceCode.NIOGATEWAY;
   private final ExceptionServiceCode MODULE_CODE = ExceptionServiceCode.MESSAGE;
   @Getter
   @Setter
   private String layer;
   @Getter
   @Setter
   private String action;

   public MedicoCompositeException(Exception ex, String message, String layer, String action){
      super(ex,message);
      this.layer = layer;
      this.action = action;
   }

   public MedicoCompositeException(String message, String layer, String action){
      super(message);
      this.layer = layer;
      this.action = action;
   }

   @Override
   public String getExceptionCode() {
      return new StringBuffer(layer).append(MODULE_CODE).append(action).toString();
   }
}
