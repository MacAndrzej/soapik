package com.andrzej.springbootsoapexample1.service;

import com.techprimers.spring_boot_soap_example.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author andrzej
 */
@Service
public class UserService {

    private static final Map<String, User> users = new HashMap<>();

    @PostConstruct
    public void initialize() {

        User peter = new User();
        peter.setName("Peter");
        peter.setEmpId(1);
        peter.setSalary(3000);
        users.put(peter.getName(),peter);
        User john = new User();
        john.setName("John");
        john.setEmpId(12);
        john.setSalary(3500);
        users.put(john.getName(),john);
        User robert = new User();
        robert.setName("Robert");
        robert.setEmpId(13);
        robert.setSalary(3500);
        users.put(robert.getName(),robert);
    }

    public User getUser(String name){
        return users.get(name);
    }
}
