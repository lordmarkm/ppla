package com.ppla.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.ppla.app")
@EnableTransactionManagement
public class PplaMainConfig {

}
