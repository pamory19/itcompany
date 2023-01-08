package com.solvd.itcompany.employees;

import java.util.ArrayList;

public class EngineeringDepartment extends Department {
    private ArrayList <Employee> engineeringEmployees;

    public EngineeringDepartment() {

    }
    public EngineeringDepartment(String departmentName, ArrayList<Employee> engineeringEmployees) {
        this.setDepartmentName(departmentName);
        this.engineeringEmployees = engineeringEmployees;
    }

    public ArrayList<Employee> getEngineeringEmployees() {
        return engineeringEmployees;
    }

    public void setEngineeringEmployees(ArrayList<Employee> engineeringEmployees) {
        this.engineeringEmployees = engineeringEmployees;
    }


    public void addEngineeringEmployees(ProjectManager projectManager, BackendEngineer backendEngineer, FrontendEngineer frontendEngineer, IOSDeveloper iosDeveloper , QualityAnalyst qualityAnalyst){
        if (projectManager.isWorking() == false){
            engineeringEmployees.add(projectManager);
        }
        if (backendEngineer.isWorking() == false){
            engineeringEmployees.add(backendEngineer);
        }
        if (frontendEngineer.isWorking() == false){
            engineeringEmployees.add(frontendEngineer);
        }
        if (iosDeveloper.isWorking() == false){
            engineeringEmployees.add(iosDeveloper);
        }
        if (qualityAnalyst.isWorking() == false){
            engineeringEmployees.add(qualityAnalyst);
        }
    }

    public String statusUpdate(){
        return update + "\nEngineering employees:\n " +  engineeringEmployees;
    }
}
