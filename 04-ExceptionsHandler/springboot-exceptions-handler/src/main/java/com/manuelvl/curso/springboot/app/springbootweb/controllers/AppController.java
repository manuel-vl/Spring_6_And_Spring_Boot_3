package com.manuelvl.curso.springboot.app.springbootweb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AppController {
    @GetMapping("")
    public String index(){
        // int value=100/0;
        //int value=Integer.parseInt("1000");
        //System.out.println(value);
        return "ok 200";
    }
}
