package com.biobug.demo.dto;

import com.biobug.demo.model.Order;

import java.time.LocalDate;
import java.util.List;

public record OrderListDTO(
        Long idOrder,
        LocalDate date,
        UserListDTO user,
        Double discount,
        Double subTotal,
        Double total,
        List<OrderDetailDTO> oderDetails
) {
    public OrderListDTO(Order order){
        this(order.getIdOrder(), order.getDateCreation(), new UserListDTO(order.getUser()),
                order.getDiscount(), order.getSubTotal(), order.getTotal(),
                order.getOrderDetails().stream().map(OrderDetailDTO::new).toList());
    }
}
