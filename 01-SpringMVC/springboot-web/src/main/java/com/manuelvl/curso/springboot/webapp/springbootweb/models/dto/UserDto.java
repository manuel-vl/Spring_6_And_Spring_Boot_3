package com.manuelvl.curso.springboot.webapp.springbootweb.models.dto;

import com.manuelvl.curso.springboot.webapp.springbootweb.models.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto {
    String title;
    User user;
}
