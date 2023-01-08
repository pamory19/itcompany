package com.solvd.itcompany.generics;

import com.solvd.itcompany.employees.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Set;

public class EmployeeHashmap<K, V> extends HashMap {
    private HashMap<K, V> employees;
    private static final Logger logger = LogManager.getLogger(EmployeeHashmap.class);

    public EmployeeHashmap() {

    }

    public EmployeeHashmap(HashMap<K, V> employees) {
        this.employees = employees;
    }

    public HashMap<K, V> getEmployees() {
        return employees;
    }

    public void setEmployees(HashMap<K, V> employees) {
        this.employees = employees;
    }

    public void listOfEmployees(HashMap<String, Employee> employees){
        logger.info("\nList of employees working on the project: ");
        Set<Entry<String, Employee>> entries = employees.entrySet();
        for (Entry<String, Employee> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue().getName();
            logger.info("\n" + key + ": " + value);
        }
    }
}
