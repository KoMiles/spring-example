package com.example.druiddemo.config;

import com.alibaba.druid.pool.DruidDataSource;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * @author komiles@163.com
 * @date 2020-05-12 18:41
 */
@Configuration
@MapperScan(basePackages = MfwDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "mfwSqlSessionFactory")
public class MfwDataSourceConfig {

    /**
     * 配置多数据源 关键就在这里 这里配置了不同的数据源扫描不同mapper
     */
    static final String PACKAGE = "com.example.druiddemo.mapper.mfw";
    static final String MAPPER_LOCATION = "classpath:mybatis/mfw/mapper/*.xml";

    /**
     * 连接数据库信息 这个其实更好的是用配置中心完成
     */
    @Value("${mfw.datasource.url}")
    private String url;

    @Value("${mfw.datasource.username}")
    private String username;

    @Value("${mfw.datasource.password}")
    private String password;

    @Value("${mfw.datasource.driver-class-name}")
    private String driverClassName;

    @Bean("mfwDataSource")
    public DataSource mfwDataSource(){

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }

    @Bean(name = "mfwTransactionManager")
    public DataSourceTransactionManager masterTransactionManager() {
        return new DataSourceTransactionManager(mfwDataSource());
    }

    @Bean(name = "mfwSqlSessionFactory")
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("mfwDataSource") DataSource masterDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(masterDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MfwDataSourceConfig.MAPPER_LOCATION));

        return sessionFactory.getObject();
    }
}
