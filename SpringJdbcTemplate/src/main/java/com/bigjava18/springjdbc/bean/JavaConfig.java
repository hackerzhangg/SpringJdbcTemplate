package com.bigjava18.springjdbc.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.security.spec.DSAGenParameterSpec;

/**
 * @Author zgp
 * @Since 2021 -06 -21 14 :24
 * @Description SpringJdbcTemplate
 */
@Configuration
@Component
public class JavaConfig {

    @Bean
    DataSource dataSource(){
        DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql:///SpringJdbcTemplate?serverTimezone=Asia/Shanghai");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("199872");
        return driverManagerDataSource;
    }

    @Bean
    JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }
}
