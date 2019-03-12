package com.nio.course2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import lombok.extern.slf4j.Slf4j;

/*
 *  D&T: 2019/3/12 10:18
 *  Des：
 */
@Slf4j
@Repository
public class UserBatchDao {
    @Autowired
    private JdbcTemplate mJdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate mNamedParameterJdbcTemplate;

    public void batchInsert() {
        mJdbcTemplate.batchUpdate("INSERT INTO user (name) VALUES (?)",
                                  new BatchPreparedStatementSetter() {
                                      @Override
                                      public void setValues(PreparedStatement ps, int i)
                                              throws SQLException
                                      {
                                          ps.setString(1, "Minions " + i);
                                      }

                                      @Override
                                      public int getBatchSize() {
                                          return 2;
                                      }
                                  });

        ArrayList<User> users = new ArrayList<>();
        users.add(User.builder()
                      .id(30)
                      .name("niob")
                      .build());
        users.add(User.builder()
                      .id(31)
                      .name("matrix")
                      .build());
        mNamedParameterJdbcTemplate.batchUpdate("INSERT INTO user (id, name) VALUES (:id,:name)",
                                                SqlParameterSourceUtils.createBatch(users));

    }

}
