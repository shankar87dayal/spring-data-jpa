package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class QueryMethodsTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameMethod(){
        Product product = productRepository.findByName("product1");

        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByIdMethod(){
        Product product = productRepository.findById(2L).get();

        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }


    @Test
    void findByNameOrDescriptionMethod(){
        List<Product> products = productRepository.findByNameOrDescription("product1", "product1 description");
        products.forEach((p) ->{
            System.out.println(p.getId());
            System.out.println(p.getName());

        });
    }

    @Test
    void findByNameAndDescriptionMethod(){
        List<Product> products = productRepository.findByNameAndDescription("product1", "product1 description");
        products.forEach((p) ->{
            System.out.println(p.getId());
            System.out.println(p.getName());

        });
    }

    @Test
    void findDistinctByNameMethod(){
        Product product = productRepository.findDistinctByName("product1");

        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());

    }


    @Test
    void findByPriceGreaterThanMethod(){
        List<Product> products = productRepository.findByPriceGreaterThan(new BigDecimal(100));
        products.forEach((p) ->{
            System.out.println(p.getId());
            System.out.println(p.getName());

        });
    }

    @Test
    void findByPriceLessThanMethod(){
        List<Product> products = productRepository.findByPriceLessThan(new BigDecimal(1000));
        products.forEach((p) ->{
            System.out.println(p.getId());
            System.out.println(p.getName());

        });
    }

    @Test
    void findByNameContainingMethod(){
        List<Product> products = productRepository.findByNameContaining("product1");
        products.forEach((p) ->{
            System.out.println(p.getId());
            System.out.println(p.getName());

        });
    }

    @Test
    void findByNameLikeMethod(){
        List<Product> products = productRepository.findByNameLike("product1");
        products.forEach((p) ->{
            System.out.println(p.getId());
            System.out.println(p.getName());

        });
    }

    @Test
    void findByPriceBetweenMethod(){
        List<Product> products = productRepository.findByPriceBetween(
                new BigDecimal(100), new BigDecimal(300)
        );
        products.forEach((p) ->{
            System.out.println(p.getId());
            System.out.println(p.getName());

        });
    }

    @Test
    void findByDateCreatedBetweenMethod(){
        //start date
        LocalDateTime startDate = LocalDateTime.of(2022,12,18,07,16,42);
        //end date
        LocalDateTime endDate = LocalDateTime.of(2022,12,19,06,8,54);

        List<Product> products = productRepository.findByDateCreatedBetween(startDate,endDate);
        products.forEach((p) ->{
            System.out.println(p.getId());
            System.out.println(p.getName());

        });

    }

    @Test
    void findByNameInMethod(){
        List<Product> products = productRepository.findByNameIn(List.of("product1","product2","Iphone 14 pro max"));

        products.forEach((p) ->{
            System.out.println(p.getId());
            System.out.println(p.getName());

        });
    }

    @Test
    void findFirst2ByOrderByNameAscMethod(){

        List<Product> products = productRepository.findFirst2ByOrderByNameAsc();

        products.forEach((p) ->{
            System.out.println(p.getId());
            System.out.println(p.getName());

        });
    }

    @Test
    void findTop2ByOrderByPriceDescMethod(){

        List<Product> products = productRepository.findTop2ByOrderByPriceDesc();

        products.forEach((p) ->{
            System.out.println(p.getId());
            System.out.println(p.getName());

        });

    }
}
