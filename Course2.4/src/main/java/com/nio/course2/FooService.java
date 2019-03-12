package com.nio.course2;

/*
 *  D&T: 2019/3/12 11:25
 *  Des：
 */
public interface FooService {
    void insert();

    void insertThenRollback()
            throws RollbackExpection;

    void invokeInsertThenRollback()
            throws RollbackExpection;
}
