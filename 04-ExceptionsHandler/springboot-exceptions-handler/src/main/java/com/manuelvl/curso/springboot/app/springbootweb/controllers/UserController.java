package com.manuelvl.curso.springboot.app.springbootweb.controllers;

import com.manuelvl.curso.springboot.app.springbootweb.models.User;
import com.manuelvl.curso.springboot.app.springbootweb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAll(){
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getById(@PathVariable Long id){
        Optional<User> user=userService.findById(id);

        return user;
    }
}
