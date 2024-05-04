package com.manuelvl.curso.springboot.app.springbootfacturaciondependencyinjection.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ItemInvoice {
    Product product;
    Integer quantity;

    public double getImporte(){
        return quantity*product.getPrice();
    }
}
