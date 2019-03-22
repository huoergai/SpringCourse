package com.nio.course2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/*
 *  D&T: 2019/3/18 14:38
 *  Des：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ErrorCodeAppTest {
    @Autowired
    private JdbcTemplate mJdbcTemplate;

    @Test(expected = CustomDuplicatedKeyException.class)
    public void testCustomDuplicateKeyException() {
        mJdbcTemplate.execute("insert into user (id, name) VALUES (7,'al')");
        mJdbcTemplate.execute("insert into user (id, name) VALUES (7,'roy')");
    }
}