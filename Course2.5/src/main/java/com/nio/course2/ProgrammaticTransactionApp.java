package com.nio.course2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import lombok.extern.slf4j.Slf4j;

/*
 *  D&T: 2019/3/12 17:15
 *  Des：编程式事务
 */
@Slf4j
@SpringBootApplication
public class ProgrammaticTransactionApp
        implements CommandLineRunner
{
    @Autowired
    private JdbcTemplate        mJdbcTemplate;
    @Autowired
    private TransactionTemplate mTransactionTemplate;

    public static void main(String[] args) {
        SpringApplication.run(ProgrammaticTransactionApp.class, args);
    }

    @Override
    public void run(String... args)
            throws Exception
    {
        log.info("before TX count=" + getCount());
        mTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                mJdbcTemplate.execute("INSERT INTO user (name) VALUES ('catherine zeta')");
                log.info("in TX count=" + getCount());
                status.setRollbackOnly();
            }
        });
        log.info("after TX count=" + getCount());
    }

    private Long getCount() {
        return mJdbcTemplate.queryForObject("SELECT count(*) FROM user ", Long.class);
    }
}
