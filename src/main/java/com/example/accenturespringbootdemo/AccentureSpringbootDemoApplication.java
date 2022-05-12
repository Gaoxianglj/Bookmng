package com.example.accenturespringbootdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

public class AccentureSpringbootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccentureSpringbootDemoApplication.class, args);
    }

}
