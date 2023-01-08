package com.solvd.itcompany.lambdas;

import java.util.List;

@FunctionalInterface
public interface ProjectInformation<T> {
    public void getProjectInformation(List<T> p);
}
