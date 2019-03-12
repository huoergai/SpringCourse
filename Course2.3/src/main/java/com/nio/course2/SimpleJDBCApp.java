package com.nio.course2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;

import lombok.extern.slf4j.Slf4j;

/*
 *  D&T: 2019/3/12 9:36
 *  Des：
 */
@SpringBootApplication
@Slf4j
public class SimpleJDBCApp
        implements CommandLineRunner
{
    @Autowired
    private UserDao      mUserDao;
    @Autowired
    private UserBatchDao mUserBatchDao;

    public static void main(String[] args) {
        SpringApplication.run(SimpleJDBCApp.class, args);
    }

    @Override
    public void run(String... args)
            throws Exception
    {
        mUserDao.insert();
        mUserBatchDao.batchInsert();
        mUserDao.ListData();
    }

    @Bean
    @Autowired
    public SimpleJdbcInsert simpleJdbcInsert(JdbcTemplate jdbcTemplate) {
        return new SimpleJdbcInsert(jdbcTemplate).withTableName("user")
                                                 .usingGeneratedKeyColumns("id");
    }

    @Bean
    @Autowired
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }
}
