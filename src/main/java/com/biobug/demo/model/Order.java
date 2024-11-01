package com.biobug.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idOrder;
    private LocalDate dateCreation;
    private Double total;

    //constructor vacio
    public Order() {
    }

    public Order(Long idOrder, LocalDate dateCreation, Double total) {
        this.idOrder = idOrder;
        this.dateCreation = dateCreation;
        this.total = total;
    }

    //GETTER Y SETTER
    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
