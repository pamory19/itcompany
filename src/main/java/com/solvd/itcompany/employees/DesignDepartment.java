package com.solvd.itcompany.employees;

import com.solvd.itcompany.IUpdate;

import java.util.ArrayList;


public class DesignDepartment extends Department {
    private ArrayList<Employee> designEmployees;


    public DesignDepartment() {

    }

    public DesignDepartment(String departmentName, ArrayList<String> tools, ArrayList<Employee> employees, boolean isWorking, ArrayList<Employee> designEmployees) {
        this.setDepartmentName(departmentName);
        this.setTools(tools);
        this.setDesignEmployees(employees);
        this.setWorking(isWorking);
        this.designEmployees = designEmployees;
    }

    public ArrayList<Employee> getDesignEmployees() {
        return designEmployees;
    }

    public void setDesignEmployees(ArrayList<Employee> designEmployees) {
        this.designEmployees = designEmployees;
    }


    public void addDesigningEmployees(Designer designer) {
        if (designer.isWorking() == false) {
            designEmployees.add(designer);
        }
    }

    public String statusUpdate(){
        return update + "\nDesign employees:\n " + designEmployees;
    }

}
