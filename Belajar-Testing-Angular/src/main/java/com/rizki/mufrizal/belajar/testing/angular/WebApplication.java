package com.rizki.mufrizal.belajar.testing.angular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class WebApplication extends WebMvcConfigurerAdapter{

    public static void main(String[]args){
        SpringApplication.run(WebApplication.class);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("/");
        registry.addResourceHandler("/app/**").addResourceLocations("/app/");
        registry.addResourceHandler("/images/**").addResourceLocations("/app/images/");
        registry.addResourceHandler("/scripts/**").addResourceLocations("/app/scripts/");
        registry.addResourceHandler("/styles/**").addResourceLocations("/app/styles/");
        registry.addResourceHandler("/views/**").addResourceLocations("/app/views/");
    }
}