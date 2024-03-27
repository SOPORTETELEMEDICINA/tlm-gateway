package net.amentum.niomedic.niogateway.api.rest.views.security;

import java.util.Date;

public class NewUserView {

    private String nombre;
    private String idUsuario;
    private Integer idGroup;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Integer idGroup) {
        this.idGroup = idGroup;
    }

    @Override
    public String toString() {
        return "NewUserView{" +
                "nombre='" + nombre + '\'' +
                ", idUsuario='" + idUsuario + '\'' +
                ", idGroup=" + idGroup +
                '}';
    }
}
