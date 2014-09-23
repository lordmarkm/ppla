package com.ppla.quickbooks.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ppla.quickbooks.ws.endpoint.PplaQuickbooksWsEndpoint;

/**
 * @author Mark
 */
@Configuration
@ComponentScan("com.ppla.quickbooks")
@ImportResource({"classpath:META-INF/cxf/cxf.xml"})
@EnableJpaRepositories(basePackages = {
    "com.ppla.quickbooks.service"
}, repositoryImplementationPostfix = "CustomImpl")
public class PplaQBWebconnectorConfig {

    private static Logger LOG = LoggerFactory.getLogger(PplaQBWebconnectorConfig.class);

    @Autowired
    private Bus cxfBus;

    @Autowired
    private PplaQuickbooksWsEndpoint service;

    @Bean
    public Endpoint qbEndpoint() {
        LOG.debug("Initializing endpoint. bus={}, service={}", cxfBus, service);
        EndpointImpl endpt = new EndpointImpl(cxfBus, service);
        endpt.setAddress("/PplaQbService");
        endpt.publish();

        //Trying to set this to null because of permgen exception
        cxfBus = null;

        return endpt;
    }

//    Use this for non-embedded ws (note different port)
//    @Bean
//    public SimpleJaxWsServiceExporter simpleJaxWsServiceExporter() {
//        //http://localhost:8081/ItemQueryRqSoapImpl
//        SimpleJaxWsServiceExporter sjse = new SimpleJaxWsServiceExporter();
//        sjse.setBaseAddress("http://localhost:8080/qbendpt/");
//        return sjse;
//    }

}
