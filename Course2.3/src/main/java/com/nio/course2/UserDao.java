package com.nio.course2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

/*
 *  D&T: 2019/3/12 9:44
 *  Des：SQL批处理
 */
@Slf4j
@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate mJdbcTemplate;

    @Autowired
    private SimpleJdbcInsert mSimpleJdbcInsert;

    public void insert() {
        Arrays.asList("mika", "mat")
              .forEach(item -> {
                  mJdbcTemplate.update("INSERT INTO user (name) values (?)", item);
              });

        HashMap<String, String> row = new HashMap<>();
        row.put("name", "cruz");
        Number index = mSimpleJdbcInsert.executeAndReturnKey(row);
        log.info("SimpleJdbcInsert index =" + index.longValue());
    }

    public void ListData() {
        Long count = mJdbcTemplate.queryForObject("SELECT COUNT(*) FROM user", Long.class);
        log.info("count =" + count);

        List<String> names = mJdbcTemplate.queryForList("SELECT name FROM user", String.class);
        names.forEach(item -> log.info("name = " + item));

        List<User> userList = mJdbcTemplate.query("SELECT * FROM user", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum)
                    throws SQLException
            {
                return User.builder()
                           .id(rs.getInt(1))
                           .name(rs.getString(2))
                           .build();
            }
        });
        userList.forEach(user -> log.info("user=" + user));
    }
}
