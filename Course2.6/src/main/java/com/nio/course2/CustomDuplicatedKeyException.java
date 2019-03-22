package com.nio.course2;

import org.springframework.dao.DuplicateKeyException;

/*
 *  D&T: 2019/3/18 14:26
 *  Des：
 */
public class CustomDuplicatedKeyException
        extends DuplicateKeyException {
    public CustomDuplicatedKeyException(String msg) {
        super(msg);
    }

    public CustomDuplicatedKeyException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
