package com.manuelvl.curso.springboot.app.springbootweb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class AppController {
    @GetMapping("/foo")
    public Map<String, String> foo(){
        return Collections.singletonMap("message","handler foo controlador");
    }

    @GetMapping("/bar")
    public Map<String, String> bar(){
        return Collections.singletonMap("message","handler bar controlador");
    }

    @GetMapping("/baz")
    public Map<String, String> baz(){
        return Collections.singletonMap("message","handler baz controlador");
    }
}
