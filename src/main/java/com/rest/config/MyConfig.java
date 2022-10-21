package com.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@EnableWebMvc
@Configuration
@ComponentScan("com.rest")
public class MyConfig {


    @Bean
    DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource1 = new DriverManagerDataSource ("jdbc:postgresql://database-1.cajltm0wwrzl.us-east-1.rds.amazonaws.com:5432/test", "postgres", "Hnas2018");
        driverManagerDataSource1.setDriverClassName ("org.postgresql.Driver");
        return driverManagerDataSource1;
    }

    @Bean
    JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate (dataSource ());
    }
}
