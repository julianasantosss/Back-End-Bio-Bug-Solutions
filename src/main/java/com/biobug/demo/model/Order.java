package com.biobug.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Table(name = "orders")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_order")
    private Long idOrder;
    @Column(name = "date_order")
    private LocalDate dateCreation;
    @Column(name = "percentage_discount")
    private Integer discount = 0;
    @Column(name = "sub_total_price")
    private Double subTotal;
    @Column(name = "total_price")
    private Double total = 0.0;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails = new ArrayList<>();

    public void updateOrder(Order order){
        if(order.getTotal() != null){
            this.total = order.getTotal();
        }
    }
    public void addOrderDetail(OrderDetail orderDetail){
        this.orderDetails.add(orderDetail);
        orderDetail.setOrder(this);
    }
    public void deleteOrderDetail(Long idOrderDetail){
        this.orderDetails.removeIf( e -> e.getIdDetail().equals(idOrderDetail));
    }
    public void calculateSubTotal(){
        if(this.orderDetails != null){
            this.subTotal = this.orderDetails.stream().mapToDouble( d -> d.getPrice() * d.getQuantity()).sum();
        }
    }
    public void calculateTotal(Integer discount){
        if(this.orderDetails != null){
            Double priceDiscount = (this.orderDetails.stream().mapToDouble( d -> d.getPrice() * d.getQuantity()).sum()) * discount /100.0;
            this.total = this.orderDetails.stream().mapToDouble( d -> d.getPrice() * d.getQuantity()).sum() - priceDiscount;
        }
    }

}
