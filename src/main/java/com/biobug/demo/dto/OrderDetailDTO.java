package com.biobug.demo.dto;

import com.biobug.demo.model.OrderDetail;

public record OrderDetailDTO(
        Long idDetail,
        Long  idProduct,
        Integer quantity,
        Double price
) {
    public OrderDetailDTO(OrderDetail orderDetail){
        this(orderDetail.getIdDetail(), orderDetail.getIdProduct(), orderDetail.getQuantity(),
                orderDetail.getPrice());
    }
}
