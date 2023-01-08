package com.solvd.itcompany.generics;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;

public class LinkedListProject<T>{
    private LinkedList<T> projectList;
    private static final Logger logger = LogManager.getLogger(LinkedListProject.class);

    public LinkedList<T> getProjectList() {
        return projectList;
    }

    public void setProjectList(LinkedList<T> projectList) {
        this.projectList = projectList;
    }

    public void printListOfProjects(LinkedList<T> projectList){
        for (int i = 0; i < projectList.size(); i++) {
            logger.info("\nBacklog of projects: \n" + projectList.get(i));
        }
    }

}
