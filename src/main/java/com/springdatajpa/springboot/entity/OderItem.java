package com.springdatajpa.springboot.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "order_items")
public class OderItem {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String imageUrl;
    private BigDecimal price;
    private int quentity;
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

}
