package com.manuelvl.curso.springboot.app.springbootweb;

import com.manuelvl.curso.springboot.app.springbootweb.models.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    List<User> users() {
        return Arrays.asList(
                new User(1l,"Manuel","Valencia"),
                new User(2l,"Carlos", "Londono")
        );
    }
}
