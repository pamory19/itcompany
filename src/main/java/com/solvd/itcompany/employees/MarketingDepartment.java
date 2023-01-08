package com.solvd.itcompany.employees;

import java.util.ArrayList;


public class MarketingDepartment extends Department {
    private ArrayList<Employee> marketingEmployees;

    public MarketingDepartment() {

    }

    public MarketingDepartment(String departmentName, ArrayList<Employee> marketingEmployees) {
        this.setDepartmentName(departmentName);
        this.marketingEmployees = marketingEmployees;
    }

    public MarketingDepartment(String departmentName, ArrayList<String> tools, boolean isWorking, ArrayList<Employee> marketingEmployees) {
        this.setDepartmentName(departmentName);
        this.marketingEmployees = marketingEmployees;
    }

    public ArrayList<Employee> getMarketingEmployees() {
        return marketingEmployees;
    }

    public void setMarketingEmployees(ArrayList<Employee> marketingEmployees) {
        this.marketingEmployees = marketingEmployees;
    }


    public void addMarketingEmployees(MarketingManager marketingManager){
        if (marketingManager.isWorking() == false){
            marketingEmployees.add(marketingManager);
        }
    }


    public String statusUpdate(){
        return update + "\nMarketing employees:\n " + marketingEmployees;
    }

}
