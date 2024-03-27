package net.amentum.niomedic.niogateway.exception;

public enum ExceptionServiceCode {
//   NIOGATEWAY,GROUP;
   EXPEDIENTE("EXPDTE"),
   MESSAGE("MSG");

   private final String valCode;

   ExceptionServiceCode(String valCode){
      this.valCode = valCode;
   }

   @Override
   public String toString() {
      return this.valCode;
   }
}
