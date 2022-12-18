package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {

    /*
    * Returns the found product entry by using its name as search
    * criteria. if no product entry is found, this method
    * returns null.
    * */
    public Product findByName(String name);


    /**
    * Return an optional which contains the found product
     * entry by using its id as search criteria. if no product entry
     * is found, this method returns an empty optional.
     *
     * */
    Optional<Product> findById(Long id);
}
