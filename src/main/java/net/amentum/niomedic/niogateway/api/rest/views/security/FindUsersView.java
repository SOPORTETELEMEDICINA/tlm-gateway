package net.amentum.niomedic.niogateway.api.rest.views.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FindUsersView implements Serializable {

   private String name;
   private Integer page;
   private Integer size;
   private Long group;
   private String orderColumn;
   private String orderType;
   private List<Long> idUsersList = new ArrayList<>();

}