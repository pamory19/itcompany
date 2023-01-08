package com.solvd.itcompany.lambdas;


@FunctionalInterface
public interface EmployeeName<T> {
    String getName(T employee);
}
