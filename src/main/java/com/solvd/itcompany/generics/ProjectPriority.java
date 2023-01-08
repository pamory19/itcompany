package com.solvd.itcompany.generics;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Iterator;
import java.util.PriorityQueue;

public class ProjectPriority<T> {
    private PriorityQueue<T> listOfPriorities;
    private static final Logger logger = LogManager.getLogger(ProjectPriority.class);

    public ProjectPriority(PriorityQueue<T> listOfPriorities) {
        this.listOfPriorities = listOfPriorities;
    }

    public PriorityQueue<T> getListOfPriorities() {
        return listOfPriorities;
    }

    public void setListOfPriorities(PriorityQueue<T> listOfPriorities) {
        this.listOfPriorities = listOfPriorities;
    }

    public static <T> void prioritizeProjects(PriorityQueue<T> listOfPriorities){
        Iterator<T> iterator = listOfPriorities.iterator();
        while(iterator.hasNext()){
            T element = iterator.next();
            logger.info("\n" + element);
        }
    }
}
