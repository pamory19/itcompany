package com.solvd.itcompany;

import com.solvd.itcompany.exceptions.ProjectDoesNotExistException;

public interface IWork {
    public void createProject(Project project) throws ProjectDoesNotExistException;

}
