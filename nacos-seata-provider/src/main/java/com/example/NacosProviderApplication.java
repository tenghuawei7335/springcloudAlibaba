package com.example;
import io.seata.config.springcloud.EnableSeataSpringConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableDiscoveryClient
//@EnableSeataSpringConfig
@MapperScan(basePackages={"com.example.mapper"})
@SuppressWarnings("all")
public class NacosProviderApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(NacosProviderApplication.class, args);




    }

}
