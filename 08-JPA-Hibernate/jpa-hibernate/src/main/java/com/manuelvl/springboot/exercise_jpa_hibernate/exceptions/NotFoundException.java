package com.manuelvl.springboot.exercise_jpa_hibernate.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
