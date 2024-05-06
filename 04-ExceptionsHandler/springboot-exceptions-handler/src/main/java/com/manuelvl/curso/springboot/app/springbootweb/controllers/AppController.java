package com.manuelvl.curso.springboot.app.springbootweb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AppController {
    @GetMapping("")
    public String index(){
        return "ok 200";
    }
}
