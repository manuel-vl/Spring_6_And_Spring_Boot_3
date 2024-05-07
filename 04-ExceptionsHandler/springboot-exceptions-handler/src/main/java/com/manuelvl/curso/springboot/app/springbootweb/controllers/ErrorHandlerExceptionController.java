package com.manuelvl.curso.springboot.app.springbootweb.controllers;

import com.manuelvl.curso.springboot.app.springbootweb.exceptions.UserNotFoundException;
import com.manuelvl.curso.springboot.app.springbootweb.models.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.nio.channels.NonWritableChannelException;
import java.util.Date;

@RestControllerAdvice
public class ErrorHandlerExceptionController {
    // Mapeando el tipo de excepcion a manipular
    @ExceptionHandler({ArithmeticException.class})
    public ResponseEntity<Error> divisionByZero(Exception ex){
        Error error=new Error();

        error.setDate(new Date());
        error.setError("Error division por cero");
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<Error> notFoundException(NoResourceFoundException ex){
        Error error=new Error(
                ex.getMessage(),
                "Error not found",
                HttpStatus.NOT_FOUND.value(),
                new Date()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<Error> numberFormatException(NumberFormatException ex){
        Error error=new Error(
                ex.getMessage(),
                "Error format number",
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new Date()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
    }

    @ExceptionHandler({NullPointerException.class, NonWritableChannelException.class, UserNotFoundException.class})
    public ResponseEntity<Error> userNotFoundException(Exception ex){
        Error error=new Error(
                ex.getMessage(),
                "Error el usuario no existe",
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new Date()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
    }
}
