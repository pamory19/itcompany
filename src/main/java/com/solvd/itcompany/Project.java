package com.solvd.itcompany;

import com.solvd.itcompany.enums.ProjectStatus;
import com.solvd.itcompany.enums.Service;
import com.solvd.itcompany.lambdas.ProjectInformation;
import com.solvd.itcompany.lambdas.EmployeeFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


public class Project {
    private double budget;
    private double price;
    private Service service;
    private Client client;
    private ProjectStatus projectStatus;
    private static final Logger logger = LogManager.getLogger(Project.class);

    public Project(Client client, double price, double budget, Service service, ProjectStatus projectStatus) {
        this.client = client;
        this.price = service.getPrice();
        this.budget = budget;
        this.service = service;
        this.projectStatus = projectStatus;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public Service getService() {
        return service;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ProjectStatus getProjectStatus() {
        return projectStatus;
    }

    public static void printClientInformation(List<Project> projects, ProjectInformation<Project> projectInformation){
        projectInformation.getProjectInformation(projects);
    }

    @Override
    public String toString(){
        return "New project under development: \nClient: " + this.client.getName() + "\nProject Service: " + this.service  + "\nProject Budget: " + this.budget + "\nProject Price: " + this.price + "\nStatus of Project: " + this.projectStatus;
    }
}
