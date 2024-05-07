package com.manuelvl.curso.springboot.app.springbootweb.services;

import com.manuelvl.curso.springboot.app.springbootweb.models.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> findAll();
    Optional<User> findById(Long id);
}
