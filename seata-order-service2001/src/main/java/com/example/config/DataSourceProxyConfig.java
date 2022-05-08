package com.example.config;
import com.alibaba.druid.pool.DruidDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import lombok.Data;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import javax.sql.DataSource;
/**
 * Created by IntelliJ IDEA2021.3
 * @Author: Tenghw
 * @Date: 2022/05/04  14:11
 *
 * @Description:使用Seata对数据源进行代理
 * 从Seata1.3开始，不鼓励自己注册DataSourceProxy bean。
 * 如果使用的是seata starter，不需要关心DataSourceProxy（seata starter会自动处理它），只需注册并以旧的方式使用Datasource bean即可。
 */

 @Configuration
 @SuppressWarnings("all")
 @Data
 @PropertySource("application-dev.properties")
 public class DataSourceProxyConfig {

    @Value("${mybatis.mapper-locations}")
    private String mapperLocations;

    @Primary // Primary可以理解为默认优先选择,注入时找到多个符合的Bean，优先选择@Primary注解标记的Bean
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }

    @Bean("dataSourceProxy")
    public DataSourceProxy dataSourceProxy(DataSource dataSource) {
        return new DataSourceProxy(dataSource);
    }

    @Bean("txManager")//开启事务管理器
    public DataSourceTransactionManager txManager(DataSourceProxy dataSourceProxy) {
        return new DataSourceTransactionManager(dataSourceProxy);
    }

    /**
     * @param dataSourceProxy
     * @return SqlSessionFactoryBean
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean(DataSourceProxy dataSourceProxy) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSourceProxy);
  System.out.println("mapperLocations==rrrrrrrr="+mapperLocations);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));
        sqlSessionFactoryBean.setTransactionFactory(new SpringManagedTransactionFactory());

        /*
        // 如果使用的mybatis-plus，添加下面的内容
        // ------------------------------------------------------------------------------
        // 实体类所在包
        sqlSessionFactoryBean.setTypeAliasesPackage("com.pan.springcloud.alibaba.entity");
        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        sqlSessionFactoryBean.setConfiguration(configuration);
        //-----------------------------------------------------------------------------
        */
        return  sqlSessionFactoryBean.getObject();
    }


}