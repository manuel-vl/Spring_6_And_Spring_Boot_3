package com.manuelvl.curso.springboot.app.springbootweb.services;

import com.manuelvl.curso.springboot.app.springbootweb.models.Product;
import com.manuelvl.curso.springboot.app.springbootweb.repositories.IProductRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductService implements IProductService{
    @Autowired
    @Qualifier("product2Repository")
    private IProductRepository repository;

    //public ProductService(@Qualifier("product2Repository") IProductRepository repository) {
    //    this.repository = repository;
    //}

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }
}
