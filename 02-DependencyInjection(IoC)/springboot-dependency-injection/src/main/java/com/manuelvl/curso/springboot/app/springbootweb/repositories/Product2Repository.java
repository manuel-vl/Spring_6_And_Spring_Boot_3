package com.manuelvl.curso.springboot.app.springbootweb.repositories;

import com.manuelvl.curso.springboot.app.springbootweb.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class Product2Repository implements IProductRepository{
    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L,"Monitor Asus", 900L));
    }

    @Override
    public Product findById(Long id) {
        return new Product(id,"Monitor Asus", 900L);
    }
}
