package com.manuelvl.curso.springboot.app.programacionorientadaaspectos.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// Aspect es una funcionalidad que se repite mucho y la queremos desacoplar de nuestra aplicacion. Es a modo de interceptor
// y se ejecuta antes o despues de cierta funcion.
@Component
// Order permite establecer el orden de ejecucion de los aspectos
@Order(2)
@Aspect
public class GreetingAspect {
    // Logger para poder registrar eventos
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    // Indicamos el metodo, clase o package a interceptar (Aca se pueden manejar expresiones regulares)
    //@Before("execution(String com.manuelvl.curso.springboot.app.programacionorientadaaspectos.services.GreetingService.sayHello(..))")
    //@Before("execution(* com.manuelvl.curso.springboot.app.programacionorientadaaspectos.services.*.*(..))")
    @Before("GreetingServicePointcuts.greetingLoggerPointCut()")
    // JoinPoint une la ejecucion de un aspecto con el llamado a un metodo
    public void loggerBefore(JoinPoint joinPoint){
        // getSignatura se refiere a la firma del metodo
        String method=joinPoint.getSignature().getName();
        String args= Arrays.toString(joinPoint.getArgs());

        logger.info("Antes: "+method+" con los argumentos "+args);
    }

    // Indicamos el metodo, clase o package a interceptar (Aca se pueden manejar expresiones regulares)
    @After("GreetingServicePointcuts.greetingLoggerPointCut()")
    // JoinPoint une la ejecucion de un aspecto con el llamado a un metodo
    public void loggerAfter(JoinPoint joinPoint){
        // getSignatura se refiere a la firma del metodo
        String method=joinPoint.getSignature().getName();
        String args= Arrays.toString(joinPoint.getArgs());

        logger.info("Despues: "+method+" con los argumentos "+args);
    }

    // AfterReturning se ejecuta despues de retornar
    // Indicamos el metodo, clase o package a interceptar (Aca se pueden manejar expresiones regulares)
    @AfterReturning("GreetingServicePointcuts.greetingLoggerPointCut()")
    // JoinPoint une la ejecucion de un aspecto con el llamado a un metodo
    public void loggerAfterReturning(JoinPoint joinPoint){
        // getSignatura se refiere a la firma del metodo
        String method=joinPoint.getSignature().getName();
        String args= Arrays.toString(joinPoint.getArgs());

        logger.info("Despues Returning: "+method+" con los argumentos "+args);
    }

    // AfterThrowing se ejecuta despues de lanzar excepcion
    // Indicamos el metodo, clase o package a interceptar (Aca se pueden manejar expresiones regulares)
    @AfterThrowing("GreetingServicePointcuts.greetingLoggerPointCut()")
    // JoinPoint une la ejecucion de un aspecto con el llamado a un metodo
    public void loggerAfterThrowing(JoinPoint joinPoint){
        // getSignatura se refiere a la firma del metodo
        String method=joinPoint.getSignature().getName();
        String args= Arrays.toString(joinPoint.getArgs());

        logger.info("Despues Throwing: "+method+" con los argumentos "+args);
    }

    // Around nos permite acceder al resultado del metodo
    // Indicamos el metodo, clase o package a interceptar (Aca se pueden manejar expresiones regulares)
    @Around("GreetingServicePointcuts.greetingLoggerPointCut()")
    // ProceedingJoinPoint envuelve la ejecucion del metodo
    public Object loggerAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String method=joinPoint.getSignature().getName();
        String args=Arrays.toString(joinPoint.getArgs());

        Object result=null;

        try {
            logger.info("El metodo "+method+ "() con los parametros "+args);
            result=joinPoint.proceed();
            logger.info("El metodo "+method+"() retorna "+result);
            return result;
        } catch (Throwable e) {
            logger.error("Error en la llamada del metodo "+method+"()");
            throw e;
        }
    }
}
