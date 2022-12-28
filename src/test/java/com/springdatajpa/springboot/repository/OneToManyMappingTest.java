package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Address;
import com.springdatajpa.springboot.entity.OderItem;
import com.springdatajpa.springboot.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OneToManyMappingTest {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    //save order along with also save it's order items
    @Test
    void saveOrderMethod(){
        Order order = new Order();
        order.setOrderTrackingNumber("100AB");
        order.setStatus("IN PROGRESS");

        //create order item 1
        OderItem oderItem1 = new OderItem();
        oderItem1.setProduct(productRepository.findById(1L).get());
        oderItem1.setQuentity(2);
        oderItem1.setPrice(oderItem1.getProduct().getPrice().multiply(new BigDecimal(2)));
        oderItem1.setImageUrl("image1.png");
        order.getOderItems().add(oderItem1);

        //create order item 2
        OderItem oderItem2 = new OderItem();
        oderItem2.setProduct(productRepository.findById(2L).get());
        oderItem2.setQuentity(3);
        oderItem2.setPrice(oderItem2.getProduct().getPrice().multiply(new BigDecimal(3)));
        oderItem2.setImageUrl("image2.png");
        order.getOderItems().add(oderItem2);

        order.setTotalPrice(order.getTotalAmount());
        order.setTotalQuentity(2);

        Address address = new Address();
        address.setCountry("India");
        address.setState("Bihar");
        address.setCity("Madhubani");
        address.setStreet("Harlakhi");
        address.setZipCode("847240");

        order.setBillingAddress(address);

        orderRepository.save(order);

    }

    @Test
    void fetchOrderMethod(){
        Order order = orderRepository.findById(1L).get();
        System.out.println(order.getStatus());
        System.out.println(order.toString());
        for (OderItem item : order.getOderItems()){
            System.out.println(item.getProduct().getName());
        }

    }

    @Test
    void deleteOrderMethod(){
        orderRepository.deleteById(1L);
    }
}
