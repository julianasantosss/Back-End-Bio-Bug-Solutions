package com.biobug.demo.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Table(name = "products")
@Entity
@Getter
@EqualsAndHashCode
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_product")
    private Long idProduct;
    @Column(name = "name_product")
    private String nameProduct;
    @Column(name = "scientific_name")
    private String scientificName;
    private String description;
    private Double price;
    @Column(name = "image")
    private String img;
    @Column(name = "date")
    private LocalDate dateCreation;
    @ManyToOne
    @JoinColumn(name = "id_order_detail")
    private OrderDetail orderDetail;




    //constructor vacio
    public Product() {
    }

    public Product(Long idProduct, String nameProduct, String scientificName, String description, Double price, String img, LocalDate dateCreation) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.scientificName = scientificName;
        this.description = description;
        this.price = price;
        this.img = img;
        this.dateCreation = dateCreation;
    }

    //GETTER Y SETTER
//    public Long getIdProduct() {
//        return idProduct;
//    }
//
//    public void setIdProduct(Long idProduct) {
//        this.idProduct = idProduct;
//    }
//
//    public String getNameProduct() {
//        return nameProduct;
//    }
//
//    public void setNameProduct(String nameProduct) {
//        this.nameProduct = nameProduct;
//    }
//
//    public String getScientificName() {
//        return scientificName;
//    }
//
//    public void setScientificName(String scientificName) {
//        this.scientificName = scientificName;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public Double getPrice() {
//        return price;
//    }
//
//    public void setPrice(Double price) {
//        this.price = price;
//    }
//
//    public String getImg() {
//        return img;
//    }
//
//    public void setImg(String img) {
//        this.img = img;
//    }
//
//    public LocalDate getDateCreation() {
//        return dateCreation;
//    }
//
//    public void setDateCreation(LocalDate dateCreation) {
//        this.dateCreation = dateCreation;
//    }
}
