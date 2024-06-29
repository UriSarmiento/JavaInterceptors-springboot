package com.uriel.springboot.app.interceptor.springboot_interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer{

    @Autowired
    @Qualifier("timeInterceptor") //Usamos el calificador para inyectar especificamente el que creamos
    private HandlerInterceptor timeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(timeInterceptor); 
        
        // Se puede utilizar addPaterns para loggear solo rutas especificas
        // registry.addInterceptor(timeInterceptor).addPathPatterns("/app/bar","/app/foo");
        // registry.addInterceptor(timeInterceptor).addPathPatterns("/app/**"); // Ejecuta en todo lo que este en app
        
        //Con exclude se ejecuta en todas menos en las excluidas
        registry.addInterceptor(timeInterceptor).excludePathPatterns("/app/bar");
   
    }
    
}
