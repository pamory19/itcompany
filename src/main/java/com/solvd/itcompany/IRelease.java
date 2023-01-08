package com.solvd.itcompany;

import java.util.logging.Logger;

public interface IRelease {
    static final Logger logger = Logger.getLogger("IRelease.class");
    boolean released = true;
    public void releaseApp();
}