package com.divya.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Properties;

/**
 * Created by divya on 28/9/16.
 */
@Configuration
@ComponentScan(basePackages = {"com.divya"},
excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,value = EnableWebMvc.class))
public class RootConfig {
    @Bean
    public DriverManagerDataSource getDriverManager(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spittr?autoReconnect=true");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactoryBean(DriverManagerDataSource dataSource){
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setDataSource(dataSource);
        localSessionFactoryBean.setPackagesToScan("com.divya");
        Properties properties = new Properties();
        properties.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
        properties.setProperty("show_sql","true");
        properties.setProperty("hibernate.hbm2ddl.auto","update");
        localSessionFactoryBean.setHibernateProperties(properties);
        localSessionFactoryBean.setAnnotatedClasses(com.divya.model.Spitter.class);
        return localSessionFactoryBean ;
    }

}
