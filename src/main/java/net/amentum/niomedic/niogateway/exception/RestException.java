package net.amentum.niomedic.niogateway.exception;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@NoArgsConstructor
public class RestException extends Exception {
   private String code;
   private String message;
   private List<String> errorList;

   public RestException(String code,String message,List<String> errorList){
      this.message = message;
      this.code = code;
      this.errorList = errorList;
   }
}

