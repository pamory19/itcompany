package com.solvd.itcompany.exceptions;

public class EmployeeShortageException extends Exception {
    public EmployeeShortageException(){
        super("There are not enough employees to complete the project.");
    }
}
