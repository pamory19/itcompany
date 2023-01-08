package com.solvd.itcompany.exceptions;

public class InsufficientBudgetException extends Exception {
    public InsufficientBudgetException(){
        super("The project's budget is too low.");
    }
}
