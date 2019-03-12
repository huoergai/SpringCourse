package com.nio.course2;

import com.alibaba.druid.filter.config.ConfigTools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

import lombok.extern.slf4j.Slf4j;

/*
 *  D&T: 2019/3/11 20:04
 *  Des：阿里巴巴Druid连接池
 */
@SpringBootApplication
@Slf4j
public class DruidDataSourceApp
        implements CommandLineRunner
{
    @Autowired
    private DataSource   mDataSource;
    @Autowired
    private JdbcTemplate mJdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(DruidDataSourceApp.class, args);
    }

    @Override
    public void run(String... args)
            throws Exception
    {
        log.info("DataSource info=" + mDataSource.toString());

        String encryptedPsw = "n/z7PyA5cvcXvs8px8FVmBVpaRyNsvJb3X7YfS38DJrIg25EbZaZGvH4aHcnc97Om0islpCAPc3MqsGvsrxVJw==";
        String pubKey       = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBALS8ng1XvgHrdOgm4pxrnUdt3sXtu/E8My9KzX8sXlz+mXRZQCop7NVQLne25pXHtZoDYuMh3bzoGj6v5HvvAQ8CAwEAAQ==";

        String psw = ConfigTools.decrypt(pubKey, encryptedPsw);
        log.info("psw=" + psw);
    }
}
