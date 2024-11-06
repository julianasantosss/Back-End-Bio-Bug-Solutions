package com.biobug.demo.dto;

import com.biobug.demo.model.Order;

import java.time.LocalDate;
import java.util.List;

public record OrderDTO(
        Long idOrder,
        LocalDate date,
        Double discount,
        Double subTotal,
        Double total,
        List<OrderDetailDTO> oderDetails

) {
    public OrderDTO(Order order){
        this(order.getIdOrder(), order.getDateCreation(), order.getDiscount(), order.getSubTotal(),
                order.getTotal(), order.getOrderDetails().stream().map(OrderDetailDTO::new).toList());
    }
}
