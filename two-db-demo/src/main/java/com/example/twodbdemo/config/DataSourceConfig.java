package com.example.twodbdemo.config;

import javax.sql.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author komiles@163.com
 * @date 2020-05-09 14:18
 */
@Configuration
public class DataSourceConfig {
    @Bean(name="db1")
    @ConfigurationProperties(prefix = "spring.datasource.db1")
    public DataSource komoDbDataSource()
    {
        return DataSourceBuilder.create().build();
    }
    @Bean(name="db2")
    @ConfigurationProperties(prefix = "spring.datasource.db2")
    public DataSource mfwDbDataSource()
    {
        return DataSourceBuilder.create().build();
    }
}
