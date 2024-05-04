package com.manuelvl.curso.springboot.app.springbootweb.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.manuelvl.curso.springboot.app.springbootweb.models.Product;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

// No le agregamos @Repository ya que estamos creando una funcion que retorna una instancia de esta clase y el metodo
// que lo hace es un @Bean, lo cual lo convierte en un componente de Spring
public class ProductRepositoryJson implements IProductRepository{
    private List<Product> list;

    public ProductRepositoryJson() {
        // Obteniendo el resource a leer
        Resource resource=new ClassPathResource("product.json");
        readValueJson(resource);
    }

    public ProductRepositoryJson(Resource resource) {
        // Aca obtenemos el resource a leer desde el archivo ValuesConfig
        readValueJson(resource);
    }

    private void readValueJson(Resource resource){
        // Permite convertir un archivo o input string a un objeto de Java
        ObjectMapper objectMapper=new ObjectMapper();

        try {
            list= Arrays.asList(objectMapper.readValue(resource.getInputStream(), Product[].class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> findAll() {
        return list;
    }

    @Override
    public Product findById(Long id) {
        return list.stream().filter(product -> product.getId().equals(id)).findFirst().orElse(null);
    }
}
