package com.solvd.itcompany.employees;


import com.solvd.itcompany.Project;
import com.solvd.itcompany.enums.ExperienceLevel;
import com.solvd.itcompany.exceptions.ProjectDoesNotExistException;

import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Designer extends Employee {
    private ArrayList <String> designSoftware;
    private static final Logger logger = LogManager.getLogger(Designer.class);

    public Designer(String name, boolean working, ArrayList <String> designSoftware, String certification, String title, ExperienceLevel experienceLevel) {
        this.setName(name);
        this.setWorking(working);
        this.designSoftware = designSoftware;
        this.setCertification(certification);
        this.setTitle(title);
        this.setExperienceLevel(experienceLevel);
    }

    public Designer(ArrayList <String> designSoftware) {
        this.designSoftware = designSoftware;
    }

    public Designer(String name, String department, boolean working, String employeeID, String certification, ArrayList <String> designSoftware) {
        this.designSoftware = designSoftware;
    }

    public ArrayList <String> getDesignSoftware() {
        return designSoftware;
    }

    public void setDesignSoftware(ArrayList <String> designSoftware) {
        this.designSoftware = designSoftware;
    }

    public void createProject(Project project) throws ProjectDoesNotExistException {
        if (project == null){
            throw new ProjectDoesNotExistException();
        }
        logger.info("The designer is creating the design of the application...\n");
        int i = 0;
        while (designSoftware.size() > i){
            logger.info(designSoftware.get(i));
            i++;
        }
        logger.info("\nThe the designer is done designing the application.\n");
    }
}
