package com.biobug.demo.dto;

import com.biobug.demo.model.Product;
import jakarta.persistence.Column;

import java.time.LocalDate;

public record ProductDTO(
        String nameProduct,
        String scientificName,
        String description,
        Double price,
        String img,
        LocalDate date
) {
    public ProductDTO(Product product){
        this(product.getNameProduct(), product.getScientificName(), product.getDescription(),
                product.getPrice(), product.getImg(), product.getDateCreation());
    }
}
