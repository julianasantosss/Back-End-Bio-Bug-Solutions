package com.biobug.demo.dto;

import com.biobug.demo.model.User;

public record UserListDTO(Long idUser, String rolUser, String nameUser) {
    public UserListDTO(User user){
        this(user.getIdUser(), user.getRolUser(), user.getNameUser());
    }
}
