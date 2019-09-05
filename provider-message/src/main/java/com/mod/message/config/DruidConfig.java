package com.mod.message.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@Slf4j
public class DruidConfig{

    @Value("${spring.datasource.druid.user:admin}")
    private String druidUser;
    @Value("${spring.datasource.druid.password:admin}")
    private String druidPassword;


    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource() {

        return new DruidDataSource();
    }


    /**
     * 注册一个StatViewServlet
     *
     * @return servlet registration bean
     */
    @Bean
    public ServletRegistrationBean<StatViewServlet> druidStatViewServlet() {
        ServletRegistrationBean<StatViewServlet> servletRegistrationBean = new ServletRegistrationBean<StatViewServlet>(
                new StatViewServlet(), "/druid/*");

        servletRegistrationBean.addInitParameter("loginUsername", druidUser);
        servletRegistrationBean.addInitParameter("loginPassword", druidPassword);
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean;
    }

    /**
     * 注册一个：filterRegistrationBean
     *
     * @return filter registration bean
     */
    @Bean
    public FilterRegistrationBean<WebStatFilter> druidStatFilter() {

        FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<WebStatFilter>(
                new WebStatFilter());

        // 添加过滤规则.
        filterRegistrationBean.addUrlPatterns("/*");

        // 添加不需要忽略的格式信息.
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}
