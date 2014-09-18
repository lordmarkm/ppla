package com.ppla.web.config;

import java.util.List;

import javax.annotation.PostConstruct;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.ppla.app.models.PplaSalesOrder;
import com.ppla.core.dto.PplaSalesOrderInfo;

@Configuration
@ComponentScan(basePackages = {
    "com.baldy.commons.web.config",
    "com.baldy.commons.resourcedoc.config",
    "com.ppla.app.config",
    "com.ppla.core.config",
    "com.ppla.web",

    //QB listener
    "com.cantero.quickbooks.ws",

    //only works with 'sec' profile
    "com.ppla.security.config"
})
@PropertySource({"classpath:app.properties"})
@EnableAspectJAutoProxy
public class PplaWebConfig extends WebMvcConfigurationSupport {
//extends WebMvcConfigurerAdapter {

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

    @Bean
    public SimpleJaxWsServiceExporter simpleJaxWsServiceExporter() {
        SimpleJaxWsServiceExporter sjse = new SimpleJaxWsServiceExporter();
        sjse.setBaseAddress("http://localhost:8081/");
        return sjse;
    }

    //Enable direct access to .html, .css, etc
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable(); 
    }

    //Override fail on unknown properties
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.addDefaultHttpMessageConverters(converters);
        for (HttpMessageConverter converter : converters) {
            if (converter instanceof MappingJackson2HttpMessageConverter) {
                ((MappingJackson2HttpMessageConverter) converter)
                    .getObjectMapper()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                    .registerModule(new JodaModule())
                        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                        .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            }
        }
    }
}
