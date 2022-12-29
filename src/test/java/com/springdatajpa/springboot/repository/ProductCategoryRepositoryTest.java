package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import com.springdatajpa.springboot.entity.ProductCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    void saveproductCategory(){

        ProductCategory pc1 = new ProductCategory();
        pc1.setCategoryName("Books");
        pc1.setCategoryDescription("Books descriptions");


        Product p1 = new Product();
        p1.setName("core java");
        p1.setDescription("core java books descriptions");
        p1.setSku("ABCD");
        p1.setPrice(new BigDecimal(1000));
        p1.setImageUrl("image1.png");
        p1.setActive(true);
        p1.setCategory(pc1);
        pc1.getProducts().add(p1);

        Product p2 = new Product();
        p2.setName("Effective java");
        p2.setDescription("Effective java books descriptions");
        p2.setSku("ABCDE");
        p2.setPrice(new BigDecimal(2000));
        p2.setImageUrl("image2.png");
        p2.setActive(true);
        p2.setCategory(pc1);
        pc1.getProducts().add(p2);

        productCategoryRepository.save(pc1);
    }

    /**
     * Here fetch type is lazy and in this type only can fetch main  contents.
     * not fetch associated content if not request.
     * the related content fetch on request and on demand else not.
     * here for fetch product add @Transactional and also add .getproducts then fetch related
     * content.
     */
    @Test
    @Transactional
    void fetchProductCategory(){
        ProductCategory category = productCategoryRepository.findById(1L).get();
        System.out.println(category.getProducts());
    }
}