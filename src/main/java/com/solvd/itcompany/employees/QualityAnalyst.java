package com.solvd.itcompany.employees;

import com.solvd.itcompany.Project;
import com.solvd.itcompany.enums.ExperienceLevel;
import com.solvd.itcompany.exceptions.ProjectDoesNotExistException;

import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QualityAnalyst extends Employee {
    private ArrayList <String> tools;
    private static final Logger logger = LogManager.getLogger(QualityAnalyst.class);

    public QualityAnalyst(String name, boolean working, ArrayList <String> tools, String certification, String title, ExperienceLevel experienceLevel){
        this.setName(name);
        this.setWorking(working);
        this.tools = tools;
        this.setCertification(certification);
        this.setTitle(title);
        this.setExperienceLevel(experienceLevel);
    }

    public QualityAnalyst(ArrayList <String> tools) {
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
        logger.info("The quality analyst is testing the application...\n");
        int i = 0;
        while (tools.size() > i){
            logger.info(tools.get(i));
            i++;
        }
        logger.info("\nThe the Quality Analyst is done testing the application.\n");
    }
}
