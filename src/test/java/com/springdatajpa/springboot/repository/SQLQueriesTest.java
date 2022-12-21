package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SQLQueriesTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameOrDescriptionSQLIndexParamMethod(){
        Product product = productRepository.findByNameOrDescriptionSQLIndexParam("Iphone 14 pro max",
                "this the best mobile phone");

        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByNameOrDescriptionSQLNamedParamMethod(){
        Product product = productRepository.findByNameOrDescriptionSQLNamedParam("Iphone 14 pro max",
                "this the best mobile phone");

        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());

    }
}
