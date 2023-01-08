package com.solvd.itcompany.generics;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.HashSet;
import java.util.Iterator;


public class ListOfTasks<T> {
    private HashSet<T> listOfTasks;
    private static final Logger logger = LogManager.getLogger(ListOfTasks.class);

    public ListOfTasks(HashSet<T> listOfTasks) {
        this.listOfTasks = listOfTasks;
    }

    public HashSet<T> getListOfTasks() {
        return listOfTasks;
    }

    public void setListOfTasks(HashSet<T> listOfTasks) {
        this.listOfTasks = listOfTasks;
    }

    public static <T> void createTasks(HashSet<T> listOfTasks){
        Iterator<T> iterator = listOfTasks.iterator();
        logger.info("\nHere are a list of tasks for the project: ");
        while(iterator.hasNext()){
            T element = iterator.next();

            logger.info("\n" + element);
        }
    }

}
