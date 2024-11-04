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
        User[] usersList = {
                new User("customer", "Juan Peréz",
                        "juan@gmail.com", "1234567"),
                new User("customer", "Sebastián Loaiza",
                        "seba@gmail.com", "1234567"),
                new User("customer", "Freddy Risquez",
                        "freddy@gmail.com", "1234567"),
                new User("customer", "Susana Villarroel",
                        "susan@gmail.com", "1234567"),
                new User("customer", "Oriana Camargo",
                        "ori@gmail.com", "1234567"),
                new User("admin", "Scarllett Johansson",
                        "sca007@gmail.com", "1234567"),
        };
    iUserRepository.saveAll(Arrays.asList(usersList));

// Crear instancias de usuarios y productos (ya existen en iUserRepository y iProductRepository)
        User user1 = iUserRepository.findById(1L).orElseThrow();
        User user2 = iUserRepository.findById(2L).orElseThrow();
        User user3 = iUserRepository.findById(3L).orElseThrow();

        Product product1 = iProductRepository.findById(1L).orElseThrow();
        Product product2 = iProductRepository.findById(2L).orElseThrow();
        Product product3 = iProductRepository.findById(3L).orElseThrow();
        Product product4 = iProductRepository.findById(4L).orElseThrow();
        Product product5 = iProductRepository.findById(5L).orElseThrow();
        Product product6 = iProductRepository.findById(6L).orElseThrow();

// Crear los OrderDetail para cada orden
        List<OrderDetail> orderDetails1 = Arrays.asList(
                new OrderDetail(null, product1.getIdProduct(), 2, product1.getPrice(), null),
                new OrderDetail(null, product2.getIdProduct(), 1, product2.getPrice(), null),
                new OrderDetail(null, product3.getIdProduct(), 3, product3.getPrice(), null)
        );

        List<OrderDetail> orderDetails2 = Arrays.asList(
                new OrderDetail(null, product4.getIdProduct(), 2, product4.getPrice(), null),
                new OrderDetail(null, product5.getIdProduct(), 1, product5.getPrice(), null),
                new OrderDetail(null, product6.getIdProduct(), 2, product6.getPrice(), null)
        );

        List<OrderDetail> orderDetails3 = Arrays.asList(
                new OrderDetail(null, product1.getIdProduct(), 1, product1.getPrice(), null),
                new OrderDetail(null, product3.getIdProduct(), 2, product3.getPrice(), null),
                new OrderDetail(null, product5.getIdProduct(), 3, product5.getPrice(), null)
        );

// Crear las órdenes y asignarles los usuarios y detalles
        Order[] orders = {
                new Order(null, LocalDate.of(2024, 11, 1), 10, null, null, user1, new ArrayList<>(orderDetails1)),
                new Order(null, LocalDate.of(2024, 11, 2), 15, null, null, user2, new ArrayList<>(orderDetails2)),
                new Order(null, LocalDate.of(2024, 11, 3), 5, null, null, user3, new ArrayList<>(orderDetails3))
        };

// Asignar cada OrderDetail a su respectiva orden
        for (OrderDetail detail : orderDetails1) {
            detail.setOrder(orders[0]);
        }
        for (OrderDetail detail : orderDetails2) {
            detail.setOrder(orders[1]);
        }
        for (OrderDetail detail : orderDetails3) {
            detail.setOrder(orders[2]);
        }

// Calcular subtotal y total para cada orden
        for (Order order : orders) {
            order.calculateSubTotal();
            order.calculateTotal(order.getDiscount());
        }

// Guardar las órdenes en la base de datos
        iOrderRepository.saveAll(Arrays.asList(orders));

    }
}
