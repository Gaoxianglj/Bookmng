package com.example.accenturespringbootdemo.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import com.example.accenturespringbootdemo.exception.BusinessFailureException;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;

@Configuration
public class MyBatisConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource getAppDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        try {
            bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("com/example/accenturespringbootdemo/repository/*.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        bean.setTypeAliasesPackage("com.test.maper");
        bean.setVfs(SpringBootVFS.class);
        try {
            bean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
            return bean.getObject();
        } catch (Exception e) {
            throw new BusinessFailureException(e);
        }
    }

    @Bean(name = "sqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory, sqlSessionFactory.getConfiguration().getDefaultExecutorType());
    }
}
