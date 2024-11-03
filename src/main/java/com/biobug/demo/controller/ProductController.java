package com.biobug.demo.controller;

import com.biobug.demo.model.Product;
import com.biobug.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService iProductService;
    @GetMapping
    public List<Product> getProductsAll(){
        return iProductService.getProducts();
    }
    @PostMapping
    public void createProduct(@RequestBody Product product){
        iProductService.saveProducts(product);
    }
    @DeleteMapping("/{idProduct}")
    public void deleteProduct( Long idProduct){
        iProductService.deleteProduct(idProduct);
    }
    @PutMapping
    public void editProduct(@RequestBody Product p){
        iProductService.editProduct(p);
    }
}
