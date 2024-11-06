package com.biobug.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idUser;
    private String rolUser;
    private String nameUser;
    private String lastName;
    private String emailUser;
    private String passwordUser;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;


    public User(String rolUser, String nameUser, String lastName, String emailUser, String passwordUser){
        this.rolUser = rolUser;
        this.nameUser = nameUser;
        this.lastName = lastName;
        this.emailUser = emailUser;
        this.passwordUser = passwordUser;
    }
    public void editUser(User user){
        if (user.getNameUser()!= null){
            this.nameUser = user.getNameUser();
        }
        if (user.getLastName()!= null){
            this.nameUser = user.getLastName();
        }
        if (user.getEmailUser()!= null){
            this.emailUser = user.getEmailUser();
        }
    }


}
