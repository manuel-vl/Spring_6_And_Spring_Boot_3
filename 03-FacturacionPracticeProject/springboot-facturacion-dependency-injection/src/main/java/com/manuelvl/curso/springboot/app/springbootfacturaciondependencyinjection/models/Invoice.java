package com.manuelvl.curso.springboot.app.springbootfacturaciondependencyinjection.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestScope
// Permite usar las notaciones de Spring ya que lo agregamos dentro del contexto
@Component
// Ignorando errores
// @JsonIgnoreProperties({"targetSource", "advisors"})
public class Invoice {
    // Inyectando el componente Client
    @Autowired
    Client client;

    // Accediendo a los values de las variables del archivo properties
    @Value("${invoice.description}")
    String description;

    // Inyectando el componente items que crear una lista de ItemInvoice
    @Autowired
    // Como tenemos 2 beans que retornan el mismo tipo, debemos agregar un @Qualifier o un @Primary donde se crea el metodo
    @Qualifier("itemsOffice")
    List<ItemInvoice> itemInvoices;

    // Se ejecuta luego de la construccion. A diferencia del constructor,
    // aca si tenemos acceso a los datos INYECTADOS
    @PostConstruct
    public void init(){
        System.out.println("Creando el componente de la factura");
        client.setName(client.getName().concat(" - Admin"));
        description=description.concat(" del cliente: ").concat(client.getName());
    }

    // Se ejecuta antes de destruir el bean. (Podemos eliminar datos, cerrar archivo, cerrar recursos, etc)
    // Para validar se debe tumbar el servidor
    @PreDestroy
    public void before(){
        System.out.println("Cerrando el archivo");
    }

    public double getTotal(){
       return itemInvoices.stream()
               .map(ItemInvoice::getImporte)
               .reduce((double) 0, Double::sum);
    }
}
