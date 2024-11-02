package com.biobug.demo.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
@Table(name = "orders")
@Entity
@Getter
@EqualsAndHashCode
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_order")
    private Long idOrder;
    @Column(name = "date")
    private LocalDate dateCreation;
    private Double total;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

    //constructor vacio
    public Order() {
    }

    public Order(Long idOrder, LocalDate dateCreation, Double total) {
        this.idOrder = idOrder;
        this.dateCreation = dateCreation;
        this.total = total;
    }

    //GETTER Y SETTER
//    public Long getIdOrder() {
//        return idOrder;
//    }
//
//    public void setIdOrder(Long idOrder) {
//        this.idOrder = idOrder;
//    }
//
//    public LocalDate getDateCreation() {
//        return dateCreation;
//    }
//
//    public void setDateCreation(LocalDate dateCreation) {
//        this.dateCreation = dateCreation;
//    }
//
//    public Double getTotal() {
//        return total;
//    }
//
//    public void setTotal(Double total) {
//        this.total = total;
//    }
}
