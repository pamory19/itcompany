package com.solvd.itcompany.generics;

import com.solvd.itcompany.Project;
import com.solvd.itcompany.enums.ProjectStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;

public class ProjectTracker<T>{
    private ArrayList<T> listOfProjects;
    private ProjectStatus projectStatus;
    private static final Logger logger = LogManager.getLogger(ProjectTracker.class);


    public ArrayList<T> getListOfProjects() {
        return listOfProjects;
    }

    public void setListOfProjects(ArrayList<T> listOfProjects) {
        this.listOfProjects = listOfProjects;
    }

    public ProjectStatus getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(ProjectStatus projectStatus) {
        this.projectStatus = projectStatus;
    }

    public static void removeProject(ArrayList<Project> listOfProjects){
        for (int i = 0; i < listOfProjects.size(); i++) {
            if (listOfProjects.get(i).getProjectStatus() == ProjectStatus.COMPLETE){
                listOfProjects.remove(listOfProjects.get(i));
            }
        }
        logger.info("\nThe projects left in the backlog: " + listOfProjects);
    }

}
