package com.manuelvl.curso.springboot.app.springbootweb.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Error {
    String message;
    String error;
    int status;
    Date date;
}
