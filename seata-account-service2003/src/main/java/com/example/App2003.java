package com.example;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableTransactionManagement//开启事务
@EnableDiscoveryClient
//@EnableFeignClients
@SuppressWarnings("all")
public class App2003 {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(App2003.class, args);




    }

}
