package com.manuelvl.curso.springboot.app.springbootweb.repositories;

import com.manuelvl.curso.springboot.app.springbootweb.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Collections;
import java.util.List;

@Repository
// Indicando que el alcance del scope para el repositorio es de tipo request (Se crea la instancia por cada request)
@RequestScope
// Indicando que el alcance del scope para el repositorio es de tipo session (Se crea la instancia y dura hasta que se cierra el navegador o termina la session)
@SessionScope
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
