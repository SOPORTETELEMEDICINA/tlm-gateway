package net.amentum.niomedic.niogateway.api.rest.views.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NodeTree implements Serializable {

   private static final long serialVersionUID = -7137618952944195524L;
   private String content;
   private List<NodeTree> children;
   private Long id;
   @JsonIgnore
   private Long parentId;
   private Boolean active;
   private Boolean module;
   private Boolean expanded = false;
   @JsonIgnore
   private Integer childCount = 0;
   @JsonIgnore
   private Integer childSelected = 0;


}
