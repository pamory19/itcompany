package com.solvd.itcompany.connectionpool;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.*;
import java.sql.Connection;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConnectionPoolDesign {
    private Driver driver;
    private String url;
    private String username;
    private String password;
    private int maximumPoolSize;
    private ConcurrentLinkedQueue<Connection> connections;


    public ConnectionPoolDesign(String driverClassName, String url, String username, String password, int maximumPoolSize) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, SQLException {
        Class<?> driverClass = Class.forName(driverClassName);
        Constructor<?> constructor = driverClass.getDeclaredConstructor();
        Driver driver = (Driver) constructor.newInstance();
        DriverManager.registerDriver(driver);

        this.url = url;
        this.username = username;
        this.password = password;
        this.maximumPoolSize = maximumPoolSize;
        this.connections = new ConcurrentLinkedQueue<>();
    }


    public synchronized Connection getConnection() throws SQLException, ClassNotFoundException {
        // check if the connection pool is empty
        if (connections.isEmpty()){
            // create a new connection and add it to the pool
            Connection connection = createConnection();
            connections.add(connection);
        }
        return connections.poll();
    }

    public Connection getConnection(long timeout) throws SQLException, InterruptedException, ClassNotFoundException {
        Connection connection = null;
        long startTime = System.currentTimeMillis();
        while (connection == null && (System.currentTimeMillis() - startTime) < timeout){
            connection = connections.poll();
            if (connection == null){
                if (connections.size() == maximumPoolSize){
                    synchronized (this){
                        wait(timeout - (System.currentTimeMillis() - startTime));
                    }
                }
                else {
                    connection = createConnection();
                    connections.add(connection);
                }
            }
        }
        if (connection == null){
            throw new SQLException();
        }
        return connection;
    }

    private Connection createConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/database_name";
        String username = "username";
        String password = "password";

        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, username, password);
    }

    public void releaseConnection(Connection connection){
        synchronized (this){
            connections.offer(connection);
            this.notifyAll();
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String user) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMaximumPoolSize() {
        return maximumPoolSize;
    }

    public void setMaximumPoolSize(int maximumPoolSize) {
        this.maximumPoolSize = maximumPoolSize;
    }

    public Queue<Connection> getConnections() {
        return connections;
    }

    public void setConnections(ConcurrentLinkedQueue<Connection> connections) {
        this.connections = connections;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

}
