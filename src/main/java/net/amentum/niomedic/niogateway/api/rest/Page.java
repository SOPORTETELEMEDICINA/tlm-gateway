package net.amentum.niomedic.niogateway.api.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page<T> implements Serializable {
   private List<T> content = new ArrayList<>();
   private Boolean first = Boolean.FALSE;
   private Boolean last = Boolean.FALSE;
   private Integer number = new Integer(0);
   private Integer numberOfElements = new Integer(0);
   private Integer size = new Integer(0);
   private Integer totalElements = new Integer(0);
   private Integer totalPages = new Integer(0);
}