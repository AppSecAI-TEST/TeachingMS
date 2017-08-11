package com.soft;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 项目入口
 */
@SpringBootApplication
@ComponentScan("com.soft.**")
@MapperScan(basePackages = "com.soft.dao")
public class RootApplication {
    public static void main(String [] args) {
        SpringApplication.run(RootApplication.class, args);
    }
}
