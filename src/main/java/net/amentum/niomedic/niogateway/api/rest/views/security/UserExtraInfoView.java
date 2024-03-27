package net.amentum.niomedic.niogateway.api.rest.views.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserExtraInfoView implements Serializable {

   private static final long serialVersionUID = -4359963927786622782L;
   private Long userExtraInfoId;
   @NotEmpty(message = "Agregue el key")
   private String key;
   @NotEmpty(message = "Agregue el value")
   private String value;
   private Date createdDate;
   private Date modifiedDate;
   private String status;

}