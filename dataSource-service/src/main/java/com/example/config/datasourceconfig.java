package com.example.config;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import javax.sql.DataSource;
/**
 * Created by IntelliJ IDEA2021.3
 * @Author: Tenghw
 * @Date: 2022/05/05  14:23
 * @Description:
 */
@Configuration
@PropertySource("classpath:application-dev.properties")
public class datasourceconfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource1(){
        return new DruidDataSource();
    }
//
}
