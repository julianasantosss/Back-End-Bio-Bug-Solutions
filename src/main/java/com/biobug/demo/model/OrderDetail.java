package com.biobug.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
@Table(name = "orders_details")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_order_detail")
    private Long idDetail;
    @OneToMany(mappedBy = "orderDetail", cascade = CascadeType.ALL)
    private List<Product> products;
    private Integer count;
    @ManyToOne
    @JoinColumn(name = "id_order")
    private Order order;


    //constructor vacio
//    public OrderDetail() {
//    }
//
//    public OrderDetail(Long idDetail) {
//        this.idDetail = idDetail;
//    }
//
//    //GETTER Y SETTER
//    public Long getIdDetail() {
//        return idDetail;
//    }
//
//    public void setIdDetail(Long idDetail) {
//        this.idDetail = idDetail;
//    }
}
