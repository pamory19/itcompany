package com.solvd.itcompany.exceptions;

public class EmptyEmployeeListException extends Exception {
    public EmptyEmployeeListException(){
        super("The project cannot be built because there are no employees working on the project.");
    }
}
