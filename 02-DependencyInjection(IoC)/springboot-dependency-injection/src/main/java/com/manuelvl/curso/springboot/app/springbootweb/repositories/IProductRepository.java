package com.manuelvl.curso.springboot.app.springbootweb.repositories;

import com.manuelvl.curso.springboot.app.springbootweb.models.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    Product findById(Long id);
}
