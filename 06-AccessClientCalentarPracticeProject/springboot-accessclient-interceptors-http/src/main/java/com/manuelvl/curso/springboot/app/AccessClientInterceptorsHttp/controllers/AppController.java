package com.manuelvl.curso.springboot.app.AccessClientInterceptorsHttp.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class AppController {
    @GetMapping("/foo")
    public ResponseEntity<?> foo(HttpServletRequest request){
        Map<String, Object> data=new HashMap<>();
        data.put("title","Bienvenidos al sistema de atencion!");
        data.put("time", new Date());
        // Este dato lo estamos seteando en el interceptor (pre)
        data.put("message", request.getAttribute("message"));

        return ResponseEntity.ok(data);
    }
}
