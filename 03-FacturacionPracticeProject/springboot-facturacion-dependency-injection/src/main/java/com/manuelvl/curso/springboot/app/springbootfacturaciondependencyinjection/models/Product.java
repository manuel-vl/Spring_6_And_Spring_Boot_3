package com.manuelvl.curso.springboot.app.springbootfacturaciondependencyinjection.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    String name;
    Double price;
}
