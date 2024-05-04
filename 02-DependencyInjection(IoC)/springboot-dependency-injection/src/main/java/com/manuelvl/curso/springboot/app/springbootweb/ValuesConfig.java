package com.manuelvl.curso.springboot.app.springbootweb;

import com.manuelvl.curso.springboot.app.springbootweb.repositories.IProductRepository;
import com.manuelvl.curso.springboot.app.springbootweb.repositories.ProductRepositoryJson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.io.Resource;

@Configuration
// Podemos agregar varios archivos .properties
@PropertySources({
        // Agregando el archivo config.properties
        @PropertySource("classpath:config.properties")
})
public class ValuesConfig {

    @Value("classpath:product.json")
    private Resource resource;

    // Aca estamos retornando una instancia de la clase ProductRepositoryJson
    // Registramos el metodo como componente de Spring
    @Bean
    public IProductRepository productRepositoryMethodJson(){
        return new ProductRepositoryJson(resource);
    }
}
