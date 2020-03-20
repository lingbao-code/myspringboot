package com.xzj;


import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;


@Configuration
@PropertySource(value = "classpath:jdbc-mysql.properties")
@Import(SakilaConfig.class)
public class DataSourceConfig {
    @Value("${url}")
    private String url;
    @Value("${driverClassName}")
    private String driverName;
    @Value("${username}")
    private String username;
    @Value("${password}")
    private String password;

    @Bean
    @Conditional(MySQLJDBCCondition.class)
    public DataSource dataSource(){
        BasicDataSource bds= new BasicDataSource();
        bds.setUrl(url);
        bds.setDriverClassName(driverName);
        bds.setUsername(username);
        bds.setPassword(password);
        return bds;
    }
}
