package com.solvd.itcompany.connectionpool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConnectionPoolDemo {

    private static final Logger logger = LogManager.getLogger(ConnectionPoolDemo.class);

    public static void main(String[] args) {

        ThreadCreation threadCreation = new ThreadCreation();
        RunnableCreation runnableCreation = new RunnableCreation();

        threadCreation.start();
        new Thread(runnableCreation).start();


        // thread pool with 7 threads
        ExecutorService threadPool = Executors.newFixedThreadPool(7);



    }

}
