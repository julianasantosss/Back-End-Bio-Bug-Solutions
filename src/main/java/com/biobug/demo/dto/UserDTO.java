package com.biobug.demo.dto;

import com.biobug.demo.model.User;

import java.util.List;

public record UserDTO(
        Long idUser, String rolUser, String nameUser, String lastName, String emailUser, List<OrderDTO> orders
) {
    public UserDTO(User user){
        this(user.getIdUser(), user.getRolUser(), user.getNameUser(), user.getLastName(), user.getEmailUser(),
                user.getOrders().stream().map(OrderDTO::new).toList());
    }
}
