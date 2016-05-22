package com.huan.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by ptmind on 2016/5/3.
 */
@Configuration
@EnableTransactionManagement
public class DatabaseConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseConfiguration.class);

    @Value("${datasource.driverClassName}")
    private String driverClassName;

    @Value("${datasource.url}")
    private String url;

    @Value("${datasource.username}")
    private String username;

    @Value("${datasource.password}")
    private String password;

    @Value("${datasource.maximumPoolSize}")
    private Integer maximumPoolSize;

    /**
     * 数据库连接配置
     */
    @Bean(initMethod = "init", destroyMethod = "close")
    public DataSource dataSource() {
        logger.debug("Configuring Datasource");

        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setMaxActive(maximumPoolSize);
        druidDataSource.setMaxWait(60000);
        druidDataSource.setMinIdle(1);
        druidDataSource.setValidationQuery("SELECT 1");
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setTestOnBorrow(false);
        druidDataSource.setTestOnReturn(false);
        /**
         * configuration exception handling
         * */
        druidDataSource.setQueryTimeout(15); //查询超时时间15s
        //通过datasource.getConnontion() 取得的连接必须在removeAbandonedTimeout这么多秒内调用close(),要不强制关闭.(就是conn不能超过指定的租期)
        druidDataSource.setRemoveAbandoned(true);
        druidDataSource.setRemoveAbandonedTimeout(600); //一个连接的租期10分钟，超时会被强制关闭
        druidDataSource.setLogAbandoned(true);
        return druidDataSource;
    }
}
