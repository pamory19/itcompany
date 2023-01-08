package com.solvd.itcompany;

import com.solvd.itcompany.employees.Employee;
import com.solvd.itcompany.enums.ProjectStatus;
import com.solvd.itcompany.exceptions.EmployeeShortageException;
import com.solvd.itcompany.exceptions.EmptyEmployeeListException;
import com.solvd.itcompany.exceptions.InsufficientBudgetException;
import com.solvd.itcompany.exceptions.ProjectDoesNotExistException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;


public class ITCompany implements IRelease {
    private String name;
    private ArrayList<Employee> employees;
    private ArrayList<String> clients;
    private ArrayList<Project> projects;
    private ProjectStatus projectStatus;
    private static final Logger logger = LogManager.getLogger(ITCompany.class);





    public ITCompany() {
    }


    public ITCompany(String name, ArrayList<Employee> employees, ArrayList<String> clients, ArrayList<Project> projects, ProjectStatus projectStatus) {
        this.name = name;
        this.employees = employees;
        this.clients = clients;
        this.projects = projects;
        this.projectStatus = projectStatus;
    }

    public ITCompany(String name, ArrayList<Employee> employees, ArrayList<Project> projects, ProjectStatus projectStatus) {
        this.name = name;
        this.employees = employees;
        this.projects = projects;
        this.projectStatus = projectStatus;
    }


    public void assignProject(Project project, ArrayList<Employee> allEmployees, ProjectStatus projectStatus) throws EmptyEmployeeListException, InsufficientBudgetException {
        if (allEmployees.isEmpty()){
            throw new EmptyEmployeeListException();
        }
        if (project.getBudget() < project.getPrice()){
            throw new InsufficientBudgetException();
        }
        if (project.getBudget() >= project.getPrice()) {
            System.out.println(project.toString());
            System.out.println("\nAdding the employees to the project:");
            for (Employee e : allEmployees){
                if (!e.isWorking()){
                    if (e.getTitle() == "Manager"){
                        logger.info("\nThe project managers have been added to the project.");
                    }
                    else if (e.getTitle() == "Designer"){
                        logger.info("\nThe designers have been added to the project.");
                    }
                    else if (e.getTitle() == "Backend") {
                        logger.info("\nThe backend engineers have been added to the project.");
                    }
                    else if (e.getTitle() == "Frontend") {
                        logger.info("\nThe frontend engineers have been added to the project.");
                    }
                    else if (e.getTitle() == "IOS") {
                        logger.info("\nThe IOS developers have been added to the project.");
                    }
                    else if (e.getTitle() == "Quality") {
                        logger.info("\nThe quality analysts have been added to the project.");
                    }
                    else if (e.getTitle() == "Marketing") {
                        logger.info("\nThe marketers have been added to the project.\n");
                    }
                }
            }
            projectStatus = ProjectStatus.IN_PROGRESS;
            logger.info("\nStatus of Project: " + projectStatus);
        }
    }


    public void projectCreated(Project project, ArrayList<Employee> allEmployees) throws EmptyEmployeeListException, EmployeeShortageException {
        if (allEmployees.isEmpty()){
            throw new EmptyEmployeeListException();
        }
        if (allEmployees.size() < 7){
            throw new EmployeeShortageException();
        }
        try{
            for (Employee e : allEmployees){
                if (e.getTitle() == "Manager"){
                    e.createProject(project);
                }
                else if (e.getTitle() == "Designer") {
                    e.createProject(project);
                }
                else if (e.getTitle() == "Engineer") {
                    e.createProject(project);
                }
                else if (e.getTitle() == "Quality") {
                    e.createProject(project);
                }
                else if (e.getTitle() == "Marketing") {
                    e.createProject(project);
                }
            }
        }
        catch(ProjectDoesNotExistException e){
            logger.error(e.getMessage());
        }
        ProjectStatus projectStatus = ProjectStatus.COMPLETE;
        logger.info("\nStatus of Project: " + projectStatus);
    }

    public void releaseApp(){
        if (Release.isReleased()){
            logger.info("Here is the user feedback we've received so far: ");
            int i = 0;
            while (Release.getUserFeedback().size() > i){
                logger.info(Release.getUserFeedback().get(i));
                i++;
            }
            logger.info("\nThe application has been released.");
        }
        else{
            logger.info("\nThe application has not been released yet.");
        }
    }

    public void maintenance(){
        logger.info("\nWhile the application is completed the engineering team will continuously maintain the application.");
    }


    public final void intro(){
        logger.info("The IT Company has a request to start a project.");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public ArrayList<String> getClients() {
        return clients;
    }

    public void setClients(ArrayList<String> clients) {
        this.clients = clients;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    public ProjectStatus getProjectStatus() {
        return projectStatus;
    }
}
