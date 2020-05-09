package com.example.twodbdemo.config;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * @author komiles@163.com
 * @date 2020-05-09 14:21
 */
@Configuration
@MapperScan(basePackages = {"com.example.twodbdemo.mapper.mfwMapper"}, sqlSessionFactoryRef = "sqlSessionFactoryDb2")
public class Db2Config {

    private static final String PATH = "classpath:mybatis/mfw/mapper/*.xml";

    @Autowired
    @Qualifier("db2")
    private DataSource dataSourceDb2;

    @Bean
    public SqlSessionFactory sqlSessionFactoryDb2() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSourceDb2);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(Db2Config.PATH));
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplateDb2() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactoryDb2());
    }
}
