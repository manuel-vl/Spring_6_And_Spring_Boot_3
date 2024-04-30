package com.manuelvl.curso.springboot.webapp.springbootweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
// Podemos agregar varios archivos .properties
@PropertySources({
        // Agregando el archivo values.properties
        @PropertySource("classpath:values.properties")
})
public class ValuesConfig {
}
