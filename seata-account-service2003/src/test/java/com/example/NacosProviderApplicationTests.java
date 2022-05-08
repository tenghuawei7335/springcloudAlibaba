package com.example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class NacosProviderApplicationTests {
    @Autowired
    DataSource dataSource;
    @Autowired
    DataSource druidDataSource;

    @Test
    public void contextLoads() {
    }
    @Test
    public void contextLoads1() throws SQLException {
        String s1=dataSource.getConnection().getMetaData().getURL();
        String s2=dataSource.getConnection().getMetaData().getDriverName();
        String s3=dataSource.getConnection().getMetaData().getDriverVersion();
        System.out.println(s1+","+s2+","+s3);

        String s11=druidDataSource.getConnection().getMetaData().getURL();
        String s21=druidDataSource.getConnection().getMetaData().getDriverName();
        String s31=druidDataSource.getConnection().getMetaData().getDriverVersion();
        System.out.println(s11+","+s21+","+s31);
    }

}
