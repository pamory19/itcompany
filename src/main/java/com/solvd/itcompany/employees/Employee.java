package com.solvd.itcompany.employees;

import com.solvd.itcompany.IWork;
import com.solvd.itcompany.enums.ExperienceLevel;
import com.solvd.itcompany.lambdas.EmployeeFilter;
import com.solvd.itcompany.lambdas.EmployeeName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public abstract class Employee implements IWork {
    private String name;
    private boolean isWorking;
    private String employeeID;
    private String certification;
    private ExperienceLevel experienceLevel;
    private String title;
    private String task;
    private static final Logger logger = LogManager.getLogger(Employee.class);

    public Employee() {

    }

    public Employee(String name, boolean working, String title) {
        this.name = name;
        this.isWorking = working;
        this.title = title;
    }

    public Employee(String name, boolean working, String employeeID, String certification, ExperienceLevel experienceLevel, String title, String task) {
        this.name = name;
        this.isWorking = working;
        this.employeeID = employeeID;
        this.certification = certification;
        this.experienceLevel = experienceLevel;
        this.title = title;
        this.task = task;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public ExperienceLevel getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(ExperienceLevel experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public static <T> void printEmployeeName(List<T> employees, EmployeeName<T> employeeName){
        for (T employee : employees){
            logger.info("Employee name: " + employeeName.getName(employee));
        }
    }

    public static <T> void printFilteredEmployees(List<T> employees, EmployeeFilter<T> filter){
        for (T employee : employees){
            if (filter.filter(employee)){
                logger.info(employee);
            }
        }
    }
}
