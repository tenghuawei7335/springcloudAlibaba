//package com.example.config;
//import com.alibaba.druid.pool.DruidDataSource;
//import com.alibaba.druid.support.http.StatViewServlet;
//import com.alibaba.druid.support.http.WebStatFilter;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.*;
//
//import javax.sql.DataSource;
//
///**
// * Created by IntelliJ IDEA2021.3
// * druid监控页面配置、数据源配置
// * @Author: Tenghw
// * @Date: 2022/05/01  01:15
// * @Description:
// */
//@Configuration
//@Slf4j
//@SuppressWarnings("unchecked")
//@PropertySource("application-dev.properties")
//public class DruidDataSourceConfig {
//
//    @Primary // Primary可以理解为默认优先选择,注入时找到多个符合的Bean，优先选择@Primary注解标记的Bean
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource druidDataSource() {
//        DruidDataSource druidDataSource = new DruidDataSource();
//        return druidDataSource;
//    }
//
////     <!--================================================================================================-->
//    /**
//     * 注册一个StatViewServlet
//     * @return
//     * 配置一个pattern=“/druid/*”的servlet
//     */
//    @Bean
//    public ServletRegistrationBean DruidStatViewServle2() {
//        //org.springframework.boot.context.embedded.ServletRegistrationBean提供类的进行注册.
//        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
////        servletRegistrationBean.addUrlMappings("/druid/*");
//        //白名单：
//        servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
//        //IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to view this page.
//        servletRegistrationBean.addInitParameter("deny", "192.168.1.73");
//        //登录查看信息的账号密码.
//        servletRegistrationBean.addInitParameter("loginUsername", "admin");
//        servletRegistrationBean.addInitParameter("loginPassword", "123");
//        //是否能够重置数据.
//        servletRegistrationBean.addInitParameter("resetEnable", "false");
//        return servletRegistrationBean;
//    }
////     <!--================================================================================================-->
//    /**
//     * 注册一个filterRegistrationBean
//     * @return
//     * 配置一个对静态资源放行的过滤器filter
//     */
//    @Bean
//    public FilterRegistrationBean druidStatFilter2() {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
//        //添加过滤规则.
//        filterRegistrationBean.addUrlPatterns("/*");
//        //添加不需要忽略的格式信息.
//        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid2/*");
//        return filterRegistrationBean;
//    }
//    //     <!--================================================================================================-->
//
////   @Bean
////   public DataSource dataSource(){
////        return new com.alibaba.druid.pool.DruidDataSource();
////   }
//
//
//}
