package com.manuelvl.curso.springboot.app.springbootweb.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    Long id;
    String name;
    Long price;
}
