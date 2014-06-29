package com.ppla.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {
    "com.baldy.commons.web.config",
    "com.baldy.commons.resourcedoc.config",
    "com.ppla.app.config",
    "com.ppla.core.config",
    "com.ppla.web.resource",
    "com.ppla.web.controller"
})
@PropertySource({"classpath:app.properties"})
@EnableAspectJAutoProxy
public class PplaWebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable(); 
    }

}
