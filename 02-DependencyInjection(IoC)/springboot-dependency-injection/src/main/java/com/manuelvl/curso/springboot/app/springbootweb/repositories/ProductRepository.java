package com.manuelvl.curso.springboot.app.springbootweb.repositories;

import com.manuelvl.curso.springboot.app.springbootweb.models.Product;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRepository implements IProductRepository{
    List<Product> data;

    public ProductRepository(List<Product> data) {
        this.data = Arrays.asList(
                new Product(1L, "RAM 32GB", 300L),
                new Product(2L, "Intel ICore9", 1000L),
                new Product(3L, "Keyboard Razer", 500L),
                new Product(4L, "Motherboard Gigabyte", 900L)
        );
    }

    @Override
    public List<Product> findAll() {
        return data;
    }

    @Override
    public Product findById(Long id) {
        return data.stream().filter(p->p.getId().equals(id)).findFirst().orElse(null);
    }
}
