package com.manuelvl.curso.springboot.app.AccessClientInterceptorsHttp.interceptors;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class CalendarInterceptor implements HandlerInterceptor {
    @Value("${config.calendar.open}")
    private Integer open;

    @Value("${config.calendar.close}")
    private Integer close;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Calendar calendar= Calendar.getInstance();

        int hour=calendar.get(Calendar.HOUR_OF_DAY);

        if(hour>=open && hour<=close){
            StringBuilder message=new StringBuilder("Bienvenidos al horario de atencion a clientes");
            message.append(", atendemos desde las ");
            message.append(open);
            message.append(" hasta las ");
            message.append(close);
            message.append(" Gracias por su visita");

            request.setAttribute("message", message.toString());

            return true;
        }

        ObjectMapper mapper=new ObjectMapper();

        Map<String, Object> data=new HashMap<>();
        StringBuilder message=new StringBuilder("Cerrado, fuera del horario de atencion a clientes.");
        message.append(", visitenos desde las ");
        message.append(open);
        message.append(" hasta las ");
        message.append(close);

        data.put("message",message.toString());
        data.put("date", new Date().toString());

        // Convirtiendo en JSON
        response.setContentType("application/json");
        response.setStatus(401);
        response.getWriter().write(mapper.writeValueAsString(data));

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
}
