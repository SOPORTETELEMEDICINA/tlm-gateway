package net.amentum.niomedic.niogateway.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.util.Map;

//@Configuration
public class ApiErrorDecoder implements ErrorDecoder {

   //   private final ErrorDecoder defaultErrorDecoder = new Default();
   private final ErrorDecoder defaultErrorDecoder = new ErrorDecoder.Default();
   ObjectMapper mapper = new ObjectMapper();
   private final Logger logger = LoggerFactory.getLogger(ApiErrorDecoder.class);
   private String body;

   @Override
   public Exception decode(String s, Response response) {
      try {
         String headers = response.headers().toString();
//         logger.info(headers);
         body = Util.toString(response.body().asReader());
//         logger.info(body);
         Exception exc = null;
         if (headers.contains("version")) {
//            body = {"code":404, "message":"No se encontró ningún Motivo de Envío con el id: 999"}
//          exc = mapper.readValue(body, GenericException.class); //v2

            Map<String, Object> respuesta = mapper.readValue(body, Map.class);
            exc = new GenericException(HttpStatus.valueOf((Integer) respuesta.get("code")), (String) respuesta.get("message"));
         } else {
//            body = {"code":"DAOEXPDTE107","message":"No se encuentra en el sistema CatalogoTipoEvento","errorList":["idCatalogoTipoEvento no encontrado: 99"]}
            exc = mapper.readValue(body, RestException.class); //v1
         }

//         Exception exc = mapper.readValue(body, RestException.class); //v1 o v2
         return exc;
      } catch (IOException ioe) {
         logger.error("ERROR ----->", ioe);
      }
      return defaultErrorDecoder.decode(s, response);
   }

   @Override
   public String toString() {
      return body;
   }
}

