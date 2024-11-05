package com.biobug.demo.dto;

import com.biobug.demo.model.OrderDetail;

public record OrderDetailDTO(
        Long idDetail,
        ProductDTO  product,
        Integer quantity,
        Double price
) {
    public OrderDetailDTO(OrderDetail orderDetail){
        this(orderDetail.getIdDetail(), new ProductDTO(orderDetail.getProduct()), orderDetail.getQuantity(),
                orderDetail.getPrice());
    }
}
