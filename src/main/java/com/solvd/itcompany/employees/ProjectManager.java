package com.solvd.itcompany.employees;

import com.solvd.itcompany.Project;
import com.solvd.itcompany.enums.ExperienceLevel;
import com.solvd.itcompany.exceptions.ProjectDoesNotExistException;

import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ProjectManager extends Employee {
    private ArrayList <String> tools;
    private static final Logger logger = LogManager.getLogger(ProjectManager.class);

    public ProjectManager(String name, boolean working, ArrayList <String> tools, String certification, String title, ExperienceLevel experienceLevel) {
        this.setName(name);
        this.setWorking(working);
        this.tools = tools;
        this.setCertification(certification);
        this.setTitle(title);
        this.setExperienceLevel(experienceLevel);
    }

    public ProjectManager(String name, boolean working, String employeeID, String certification, ArrayList <String> tools, ExperienceLevel experienceLevel) {
        this.setName(name);
        this.setWorking(working);
        this.setEmployeeID(employeeID);
        this.setCertification(certification);
        this.setExperienceLevel(experienceLevel);
        this.tools = tools;
    }

    public ArrayList <String> getTools() {
        return tools;
    }

    public void setTools(ArrayList <String> tools) {
        this.tools = tools;
    }


    public void createProject(Project project) throws ProjectDoesNotExistException {
        if (project == null){
            throw new ProjectDoesNotExistException();
        }
        logger.info("The project manager is creating the project plan...\n");
        int i = 0;
        while (tools.size() > i){
            logger.info(tools.get(i));
            i++;
        }
        logger.info("\nThe the Project Manager is done managing the application.\n");
    }
}
