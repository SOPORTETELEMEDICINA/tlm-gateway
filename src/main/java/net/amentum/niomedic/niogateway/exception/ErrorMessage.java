package net.amentum.niomedic.niogateway.exception;

import java.io.Serializable;

public class ErrorMessage implements Serializable, Comparable<ErrorMessage> {
   private String code;
   private String message;


   public ErrorMessage() {
   }

   public ErrorMessage(String code, String message) {
      this.code = code;
      this.message = message;
   }

   public String getCode() {
      return code;
   }

   public void setCode(String code) {
      this.code = code;
   }

   public String getMessage() {
      return message;
   }

   public void setMessage(String message) {
      this.message = message;
   }

   @Override
   public int compareTo(ErrorMessage o) {
      return this.code.compareTo(o.code);
   }

   @Override
   public String toString() {
      return "ErrorMessage{" +
         "code='" + code + '\'' +
         ", message='" + message + '\'' +
         '}';
   }
}
