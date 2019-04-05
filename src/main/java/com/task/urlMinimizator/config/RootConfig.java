package com.task.urlMinimizator.config;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@EnableTransactionManagement
public class RootConfig {

    @Bean(name = "DS")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {return new BasicDataSource();}

    @Bean
    public PlatformTransactionManager txManager() throws Exception {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public MultipartResolver multipartResolver() throws IOException {
        return new StandardServletMultipartResolver();
    }

    @Bean
    public FactoryBean<SessionFactory> hibernateAnnotatedSessionFactory() {
        return new LocalSessionFactoryBean();
    }
}
