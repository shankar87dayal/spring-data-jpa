package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod(){
        //create product
        Product product = new Product();
        product.setName("Iphone 14 pro max");
        product.setDescription("this the best mobile phone");
        product.setSku("1001ABC");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("product.png");
        //save product
        Product savedProduct =  productRepository.save(product);
        //display products information
        System.out.println(savedProduct.getId());
        System.out.println(savedProduct.toString());


    }

    @Test
    void updateUsingSaveMethod(){

        //find or retrieve an entity by id

        Long id = 3L;
        Product product = productRepository.findById(id).get();
        //update entity information
        product.setName("HP i7 11gen");
        product.setDescription("This is the latest lappy");

        //saved the updated entity
        productRepository.save(product);


    }

    @Test
    void findByIdMethod(){
        Long id = 3L;
        Product product = productRepository.findById(id).get();

    }

    @Test
    void saveAllMethod(){
        //create product
        Product product1 = new Product();
        product1.setName("product1");
        product1.setDescription("product1 description");
        product1.setSku("1001ABCD");
        product1.setPrice(new BigDecimal(200));
        product1.setActive(true);
        product1.setImageUrl("product1.png");

        //create product
        Product product2 = new Product();
        product2.setName("product2");
        product2.setDescription("product2 description");
        product2.setSku("1001ABCDE");
        product2.setPrice(new BigDecimal(300));
        product2.setActive(true);
        product2.setImageUrl("product2.png");

        productRepository.saveAll(List.of(product1,product2));
    }

    @Test
    void findAllMethod(){
        List<Product> products = productRepository.findAll();
        products.forEach((p) -> {
            System.out.println(p.getName());
        });
    }

    @Test
    void deleteByIdMethod(){
        Long id = 5L;
        productRepository.deleteById(id);
    }

    @Test
    void deleteMethod(){

        //find an entity by id
        Long id = 4L;
        Product product = productRepository.findById(id).get();

        //delete (entity)
        productRepository.delete(product);
    }

    @Test
    void deleteAllMethod(){

        productRepository.deleteAll();
    }

    @Test
    void deleteAllUsingIterableMethod(){

        Product product = productRepository.findById(8L).get();

        Product product1 = productRepository.findById(9L).get();

        productRepository.deleteAll(List.of(product, product1));
    }

    @Test
    void countMethod(){
        long count = productRepository.count();
        System.out.println(count);
    }

    @Test
    void existsByIdMethod(){

        Long id = 10L;

        boolean result = productRepository.existsById(id);
        System.out.println(result);
    }
}