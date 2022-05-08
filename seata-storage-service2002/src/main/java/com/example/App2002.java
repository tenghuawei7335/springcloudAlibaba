package com.example;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableTransactionManagement
@EnableDiscoveryClient
//@EnableFeignClients
@SuppressWarnings("all")
public class App2002 {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(App2002.class, args);




    }

}
