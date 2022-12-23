package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
public class PaginationAndSortingTest {

    @Autowired
    private ProductRepository productRepository;


    @Test
    void pagination(){

        int pageNo = 0;
        int pageSize = 5;

        //create pageable object

        Pageable pageable = PageRequest.of(pageNo,pageSize);

        //findAll method and pass pageable instance

        Page<Product> page = productRepository.findAll(pageable);

        List<Product> products = page.getContent();

        products.forEach((p) ->{
            System.out.println(p);
        });

        //total page
        int totalPage = page.getTotalPages();
        //total elements
        long totalElement =page.getTotalElements();

       // number of elements
        int numberOfElements = page.getNumberOfElements();

        //size
        int size = page.getSize();

        //last
        boolean isLast = page.isLast();

        //first
        boolean isFirst = page.isFirst();

        System.out.println("totalPage -> "+ totalPage);
        System.out.println("totalElement -> " +totalElement);
        System.out.println("numberOfElements -> "+ numberOfElements);
        System.out.println("size -> " + size);
        System.out.println("isLast -> "+ isLast);
        System.out.println("isFirst -> "+ isFirst);

    }

    @Test
    void sorting(){
        String sortBy = "price";
        String sortDir = "desc";
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?
                Sort.by(sortBy).ascending():Sort.by(sortBy).descending();

        List<Product> products = productRepository.findAll(sort);
        //one more way to find sort directions
        //By default it is in ascending order


        // List<Product> products = productRepository.findAll(Sort.by(sortBy));

        products.forEach((p) ->{
            System.out.println(p);
        });
    }
}
