package com.solvd.itcompany.exceptions;

public class ProjectDoesNotExistException extends Exception {
    public ProjectDoesNotExistException(){
        super("The project does not exist.");
    }
}
