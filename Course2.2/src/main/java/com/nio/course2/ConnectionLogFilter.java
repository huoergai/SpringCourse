package com.nio.course2;

import com.alibaba.druid.filter.FilterChain;
import com.alibaba.druid.filter.FilterEventAdapter;
import com.alibaba.druid.proxy.jdbc.ConnectionProxy;

import java.util.Properties;

import lombok.extern.slf4j.Slf4j;

/*
 *  D&T: 2019/3/11 21:00
 *  Des：
 */
@Slf4j
public class ConnectionLogFilter
        extends FilterEventAdapter
{
    @Override
    public void connection_connectBefore(FilterChain chain, Properties info) {
        super.connection_connectBefore(chain, info);
        log.info("before connection");
    }

    @Override
    public void connection_connectAfter(ConnectionProxy connection) {
        super.connection_connectAfter(connection);
        log.info("after connection");
    }
}
