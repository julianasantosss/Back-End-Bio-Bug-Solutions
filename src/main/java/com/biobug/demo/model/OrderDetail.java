package com.biobug.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
@Table(name = "orders_details")
@Entity(name = "OrderDetail")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_order_detail")
    private Long idDetail;
   @Column(name = "id_product")
    private Long  idProduct;
    private Integer quantity;
    @Column(name = "price_product")
    private Double price;
    @ManyToOne
    @JoinColumn(name = "id_order")
    private Order order;

    public void updateOrderDetail(OrderDetail orderDetail){
        if(orderDetail.getQuantity() != null){
            this.quantity = orderDetail.getQuantity();
        }
    }

    public void setIdProduct(Long idProduct){
        this.idProduct = idProduct;
    }

    public void setOrder(Order order){
        this.order = order;
    }

    public void setPrice(Double price){
        this.price = price;
    }

    public void setQuantity(Integer quantity){
        this.quantity = quantity;
    }

}
