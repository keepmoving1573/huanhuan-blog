package com.huan.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @author <a href="mailto:jean@eastcode.org">Jean Seurin</a>
 * @since 24/11/15 - 19:15
 */
@Configuration
@AutoConfigureAfter({DatabaseConfiguration.class})
public class MybatisConfiguration implements EnvironmentAware {

    private RelaxedPropertyResolver propertyResolver;

    public void setEnvironment(Environment environment) {
        this.propertyResolver = new RelaxedPropertyResolver(environment, "mybatis.");
    }

    /**
     * 将mybatis的sqlSessionFactory交给spring管理
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws IOException {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(resolver.getResources("classpath:mapper/**/*.xml"));
        sessionFactory.setTypeAliasesPackage("com.huan.**.model");
        return sessionFactory;
    }

    /**
     * 扫描跑mapper包下的所有接口，作为mybatis接口类，并注册为spring的bean
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
        scannerConfigurer.setAddToConfig(true);
        scannerConfigurer.setBasePackage("com.huan.**.mapper");
        return scannerConfigurer;
    }


}
