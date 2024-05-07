package com.manuelvl.curso.springboot.app.springbootweb.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
        super(message);
    }
}
