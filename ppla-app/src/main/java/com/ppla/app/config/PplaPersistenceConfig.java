package com.ppla.app.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.ejb.HibernatePersistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.tyrael.commons.data.config.PersistenceConfig;

/**
 * @author Mark
 */
@Configuration
@EnableJpaRepositories(basePackages = {
    "com.ppla.app.services"
}, repositoryImplementationPostfix = "CustomImpl")
@PropertySource({"classpath:db.properties"})
public class PplaPersistenceConfig extends PersistenceConfig {

    @Resource
    private Environment env;

    @Bean
    public Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("javax.persistence.validation.mode", "NONE");//disable as it overrides model attrib validators

        //Enabled on purge profile
        String importFiles = env.getProperty("hibernate.hbm2ddl.import_files");
        if (null != importFiles) {
            properties.put("hibernate.hbm2ddl.import_files", importFiles);
        }

        return properties;
    }

    @Override
    @Bean
    public DataSource dataSource() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(env.getProperty("jpa.driverClass"));
        dataSource.setJdbcUrl(env.getProperty("jpa.url"));
        dataSource.setUser(env.getProperty("jpa.username"));
        dataSource.setPassword(env.getProperty("jpa.password"));

        //c3p0-specific properties follow
        dataSource.setAcquireIncrement(1);
        dataSource.setMinPoolSize(2);
        dataSource.setMaxPoolSize(5);
        dataSource.setMaxIdleTime(600);

        return dataSource;
    }

    @Override
    @Bean
    public EntityManagerFactory entityManagerFactory() throws Exception {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.setPackagesToScan(new String[] {
            "com.ppla.app.models",
            "com.ppla.app.models.process",
            "com.tyrael.process.mgt.models.product",
            "com.baldy.commons.security.models",

            //is there any way to put this in the quickbooks module instead?
            "com.ppla.quickbooks.entity"
        });
        entityManagerFactory.setPersistenceProvider(new HibernatePersistence());
        entityManagerFactory.setJpaProperties(hibernateProperties());
        entityManagerFactory.afterPropertiesSet();
        return entityManagerFactory.getObject();
    }

}
