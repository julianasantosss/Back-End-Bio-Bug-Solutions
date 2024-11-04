package com.biobug.demo.service.Util;

import com.biobug.demo.model.Order;
import com.biobug.demo.model.OrderDetail;
import com.biobug.demo.model.Product;
import com.biobug.demo.model.User;
import com.biobug.demo.repository.IOrderRepository;
import com.biobug.demo.repository.IProductRepository;
import com.biobug.demo.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {
    private final IUserRepository iUserRepository;
    private final IProductRepository iProductRepository;
    private final IOrderRepository iOrderRepository;
    @Autowired
    public DataInitializer(IUserRepository iUserRepository, IProductRepository iProductRepository,
                           IOrderRepository iOrderRepository){
        this.iOrderRepository = iOrderRepository;
        this.iUserRepository = iUserRepository;
        this.iProductRepository = iProductRepository;

    }

    @Override
    public void run(String... args) throws Exception {


        Product[] productsList = {
                new Product("Bacillus thuringiensis", "Bacillus thuringiensis",
                        "Un agente bacteriano usado como insecticida biológico.",
                        120.00, "img/bacillus.jpg", LocalDate.of(2024, 10, 20)),
                new Product("Beauveria bassiana", "Beauveria bassiana",
                        "Un hongo entomopatógeno que controla plagas.", 150.00,
                        "img/beauveria.jpg", LocalDate.of(2024, 10, 21)),
                new Product("Metarhizium anisopliae", "Metarhizium anisopliae",
                        "Hongo biocontrolador de insectos dañinos.", 130.00,
                        "img/metarhizium.jpg", LocalDate.of(2024, 10, 22)),
                new Product("Trichoderma harzianum", "Trichoderma harzianum",
                        "Hongo usado para combatir hongos patógenos en plantas.", 140.00,
                        "img/trichoderma.jpg", LocalDate.of(2024, 10, 23)),
                new Product("Paecilomyces lilacinus", "Paecilomyces lilacinus",
                        "Un hongo para el control de nematodos.", 160.00,
                        "img/paecilomyces.jpg", LocalDate.of(2024, 10, 24)),
                new Product("Verticillium lecanii", "Verticillium lecanii",
                        "Hongo que se utiliza para controlar insectos chupadores.",
                        155.00, "img/verticillium.jpg", LocalDate.of(2024, 10, 25))
        };
        iProductRepository.saveAll(Arrays.asList(productsList));

    }
}
