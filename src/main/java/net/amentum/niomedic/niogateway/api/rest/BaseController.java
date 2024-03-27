package net.amentum.niomedic.niogateway.api.rest;

import net.amentum.niomedic.niogateway.exception.GenericException;
import net.amentum.niomedic.niogateway.exception.RestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class BaseController {

   private Logger logger = LoggerFactory.getLogger(BaseController.class);

   @ExceptionHandler({RestException.class})
   @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
   @ResponseBody
   public Map<String, Object> error(RestException ex) {
      logger.error(" - BASECONTROLER - RestException: ", ex);
      Map<String, Object> map = new HashMap<>();
      map.put("GW-code", ex.getCode());
      map.put("GW-message", ex.getMessage());
      map.put("GW-errorList", ex.getErrorList());
      return map;
   }

   @ExceptionHandler(value = GenericException.class)
   public HttpEntity<Object> error(GenericException ex) {
      logger.error(" - BASECONTROLER - GenericException: ", ex);
//      HttpHeaders headers = new HttpHeaders();
      return new ResponseEntity<>(ex.formatResponse(), ex.getStatus());
   }


}
