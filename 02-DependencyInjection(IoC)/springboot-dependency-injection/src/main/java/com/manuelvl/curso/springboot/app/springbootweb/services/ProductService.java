package com.manuelvl.curso.springboot.app.springbootweb.services;

import com.manuelvl.curso.springboot.app.springbootweb.models.Product;
import com.manuelvl.curso.springboot.app.springbootweb.repositories.IProductRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductService implements IProductService{
    // Accediendo a la variable de configuracion price.tax
    @Value("${config.price.tax}")
    private Double priceTax;

    // Permite acceder a la variable de configuracion price.tax mediante environment
    @Autowired
    private Environment environment;


    @Autowired
    @Qualifier("productRepositoryMethodJson")
    private IProductRepository repository;

    //public ProductService(@Qualifier("product2Repository") IProductRepository repository) {
    //    this.repository = repository;
    //}

    @Override
    public List<Product> findAll() {
        System.out.println(priceTax);
        Double priceTaxEnv=environment.getProperty("config.price.tax", Double.class);
        System.out.println(priceTaxEnv);
        return repository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }
}
