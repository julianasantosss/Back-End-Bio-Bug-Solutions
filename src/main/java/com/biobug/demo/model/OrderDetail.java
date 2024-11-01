package com.biobug.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idDetail;

    //constructor vacio
    public OrderDetail() {
    }

    public OrderDetail(Long idDetail) {
        this.idDetail = idDetail;
    }

    //GETTER Y SETTER
    public Long getIdDetail() {
        return idDetail;
    }

    public void setIdDetail(Long idDetail) {
        this.idDetail = idDetail;
    }
}
