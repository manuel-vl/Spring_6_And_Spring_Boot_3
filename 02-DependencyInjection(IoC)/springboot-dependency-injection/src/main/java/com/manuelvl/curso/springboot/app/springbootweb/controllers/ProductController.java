package com.manuelvl.curso.springboot.app.springbootweb.controllers;

import com.manuelvl.curso.springboot.app.springbootweb.models.Product;
import com.manuelvl.curso.springboot.app.springbootweb.services.IProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final IProductService service;

    public ProductController(IProductService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<Product> products(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Product product(@PathVariable Long id){
        return service.findById(id);
    }
}
