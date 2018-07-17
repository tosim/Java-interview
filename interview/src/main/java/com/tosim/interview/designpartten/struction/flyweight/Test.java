package com.tosim.interview.designpartten.struction.flyweight;

import java.sql.Connection;

/**
 * 运用共享技术有效地支持大量细粒度的对象。
 */
public class Test {

    public static void main(String[] args) {
        ConnectionPool connectionPool = new ConnectionPool();
        Connection connection = connectionPool.getConnection();
        connectionPool.release(connection);
    }
}
