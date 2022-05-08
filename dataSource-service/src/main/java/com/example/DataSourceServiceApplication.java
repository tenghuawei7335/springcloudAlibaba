package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class DataSourceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataSourceServiceApplication.class, args);
    }

}
