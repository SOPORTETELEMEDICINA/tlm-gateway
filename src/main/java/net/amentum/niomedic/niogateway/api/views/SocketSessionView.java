package net.amentum.niomedic.niogateway.api.views;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SocketSessionView implements Serializable{
   private String sessionId;
   private String username;
   private String deviceId;
}
