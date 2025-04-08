package oi.github.pedroMartinsMJ.librayapi2.config;

import oi.github.pedroMartinsMJ.librayapi2.Repository.*;
import oi.github.pedroMartinsMJ.librayapi2.entities.*;
import oi.github.pedroMartinsMJ.librayapi2.entities.enums.OrderStatus;
import oi.github.pedroMartinsMJ.librayapi2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;


@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    ProductService productService;

    @Override
    public void run(String... args) throws Exception {

    Product p1 = new Product("tv", 5000.00, 50);
    Product p2 = new Product("celular", 3000.00, 20);
    Product p3 = new Product("fralda", 59.99, 35);
    Product p4 = new Product("Xbox", 1500.00, 6);


    productService.findAll(Arrays.asList(p1, p2, p3, p4));

    }
}

