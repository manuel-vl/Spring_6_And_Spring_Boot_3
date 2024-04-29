package com.manuelvl.curso.springboot.webapp.springbootweb.controllers;

import com.manuelvl.curso.springboot.webapp.springbootweb.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @GetMapping("/details")
    public static Map<String, Object> helloWorld(){
        User user=new User("Manuel", "Valencia");
        Map<String, Object> body=new HashMap<>();

        body.put("title", "Hello World!");
        body.put("user", user);

        return body;
    }
}
