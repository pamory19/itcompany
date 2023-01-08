package com.solvd.itcompany.employees;

import com.solvd.itcompany.Project;
import com.solvd.itcompany.enums.ExperienceLevel;
import com.solvd.itcompany.exceptions.ProjectDoesNotExistException;

import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FrontendEngineer extends Employee {
    private ArrayList <String> languages;
    private static final Logger logger = LogManager.getLogger(FrontendEngineer.class);


    public FrontendEngineer(){

    }
    public FrontendEngineer(String name, boolean working, ArrayList <String> languages, String certification, String title, ExperienceLevel experienceLevel) {
        this.setName(name);
        this.setWorking(working);
        this.languages = languages;
        this.setCertification(certification);
        this.setTitle(title);
        this.setExperienceLevel(experienceLevel);
    }

    public FrontendEngineer(String name, String employeeID, String certification, boolean working, ArrayList <String> languages, String title, ExperienceLevel experienceLevel) {
        this.setName(name);
        this.setEmployeeID(employeeID);
        this.setCertification(certification);
        this.setExperienceLevel(experienceLevel);
        this.setWorking(working);
        this.languages = languages;
        this.setTitle(title);
    }


    public ArrayList<String> getLanguages() {
        return languages;
    }

    public void setLanguages(ArrayList<String> languages) {
        this.languages = languages;
    }

    public void createProject(Project project) throws ProjectDoesNotExistException{
        if (project == null){
            throw new ProjectDoesNotExistException();
        }
        System.out.println("The frontend engineer is creating the frontend...\n");
        int i = 0;
        while (languages.size() > i){
            logger.info(languages.get(i));
            i++;
        }
        logger.info("\nThe frontend engineer is done creating the frontend.\n");
    }

}
