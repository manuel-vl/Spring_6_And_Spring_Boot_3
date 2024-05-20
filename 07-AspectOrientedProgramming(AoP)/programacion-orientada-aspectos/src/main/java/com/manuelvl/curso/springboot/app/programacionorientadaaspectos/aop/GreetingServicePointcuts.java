package com.manuelvl.curso.springboot.app.programacionorientadaaspectos.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// Aspect es una funcionalidad que se repite mucho y la queremos desacoplar de nuestra aplicacion. Es a modo de interceptor
// y se ejecuta antes o despues de cierta funcion.
@Component
@Aspect
public class GreetingServicePointcuts {
    // Metodo para definir el punto de corte, es decir el metodo, clase o package a interceptar
    @Pointcut("execution(* com.manuelvl.curso.springboot.app.programacionorientadaaspectos.services.*.*(..))")
    public void greetingLoggerPointCut(){
    }

    @Pointcut("execution(* com.manuelvl.curso.springboot.app.programacionorientadaaspectos.services.*.*(..))")
    public void greetingFooLoggerPointCut(){
    }
}
