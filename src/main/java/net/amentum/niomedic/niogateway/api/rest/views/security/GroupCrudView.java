package net.amentum.niomedic.niogateway.api.rest.views.security;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupCrudView implements Serializable {
    Long idGroupCrud;
    Long idGroup;
    String image;
    String color;

    @Override
    public String toString() {
        return "GroupCrudView{" +
                "idGroupCrud=" + idGroupCrud +
                ", idGroup='" + idGroup + '\'' +
                ", image='" + image + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

}
