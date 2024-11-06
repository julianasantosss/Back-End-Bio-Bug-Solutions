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

        Product[] products = {
                new Product(
                        "Crisopas",
                        "Chrysoperla rufilabris",
                        "Depredadoras voraces de pulgones, ácaros, trips y otros pequeños insectos. Útiles en amplia gama de cultivos y entornos.",
                        100000.0,
                        "../img/insects/crisopas.jpg",
                        500, // unitsPackage
                        LocalDate.parse("2020-09-20")
                ),
                new Product(
                        "Avispas parasitoides",
                        "Trichogramma spp.",
                        "Parasitan los huevos de muchas plagas, incluyendo polillas y gusanos. Eficaces para prevenir infestaciones en cultivos.",
                        80000.0,
                        "../img/insects/avispas-parasitoides.jpg",
                        100, // unitsPackage
                        LocalDate.parse("2020-09-20")
                ),
                new Product(
                        "Ácaro depredador",
                        "Phytoseiulus persimilis",
                        "Depredador natural de la araña roja, una plaga común en cultivos bajo invernadero. Controla infestaciones rápidamente.",
                        160000.0,
                        "../img/insects/acaro-depredador.jpg",
                        80, // unitsPackage
                        LocalDate.parse("2020-09-20")
                ),
                new Product(
                        "Mariquitas",
                        "Hippodamia convergens",
                        "Depredadoras de pulgones, ácaros y otros insectos blandos. Son populares por su eficacia y facilidad de uso.",
                        120000.0,
                        "../img/insects/mariquitas.jpg",
                        90, // unitsPackage
                        LocalDate.parse("2020-09-20")
                ),
                new Product(
                        "Mosca soldado negra",
                        "Hermetia illucens",
                        "Utilizada para control de desechos orgánicos y biológicos, sus larvas degradan residuos y reducen proliferación de plagas.",
                        110000.0,
                        "../img/insects/mosca-soldado-negra.jpg",
                        100, // unitsPackage
                        LocalDate.parse("2020-09-20")
                ),
                new Product(
                        "Escarabajo tigre",
                        "Calosoma sycophanta",
                        "Se alimenta de orugas, procesionaria del pino y otras plagas forestales, siendo útil en ambientes al aire libre.",
                        110000.0,
                        "../img/insects/escarabajo-tigre.jpg",
                        100, // unitsPackage
                        LocalDate.parse("2020-09-20")
                ),
                new Product(
                        "Moscas depredadoras",
                        "Aphidoletes aphidimyza",
                        "Se especializan en atacar pulgones, inyectándoles una toxina paralizante antes de alimentarse de ellos.",
                        150000.0,
                        "../img/insects/mosca-depredadora.jpg",
                        120, // unitsPackage
                        LocalDate.parse("2020-09-20")
                ),
                new Product(
                        "Chinche pirata diminuta",
                        "Orius insidiosus",
                        "Depredador eficaz contra trips, ácaros y pulgones. Funciona en cultivos con flores de polen, como los ornamentales.",
                        200000.0,
                        "../img/insects/chinche-pirata.jpg",
                        50, // unitsPackage
                        LocalDate.parse("2020-09-20")
                ),
                new Product(
                        "Escarabajo terrestre",
                        "Pterostichus melanarius",
                        "Depredador eficaz contra babosas, orugas y otras plagas de suelo. Ideal para cultivos al aire libre.",
                        100000.0,
                        "../img/insects/escarabajo-terrestre.jpg",
                        20, // unitsPackage
                        LocalDate.parse("2020-09-20")
                ),
                new Product(
                        "Escarabajo depredador",
                        "cryptolaemus montrouzieri",
                        "Utilizado en cultivos de frutas y hortalizas. Eficaz contra el combate de cochinillas algodonosas.",
                        240000.0,
                        "../img/insects/escarabajo-depredador.jpg",
                        50, // unitsPackage
                        LocalDate.parse("2020-09-20")
                )
        };
        iProductRepository.saveAll(Arrays.asList(products));

        User[] usersList = {
                new User("customer", "Juan","Peréz",
                        "juan@gmail.com", "Juan123*"),
                new User("customer", "Sebastián","Loaiza",
                        "seba@gmail.com", "Seba123*"),
                new User("customer", "Freddy", "Risquez",
                        "freddy@gmail.com", "Fred000*"),
                new User("customer", "Susana","Villarroel",
                        "susan@gmail.com", "Susy1214*"),
                new User("customer", "Oriana","Camargo",
                        "ori@gmail.com", "Ori2000*"),
                new User("admin", "Scarllett","Johansson",
                        "sca007@gmail.com", "Hermosa12*"),
        };
    iUserRepository.saveAll(Arrays.asList(usersList));
//
//// Crear instancias de usuarios y productos (ya existen en iUserRepository y iProductRepository)
//        User user1 = iUserRepository.findById(1L).orElseThrow();
//        User user2 = iUserRepository.findById(2L).orElseThrow();
//        User user3 = iUserRepository.findById(3L).orElseThrow();
//
//        Product product1 = iProductRepository.findById(1L).orElseThrow();
//        Product product2 = iProductRepository.findById(2L).orElseThrow();
//        Product product3 = iProductRepository.findById(3L).orElseThrow();
//        Product product4 = iProductRepository.findById(4L).orElseThrow();
//        Product product5 = iProductRepository.findById(5L).orElseThrow();
//        Product product6 = iProductRepository.findById(6L).orElseThrow();
//
//// Crear los OrderDetail para cada orden
//        List<OrderDetail> orderDetails1 = Arrays.asList(
//                new OrderDetail(null, product1.getIdProduct(), 2, product1.getPrice(), null),
//                new OrderDetail(null, product2.getIdProduct(), 1, product2.getPrice(), null),
//                new OrderDetail(null, product3.getIdProduct(), 3, product3.getPrice(), null)
//        );
//
//        List<OrderDetail> orderDetails2 = Arrays.asList(
//                new OrderDetail(null, product4.getIdProduct(), 2, product4.getPrice(), null),
//                new OrderDetail(null, product5.getIdProduct(), 1, product5.getPrice(), null),
//                new OrderDetail(null, product6.getIdProduct(), 2, product6.getPrice(), null)
//        );
//
//        List<OrderDetail> orderDetails3 = Arrays.asList(
//                new OrderDetail(null, product1.getIdProduct(), 1, product1.getPrice(), null),
//                new OrderDetail(null, product3.getIdProduct(), 2, product3.getPrice(), null),
//                new OrderDetail(null, product5.getIdProduct(), 3, product5.getPrice(), null)
//        );
//
//// Crear las órdenes y asignarles los usuarios y detalles
//        Order[] orders = {
//                new Order(null, LocalDate.of(2024, 11, 1), 10, null, null, user1, new ArrayList<>(orderDetails1)),
//                new Order(null, LocalDate.of(2024, 11, 2), 15, null, null, user2, new ArrayList<>(orderDetails2)),
//                new Order(null, LocalDate.of(2024, 11, 3), 5, null, null, user3, new ArrayList<>(orderDetails3))
//        };
//
//// Asignar cada OrderDetail a su respectiva orden
//        for (OrderDetail detail : orderDetails1) {
//            detail.setOrder(orders[0]);
//        }
//        for (OrderDetail detail : orderDetails2) {
//            detail.setOrder(orders[1]);
//        }
//        for (OrderDetail detail : orderDetails3) {
//            detail.setOrder(orders[2]);
//        }
//
//// Calcular subtotal y total para cada orden
//        for (Order order : orders) {
//            order.calculateSubTotal();
//            order.calculateTotal(order.getDiscount());
//        }
//
//// Guardar las órdenes en la base de datos
//        iOrderRepository.saveAll(Arrays.asList(orders));
//
    }
}
