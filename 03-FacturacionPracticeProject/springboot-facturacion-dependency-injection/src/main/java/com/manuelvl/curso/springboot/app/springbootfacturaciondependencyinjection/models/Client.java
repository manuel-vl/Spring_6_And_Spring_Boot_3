package com.manuelvl.curso.springboot.app.springbootfacturaciondependencyinjection.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
// Permite usar las notaciones de Spring ya que lo agregamos dentro del contexto
@Component
@RequestScope
// Ignorando errores
//@JsonIgnoreProperties({"targetSource", "advisors"})
public class Client {
    // Accediendo a los values de las variables del archivo properties

    @Value("${client.name}")
    String name;

    @Value("${client.lastname}")
    String lastname;
}
