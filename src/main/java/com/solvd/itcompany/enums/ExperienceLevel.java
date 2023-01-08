package com.solvd.itcompany.enums;

public enum ExperienceLevel {
    ENTRY_LEVEL(1),
    MID_LEVEL(4),
    SENIOR_LEVEL(6);

    private int yearsOfExperience;

    ExperienceLevel(int yearsOfExperience){
        this.yearsOfExperience = yearsOfExperience;
    }
}
