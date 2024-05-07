package com.manuelvl.curso.springboot.app.springbootweb.services;

import com.manuelvl.curso.springboot.app.springbootweb.exceptions.UserNotFoundException;
import com.manuelvl.curso.springboot.app.springbootweb.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{
    @Autowired
    private List<User> users;

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado"))
        );
    }
}
