package com.solvd.itcompany.connectionpool;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionPool {
    Connection getConnection() throws SQLException, InterruptedException, ClassNotFoundException;
    Connection getConnection(long timeout) throws SQLException, InterruptedException, ClassNotFoundException;
    void releaseConnection(Connection connection);
}
