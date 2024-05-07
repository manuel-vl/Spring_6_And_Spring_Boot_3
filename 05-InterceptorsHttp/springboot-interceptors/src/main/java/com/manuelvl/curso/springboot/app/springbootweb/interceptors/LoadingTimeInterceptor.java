package com.manuelvl.curso.springboot.app.springbootweb.interceptors;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component
public class LoadingTimeInterceptor implements HandlerInterceptor {
    private static final Logger logger= LoggerFactory.getLogger(LoadingTimeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod controller=((HandlerMethod) handler);
        // Logeando informacion
        logger.info("LoadingTimeInterceptor: preHandle() entrando... "+controller.getMethod().getName());

        // Almacenando tiempo actual en milisegundos
        long start=System.currentTimeMillis();
        request.setAttribute("start", start);

        // Generando aleatorio entre 0 y 500
        Random random=new Random();
        int delay=random.nextInt(500);

        // Simulando delay
        Thread.sleep(delay);

        // En caso de querer hacer validaciones y retornar false podemos hacer lo siguiente
        //Map<String, String> json=new HashMap<>();
        //json.put("error","No tienes acceso a esta pagina");
        //json.put("date", new Date().toString());

        //ObjectMapper mapper=new ObjectMapper();
        //String jsonString=mapper.writeValueAsString(json);
        //response.setContentType("application/json");
        //response.setStatus(401);
        //response.getWriter().write(jsonString);

        //return false;

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerMethod controller=((HandlerMethod) handler);
        long end=System.currentTimeMillis();
        long start= (long) request.getAttribute("start");

        // Calculando el tiempo que se demoro menos el tiempo en el que inicio la peticion
        long result=end-start;

        logger.info("Tiempo transcurrido: "+result);
        logger.info("LoadingTimeInterceptor: postHandle() saliendo... "+controller.getMethod().getName());
    }
}
