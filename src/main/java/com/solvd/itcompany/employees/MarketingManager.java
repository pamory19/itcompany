package com.solvd.itcompany.employees;

import com.solvd.itcompany.Project;
import com.solvd.itcompany.enums.ExperienceLevel;
import com.solvd.itcompany.exceptions.ProjectDoesNotExistException;

import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MarketingManager extends Employee {
    private ArrayList <String> marketingStrategy;
    private static final Logger logger = LogManager.getLogger(MarketingManager.class);

    public MarketingManager(String name, boolean working, ArrayList <String> marketingStrategy, String certification, String title, ExperienceLevel experienceLevel) {
        this.setName(name);
        this.setWorking(working);
        this.marketingStrategy = marketingStrategy;
        this.setCertification(certification);
        this.setTitle(title);
        this.setExperienceLevel(experienceLevel);
    }

    public MarketingManager(String name, boolean working, String employeeID, String certification, ArrayList <String> marketingStrategy, ExperienceLevel experienceLevel) {
        this.setName(name);
        this.setWorking(working);
        this.setEmployeeID(employeeID);
        this.setCertification(certification);
        this.setExperienceLevel(experienceLevel);
        this.marketingStrategy = marketingStrategy;
    }

    public ArrayList <String> getMarketingStrategy() {
        return marketingStrategy;
    }

    public void setMarketingStrategy(ArrayList <String> marketingStrategy) {
        this.marketingStrategy = marketingStrategy;
    }

    public void createProject(Project project) throws ProjectDoesNotExistException {
        if (project == null){
            throw new ProjectDoesNotExistException();
        }
        logger.info("The marketing manager is creating the promotional plan...\n");
        int i = 0;
        while (marketingStrategy.size() > i){
            logger.info(marketingStrategy.get(i));
            i++;
        }
        logger.info("\nThe the Marketing Manager is done promoting the application.\n");
    }
}
