package com.solvd.itcompany;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface IFulfillRequirements {
    static final Logger logger = LogManager.getLogger(IFulfillRequirements.class);
    static public void reviewRequirements(){
        logger.info("Here are the requirements for the application: ");
        int i = 0;
        while (Requirement.getFeatures().size() > i){
            logger.info(Requirement.getFeatures().get(i));
            i++;
        }
        logger.info("The IT company has completed reviewing the requirements for the application.\n");
    }
}
