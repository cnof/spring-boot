package com.dk.bookmark.common.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author : dukang
 * @date: 2018/7/19 18:21
 * @description:
 */
@Configuration
@MapperScan(value = "com.dk.bookmark.system.dao", sqlSessionTemplateRef = "markSqlSessionTemplate")
public class MarkDataSourceConfig {

    private static final String MAPPER_LOCATION = "classpath:mybatis/system/*.xml";

    @Value("${mark.datasource.url}")
    private String url;

    @Value("${mark.datasource.username}")
    private String username;

    @Value("${mark.datasource.password}")
    private String password;

    @Value("${mark.datasource.driver-class-name}")
    private String driverClassName;

    @Primary
    @Bean(name = "markDataSource")
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }

    @Primary
    @Bean(name = "markTransactionManager")
    public DataSourceTransactionManager dataSourceTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Primary
    @Bean(name = "markSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("markDataSource") DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        sqlSessionFactoryBean.setConfiguration(configuration);
        return sqlSessionFactoryBean.getObject();
    }

    @Primary
    @Bean(name = "markSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("markSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
