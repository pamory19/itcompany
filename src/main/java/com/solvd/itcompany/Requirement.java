package com.solvd.itcompany;

import java.util.ArrayList;

class Requirement implements IFulfillRequirements {
    private static ArrayList <String> features;

    public Requirement(ArrayList<String> userFeatures) {
        features = userFeatures;
    }

    static public ArrayList<String> getFeatures() {
        return features;
    }

    static public void setFeatures(ArrayList<String> userFeatures) {
        features = userFeatures;
    }
}
