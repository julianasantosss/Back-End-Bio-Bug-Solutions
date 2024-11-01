package com.biobug.demo.service;

import com.biobug.demo.model.Product;

import java.time.LocalDate;
import java.util.List;

public interface IProductService {

    //Metodos
    //Traer
    public List<Product> getProducts();

    //Guardar
    public void saveProducts(Product product);

    //Eliminar por id
    public void deleteProduct(Long id_Product);

    //Buscar producto por id
    public Product findProduct(Long id_Product);

    //Editar producto
    public void editProduct(Long id,
                            String newNameProduct,
                            String newScientificName,
                            String newDescription,
                            Double newPrice,
                            String newImage,
                            LocalDate newDateCreate);
}
