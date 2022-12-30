package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Role;
import com.springdatajpa.springboot.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ManyToManyBidirectionalTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    void saveRole(){
        User user = new User();
        user.setFirstName("Raushan");
        user.setLastName("Kumar");
        user.setEmail("raushan@gmail.com");
        user.setPassword("abcd");

        User user1 = new User();
        user1.setFirstName("Shivam");
        user1.setLastName("Kumar");
        user1.setEmail("shivam@gmail.com");
        user1.setPassword("abcde");

        Role roleadmin = new Role();
        roleadmin.setName("ROLE_ADMIN");

        roleadmin.getUsers().add(user);
        roleadmin.getUsers().add(user1);

        user.getRoles().add(roleadmin);
        user1.getRoles().add(roleadmin);

        roleRepository.save(roleadmin);
    }


    @Test
    void fetchRole(){
        List<Role> roles = roleRepository.findAll();
        roles.forEach((r) ->{
            System.out.println(r.getName());

            r.getUsers().forEach((u) ->{
                System.out.println(u.getFirstName());
            });
        });
    }
}
