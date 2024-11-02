package com.biobug.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idUser;
    private String rolUser;
    private String nameUser;
    private String emailUser;
    private String passwordUser;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;

    //constructor vacio
    public User() {
    }

    public User(Long idUser, String passwordUser, String emailUser, String nameUser, String rolUser) {
        this.idUser = idUser;
        this.passwordUser = passwordUser;
        this.emailUser = emailUser;
        this.nameUser = nameUser;
        this.rolUser = rolUser;
    }

    //GETTER Y SETTER
    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getRolUser() {
        return rolUser;
    }

    public void setRolUser(String rolUser) {
        this.rolUser = rolUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public void editUser(User user){
        if (user.getNameUser()!= null){
            this.nameUser = user.getNameUser();
        }
        if (user.getEmailUser()!= null){
            this.emailUser = user.getEmailUser();
        }
    }


}
