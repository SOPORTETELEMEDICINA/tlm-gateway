package net.amentum.niomedic.niogateway.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class Session implements Serializable {
   @Id
   private String sessionId;
   private String username;
   private String deviceId;
   private String connection_status;
}
