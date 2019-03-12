package com.nio.course2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/*
 *  D&T: 2019/3/12 11:31
 *  Des：
 */
@Component
public class FooServiceImp
        implements FooService
{
    @Autowired
    private JdbcTemplate mJdbcTemplate;

    @Transactional
    @Override
    public void insert() {
        mJdbcTemplate.execute("insert into user (name) values ('vincent')");
    }

    @Transactional(rollbackFor = RollbackExpection.class)
    @Override
    public void insertThenRollback()
            throws RollbackExpection
    {
        mJdbcTemplate.execute("insert into user (name) values ('shaw')");
        throw new RollbackExpection();
    }

    // will not rollback without transactional annotation and rollback condition
    // @Transactional(rollbackFor = RollbackExpection.class)
    @Override
    public void invokeInsertThenRollback()
            throws RollbackExpection
    {
        insertThenRollback();
    }
}
