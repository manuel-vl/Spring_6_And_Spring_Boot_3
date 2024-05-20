package com.manuelvl.curso.springboot.app.programacionorientadaaspectos.services;

public interface IGreetingService {
    String sayHello(String person, String phrase);
    String sayHelloError(String person, String phrase);
}
