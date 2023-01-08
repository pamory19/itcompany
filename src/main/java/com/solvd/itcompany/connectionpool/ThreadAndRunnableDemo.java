package com.solvd.itcompany.connectionpool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

public class ThreadAndRunnableDemo {

    private static final Logger logger = LogManager.getLogger(ThreadAndRunnableDemo.class);

    public static void main(String[] args) throws SQLException, ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {

        ThreadCreation threadCreation = new ThreadCreation();
        RunnableCreation runnableCreation = new RunnableCreation();

        threadCreation.start();
        new Thread(runnableCreation).start();


        // create a connection pool object
        ConnectionPoolDesign connectionPool = new ConnectionPoolDesign("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/database_name", "username", "password", 5);

        Runnable task = () -> {
            try {
                Connection connection = connectionPool.getConnection();
                Thread.sleep(5000);
                connectionPool.releaseConnection(connection);
            } catch (SQLException | InterruptedException | ClassNotFoundException e) {
                logger.error("Error in task execution: ", e);
            }
        };

        // thread pool with 7 threads
        ExecutorService threadPool = Executors.newFixedThreadPool(7);


        for (int i = 0; i < 7; i++){
            try {
                threadPool.submit(task);
            }
            catch (RejectedExecutionException e){
                logger.error("Failed to submit task: ", e);
            }
        }
        threadPool.shutdown();

    }

}
