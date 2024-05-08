package com.manuelvl.curso.springboot.app.AccessClientInterceptorsHttp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {
    @Autowired
    @Qualifier("calendarInterceptor")
    HandlerInterceptor interceptorCalendar;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Se aplica solo a api/v1/foo
        registry.addInterceptor(interceptorCalendar).addPathPatterns("/api/v1/foo");
    }
}
