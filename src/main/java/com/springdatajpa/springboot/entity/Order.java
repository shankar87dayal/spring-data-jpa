package com.springdatajpa.springboot.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

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

    //default fetch type for ont to many is LAZY

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "order")

    private Set<OderItem> oderItems = new HashSet<>();

    public BigDecimal getTotalAmount(){
        BigDecimal amount = new BigDecimal(0.0);
        for (OderItem items : this.oderItems){
            amount = amount.add(items.getPrice());
        }
        return amount;
    }
}
