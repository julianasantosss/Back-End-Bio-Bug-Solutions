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

    }
}
