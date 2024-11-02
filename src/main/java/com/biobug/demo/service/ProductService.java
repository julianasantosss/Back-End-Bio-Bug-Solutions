package com.biobug.demo.service;

import com.biobug.demo.model.Product;
import com.biobug.demo.model.User;
import com.biobug.demo.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProductService implements IProductService{

    @Autowired
    private IProductRepository iProductRepository;


    @Override
    public List<Product> getProducts() {
        List<Product> productList = iProductRepository.findAll();
        return productList;
    }

    @Override
    public void saveProducts(Product product) { iProductRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id_Product) { iProductRepository.deleteById(id_Product);
    }

    @Override
    public Product findProduct(Long id_Product) { return iProductRepository.findById(id_Product).orElse(null);
    }

    @Override
    public void editProduct(Long id, String newNameProduct, String newScientificName, String newDescription, Double newPrice, String newImage, LocalDate newDateCreate) {
        Product product = this.findProduct(id);

//        product.setNameProduct(newNameProduct);
//        product.setScientificName(newScientificName);
//        product.setDescription(newDescription);
//        product.setPrice(newPrice);

        this.saveProducts(product);

    }
}
