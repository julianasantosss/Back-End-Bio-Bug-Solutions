package com.biobug.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Table(name = "products")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
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
    @Column(name = "units_package")
    private Integer unitsPackage;
    @Column(name = "date")
    private LocalDate dateCreation;

public Product(String nameProduct,
    String scientificName,
    String description,
    Double price,
    String img,
    Integer unitsPackage,
    LocalDate dateCreation){
    this.nameProduct = nameProduct;
    this.scientificName = scientificName;
    this.description = description;
    this.price = price;
    this.img = img;
    this.unitsPackage = unitsPackage;
    this.dateCreation = dateCreation;

}


    public void updateProduct(Product product){
        if(product.getNameProduct() != null){
            this.nameProduct = product.getNameProduct();
        }
        if(product.getScientificName() != null){
            this.scientificName = product.getScientificName();
        }
        if(product.getPrice() != null){
            this.price = product.getPrice();
        }
        if(product.getDescription() != null){
            this.description = product.getDescription();
        }
    }

}
