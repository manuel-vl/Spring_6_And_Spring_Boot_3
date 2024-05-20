package com.manuelvl.curso.springboot.app.programacionorientadaaspectos.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// Aspect es una funcionalidad que se repite mucho y la queremos desacoplar de nuestra aplicacion. Es a modo de interceptor
// y se ejecuta antes o despues de cierta funcion.
@Component
// Order permite establecer el orden de ejecucion de los aspectos
@Order(1)
@Aspect
public class FooAspect {
    // Logger para poder registrar eventos
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    // Indicamos el metodo, clase o package a interceptar (Aca se pueden manejar expresiones regulares)
    @Before("GreetingServicePointcuts.greetingFooLoggerPointCut()")
    // JoinPoint une la ejecucion de un aspecto con el llamado a un metodo
    public void loggerBefore(JoinPoint joinPoint){
        // getSignatura se refiere a la firma del metodo
        String method=joinPoint.getSignature().getName();
        String args= Arrays.toString(joinPoint.getArgs());

        logger.info("Antes Foo Aspect: "+method+" con los argumentos "+args);
    }
}
