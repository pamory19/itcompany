package com.solvd.itcompany.employees;

import com.solvd.itcompany.IUpdate;

import java.util.ArrayList;


public abstract class Department implements IUpdate {
    private ArrayList <String> tools;
    private static ArrayList<Employee> allEmployees;
    private boolean isWorking;
    private String departmentName;

    public Department(){

    }

    public Department(String departmentName, ArrayList<String> tools, ArrayList<Employee> employees, boolean isWorking) {
        this.departmentName = departmentName;
        this.tools = tools;
        allEmployees = employees;
        this.isWorking = isWorking;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public ArrayList<String> getTools() {
        return tools;
    }

    public void setTools(ArrayList<String> tools) {
        this.tools = tools;
    }

    public static ArrayList<Employee> getEmployees() {
        return allEmployees;
    }

    public static void setEmployees(ArrayList<Employee> employees) {
        allEmployees = employees;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }

    public static ArrayList<Employee> getAllEmployees() {
        return allEmployees;
    }

    public static void setAllEmployees(ArrayList<Employee> allEmployees) {
        Department.allEmployees = allEmployees;
    }

}
