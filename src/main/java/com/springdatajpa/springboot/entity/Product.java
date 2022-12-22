package com.springdatajpa.springboot.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

//@NamedQuery(
//        name = "Product.findByPrice",
//       // query = "SELECT p from Product p where p.price = ?1" //index parameter
//        query = "SELECT p from Product p where p.price = :price"  //named parameter
//)

@NamedQueries(
        {
                @NamedQuery(
                        name = "Product.findAllOrderByNameDesc",
                        query = "SELECT p from Product p ORDER By p.name DESC"
                ),
                @NamedQuery(
                        name = "Product.findByPrice",
                        query = "SELECT p from Product p where p.price = :price"  //named parameter
                )
        }
)

//@NamedNativeQuery(
//        name = "Product.findByDescription",
//        query = "select * from products p where p.description = :description",
//        resultClass = Product.class
//)


@NamedNativeQueries(
        {
                @NamedNativeQuery(
                        name = "Product.findByDescription",
                        query = "select * from products p where p.description = :description",
                        resultClass = Product.class
                ),
                @NamedNativeQuery(
                        name = "Product.findAllOrderByNameASC",
                        query = "select * from products order by name asc",
                        resultClass = Product.class
                )

        }
)

@Table(
        name = "products",
        schema = "ecommece_u",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "sku_unique",
                        columnNames = "stock_keeping_unit"
                )
        }
)
public class Product {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_generator"
    )

    @SequenceGenerator(
            name = "product_generator",
            sequenceName = "product_sequence_name",
            allocationSize = 1
    )
    private long id;

    @Column(name = "stock_keeping_unit", nullable = false)
    private String sku; //stock keeping unit

    @Column(nullable = false)
    private String name;
    private String description;
    private BigDecimal price;
    private boolean active;
    private String imageUrl;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime lastUpdated;
}
