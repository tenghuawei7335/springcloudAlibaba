package com.example;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import javax.sql.DataSource;
import java.sql.SQLException;
@SpringBootTest
public class DataSourceServiceApplicationTests {
//@Autowired
//DataSource dataSource;
    @Autowired
    DataSource dataSource1;
    @Test
    public void contextLoads1() throws SQLException {
//        String url=dataSource.getConnection().getMetaData().getURL();
//        String username=dataSource.getConnection().getMetaData().getUserName();
//        String version=dataSource.getConnection().getMetaData().getDriverVersion();
//        System.out.println(url);
//        System.out.println(username);
//        System.out.println(version);
        System.out.println("----------------");
        String url1=dataSource1.getConnection().getMetaData().getURL();
        String username1=dataSource1.getConnection().getMetaData().getUserName();
        String version1=dataSource1.getConnection().getMetaData().getDriverVersion();
        System.out.println(url1);
        System.out.println(username1);
        System.out.println(version1);
    }
}
