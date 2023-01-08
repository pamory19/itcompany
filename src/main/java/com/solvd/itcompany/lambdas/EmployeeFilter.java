package com.solvd.itcompany.lambdas;


import java.util.ArrayList;

@FunctionalInterface
public interface EmployeeFilter<T> {
    boolean filter(T employee);
}
