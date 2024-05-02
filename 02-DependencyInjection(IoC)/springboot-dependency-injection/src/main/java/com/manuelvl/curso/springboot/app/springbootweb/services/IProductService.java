package com.manuelvl.curso.springboot.app.springbootweb.services;

import com.manuelvl.curso.springboot.app.springbootweb.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(Long id);
}
