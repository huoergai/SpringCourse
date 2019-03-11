package com.nio.course2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

import lombok.extern.slf4j.Slf4j;

/*
 *  D&T: 2019/2/27 11:20
 *  Des：多数据源配置
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
                                  JdbcTemplateAutoConfiguration.class,
                                  DataSourceTransactionManagerAutoConfiguration.class})
@Slf4j
public class MultiDataSourceApp {
    public static void main(String[] args) {
        SpringApplication.run(MultiDataSourceApp.class, args);
    }

    /* ---------------------- dev DB --------------------------- */

    @Bean
    @ConfigurationProperties("dev.datasource")
    public DataSourceProperties devDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource devDataSource() {
        log.info("dataSource info url=" + devDataSourceProperties().getUrl());
        return devDataSourceProperties().initializeDataSourceBuilder()
                                        .build();
    }

    @Bean
    @Resource
    public PlatformTransactionManager devTxManager(DataSource devDataSource) {
        return new DataSourceTransactionManager(devDataSource);
    }

    /* ---------------------- dev_back DB --------------------------- */

    @Bean
    @ConfigurationProperties("devback.datasource")
    public DataSourceProperties devBackDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource devBackDataSource() {
        log.info("dataSource info url=" + devBackDataSourceProperties().getUrl());
        return devBackDataSourceProperties().initializeDataSourceBuilder()
                                            .build();
    }

    @Bean
    public PlatformTransactionManager devBackTxManager(DataSource devBackDataSource) {
        return new DataSourceTransactionManager(devBackDataSource);
    }

}
