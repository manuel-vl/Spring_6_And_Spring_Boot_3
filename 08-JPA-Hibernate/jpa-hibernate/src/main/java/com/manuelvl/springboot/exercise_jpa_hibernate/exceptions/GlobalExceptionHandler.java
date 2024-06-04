package com.manuelvl.springboot.exercise_jpa_hibernate.exceptions;

import com.manuelvl.springboot.exercise_jpa_hibernate.dtos.response.GenericResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFound(NotFoundException notFoundException){
        return new ResponseEntity<>(new GenericResponseDTO(notFoundException.getMessage()), HttpStatus.NOT_FOUND);
    }
}
