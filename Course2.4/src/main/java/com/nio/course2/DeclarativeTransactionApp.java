package com.nio.course2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lombok.extern.slf4j.Slf4j;

/*
 *  D&T: 2019/3/12 11:23
 *  Des：申明式事务
 */
@Slf4j
@SpringBootApplication
@EnableTransactionManagement(mode = AdviceMode.PROXY)
public class DeclarativeTransactionApp
        implements CommandLineRunner
{
    @Autowired
    private JdbcTemplate mJdbcTemplate;
    @Autowired
    private FooService   mFooService;

    public static void main(String[] args) {
        SpringApplication.run(DeclarativeTransactionApp.class, args);
    }

    @Override
    public void run(String... args)
            throws Exception
    {
        mFooService.insert();
        log.info("vincent count=" + mJdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM user WHERE name='vincent'",
                Long.class));

        try {
            mFooService.insertThenRollback();
        } catch (RollbackExpection rollbackExpection) {
            rollbackExpection.printStackTrace();
            log.info("shaw count=" + mJdbcTemplate.queryForObject(
                    "SELECT COUNT(*) FROM user WHERE name='shaw'",
                    Long.class));
        }

        try {
            mFooService.invokeInsertThenRollback();
        } catch (RollbackExpection rollbackExpection) {
            rollbackExpection.printStackTrace();
            log.info("shaw count=" + mJdbcTemplate.queryForObject(
                    "SELECT COUNT(*) FROM user WHERE name='shaw'",
                    Long.class));
        }
    }
}
