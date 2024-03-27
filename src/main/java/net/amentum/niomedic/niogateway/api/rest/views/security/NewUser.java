package net.amentum.niomedic.niogateway.api.rest.views.security;

import java.io.Serializable;
import java.util.Date;

public class NewUser implements Serializable {
    private Long newUserRequestId;
    private Boolean active;
    private Date createdDate;
    private Date timeBeforeExpire;
    private String hash;
    private String username;
    private Integer idGroup;
    private String idUsuario;
    private String name;

    public Long getNewUserRequestId() {
        return newUserRequestId;
    }

    public void setNewUserRequestId(Long newUserRequestId) {
        this.newUserRequestId = newUserRequestId;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getTimeBeforeExpire() {
        return timeBeforeExpire;
    }

    public void setTimeBeforeExpire(Date timeBeforeExpire) {
        this.timeBeforeExpire = timeBeforeExpire;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(Integer idGroup) {
        this.idGroup = idGroup;
    }

    public String getidUsuario() {
        return idUsuario;
    }

    public void setidUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "NewUser{" +
                "newUserRequestId=" + newUserRequestId +
                ", active=" + active +
                ", createdDate=" + createdDate +
                ", timeBeforeExpire=" + timeBeforeExpire +
                ", hash='" + hash + '\'' +
                ", username='" + username + '\'' +
                ", idGroup=" + idGroup +
                ", idUsuario='" + idUsuario + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
