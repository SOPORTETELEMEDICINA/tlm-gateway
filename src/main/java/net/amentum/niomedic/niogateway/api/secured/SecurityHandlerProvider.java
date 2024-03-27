package net.amentum.niomedic.niogateway.api.secured;

import net.amentum.niomedic.niogateway.AESEncrypt;
import net.amentum.niomedic.niogateway.api.rest.BaseController;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value; // Sre22052020 Nuevo

import java.util.ArrayList;
import java.util.List;

@Component
public class SecurityHandlerProvider extends BaseController {

   // Sre22052020 Agrego nueva variable de ambiente para que la ruta al secret.key no este hard-coded
   @Value("${secret.path:/opt/secrets/}")
   private String secretPath;

   @Autowired
   private ResourceLoader resourceLoader;

   public String decryptHeader(HttpServletRequest request) throws Exception{
      //Resource rs = resourceLoader.getResource("classpath:static/secret.key");
      //File  file = rs.getFile();
      // Sre22052020 Inicia uso variable para el path
      //AESEncrypt aesEncrypt = new AESEncrypt("/opt/secrets/secret.key");
      AESEncrypt aesEncrypt = new AESEncrypt(secretPath + "secret.key");
      // Sre22052020 Termina
      String decryptedMessage = "";
      try{
         decryptedMessage = aesEncrypt.decrypt(request.getHeader("hier_token"));
      }catch (NullPointerException ioe){
         //  System.out.println("NullPointerException: "+ioe);
      }catch (Exception ioe){
         // System.out.println("Exception: "+ioe);
      }
      return decryptedMessage.trim();
   }

   public List<Long> getHierarchy(String encoded, String key){
      //TODO aqui vas a hacer el split del desifrado y vas a obtener solo la herarquia que deseas
      String [] values = key.split("\\|");
      boolean encodedFind = false;
      List<Long> ids = new ArrayList<>();
      for(int i = 0;i<values.length;i++){
         if(encodedFind && !values[i].trim().isEmpty()){
            try{
               ids.add(Long.valueOf(values[i].trim()));
            }catch (Exception ex){
               break;
            }
         }
         if(values[i].trim().equals(encoded)){
            encodedFind = true;//busca las letras G TT....
         }
      }
      return ids;
   }

   public String getName(String encoded, String key){
      String [] values = key.split("\\|");
      boolean encodedFind = false;
      String name = "";
      for(int i = 0;i<values.length;i++){
         if(encodedFind && !values[i].trim().isEmpty()){
            try{
               if(name != null && name.isEmpty()){
                  name = values[i].trim();
               }
            }catch (Exception ex){
               break;
            }
         }
         if(values[i].trim().equals(encoded)){
            encodedFind = true;//busca las letras G TT....
         }
      }
      return name;
   }
}

