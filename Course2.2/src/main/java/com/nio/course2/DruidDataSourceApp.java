package com.nio.course2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

import lombok.extern.slf4j.Slf4j;

/*
 *  D&T: 2019/3/11 20:04
 *  Des：
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
    }
}
