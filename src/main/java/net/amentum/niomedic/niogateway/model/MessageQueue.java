package net.amentum.niomedic.niogateway.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "message")
public class MessageQueue implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long idMessage;
   private String code;
   private String queue;
   private String toAgent;
   @Lob
   private String content;

   public Long getIdMessage() {
      return idMessage;
   }

   public void setIdMessage(Long idMessage) {
      this.idMessage = idMessage;
   }

   public String getCode() {
      return code;
   }

   public void setCode(String code) {
      this.code = code;
   }

   public String getQueue() {
      return queue;
   }

   public void setQueue(String queue) {
      this.queue = queue;
   }

   public String getToAgent() {
      return toAgent;
   }

   public void setToAgent(String toAgent) {
      this.toAgent = toAgent;
   }

   public String getContent() {
      return content;
   }

   public void setContent(String content) {
      this.content = content;
   }


}
