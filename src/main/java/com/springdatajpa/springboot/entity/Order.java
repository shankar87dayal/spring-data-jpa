package com.springdatajpa.springboot.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/*@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString*/ // you can use @Data annotation from lombok it is internally provide all these annotations.
@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String orderTrackingNumber;
    private int totalQuentity;
    private BigDecimal totalPrice;
    private String status;
    @CreationTimestamp
    private LocalDateTime orderCreated;

    @UpdateTimestamp
    private LocalDateTime lastUpdated;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "order")

    private Address billingAddress;
}
