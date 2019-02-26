package com.nio.course2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import lombok.extern.slf4j.Slf4j;

/*
 *  D&T: 2019/2/26 14:55
 *  Des：
 */
@SpringBootApplication
@Slf4j
public class DataSourceApplication
        implements CommandLineRunner
{
    @Autowired
    private DataSource mDataSource;

    @Autowired
    private JdbcTemplate mJdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(DataSourceApplication.class, args);
    }

    @Override
    public void run(String... args)
            throws Exception
    {
        showConnection();
        showData();
    }

    private void showConnection()
            throws SQLException
    {
        log.info(mDataSource.toString());

        Connection conn = mDataSource.getConnection();
        log.info(conn.toString());
        conn.close();
    }

    private void showData() {
        mJdbcTemplate.queryForList("SELECT * FROM user")
                     .forEach(row -> log.info(row.toString()));
    }
}
