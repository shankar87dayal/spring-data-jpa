package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JPQLQueriesTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameOrDescriptionJPQLIndexParamMethod(){
        Product product = productRepository.findByNameOrDescriptionJPQLIndexParam("Iphone 14 pro max",
                "this the best mobile phone");

        System.out.println(product.getId());
        System.out.println(product.getName());
    }

    @Test
    void  findByNameOrDescriptionJPQLNamedParamMethod(){
        Product product = productRepository.findByNameOrDescriptionJPQLNamedParam("Iphone 14 pro max",
                "this the best mobile phone");

        System.out.println(product.getId());
        System.out.println(product.getName());
    }
}
