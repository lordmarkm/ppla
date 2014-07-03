package com.ppla.web.config;

import javax.annotation.PostConstruct;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ppla.app.models.PplaSalesOrder;
import com.ppla.core.dto.PplaSalesOrderInfo;

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

    @Autowired
    private DozerBeanMapper mapper;

    @PostConstruct
    public void init() {
        mapper.addMapping(new BeanMappingBuilder() {
            @Override
            protected void configure() {
                mapping(PplaSalesOrderInfo.class, PplaSalesOrder.class)
                    .fields("orderItems", "items");
            }
        });
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable(); 
    }

}
