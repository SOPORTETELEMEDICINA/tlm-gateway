package net.amentum.niomedic.niogateway.api.rest.views.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExtraFieldView implements Serializable{

   private Long extraFieldId;
   @NotEmpty(message = "Debe ingresar un ideintificador al campo")
   private String key;
   private String legend;
   private Boolean active = Boolean.TRUE;
   @NotEmpty(message = "Debe agregar el tipo de campo que se va a crear")
   private String fieldType;
   private String fieldValidation;
   private Date createdDate = new Date();
   private String validationMessage;
   @NotNull(message = "Debe seleccionar a que perfil le pertenece el campo")
   private Long profileId;
   private String profileName;


   @Override
   public String toString() {
      return "ExtraFieldView{" +
         "extraFieldId=" + extraFieldId +
         ", key='" + key + '\'' +
         ", legend='" + legend + '\'' +
         ", active=" + active +
         ", fieldType='" + fieldType + '\'' +
         ", fieldValidation='" + fieldValidation + '\'' +
         ", createdDate=" + createdDate +
         ", validationMessage='" + validationMessage + '\'' +
         ", profileId=" + profileId +
         ", profileName='" + profileName + '\'' +
         '}';
   }
}

