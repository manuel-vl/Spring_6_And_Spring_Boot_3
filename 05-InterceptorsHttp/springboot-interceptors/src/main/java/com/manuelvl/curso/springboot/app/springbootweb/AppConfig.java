package com.manuelvl.curso.springboot.app.springbootweb;

import com.manuelvl.curso.springboot.app.springbootweb.interceptors.LoadingTimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {
    // Inyectando el interceptor
    @Autowired
    @Qualifier("loadingTimeInterceptor")
    private HandlerInterceptor timeInterceptor;


    // Registrando el interceptor para todas las rutas del controlador
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Inyectando el interceptor (.addPathPatterns - para rutas especificas)
        //registry.addInterceptor(timeInterceptor).addPathPatterns("/api/v1/foo");
        // Cualquier ruta dentro de api/v1
        registry.addInterceptor(timeInterceptor).addPathPatterns("/api/v1/**");
        // Excluyendo rutas
        //registry.addInterceptor(timeInterceptor).excludePathPatterns("/api/v1/baz");
        // Para todas las rutas
        // registry.addInterceptor(timeInterceptor)
    }
}
