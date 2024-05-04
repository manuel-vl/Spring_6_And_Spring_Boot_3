package com.manuelvl.curso.springboot.app.springbootfacturaciondependencyinjection;

import com.manuelvl.curso.springboot.app.springbootfacturaciondependencyinjection.models.ItemInvoice;
import com.manuelvl.curso.springboot.app.springbootfacturaciondependencyinjection.models.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import java.util.Arrays;
import java.util.List;

@Configuration
// Podemos agregar varios archivos .properties
@PropertySources({
        @PropertySource("classpath:data.properties")
})
public class AppConfig {
    // Registramos los metodo como componente de Spring

    @Bean
    List<ItemInvoice> itemsAdventure(){
        Product p1=new Product("Camara", 1200d);
        Product p2=new Product("Bicicleta", 300d);

        return Arrays.asList(new ItemInvoice(p1, 3), new ItemInvoice(p2,1));
    }

    @Bean
    List<ItemInvoice> itemsOffice(){
        Product p1=new Product("Monitor ASUS", 400d);
        Product p2=new Product("Notebook Razer", 700d);
        Product p3=new Product("Impresora HP", 450d);
        Product p4=new Product("Desktop", 200d);

        return Arrays.asList(new ItemInvoice(p1, 3), new ItemInvoice(p2,3), new ItemInvoice(p3,2), new ItemInvoice(p4,4));
    }
}
