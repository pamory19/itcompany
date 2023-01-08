package com.solvd.itcompany;

import java.util.ArrayList;

import static com.solvd.itcompany.IRelease.released;

class Release {
    private static ArrayList <String> userFeedback;

    public Release(){

    }

    public Release(ArrayList<String> user_Feedback) {
        userFeedback = user_Feedback;
    }

    static public boolean isReleased() {
        return released;
    }

    static public ArrayList<String> getUserFeedback() {
        return userFeedback;
    }

    static public void setUserFeedback(ArrayList<String> user_Feedback) {
        userFeedback = user_Feedback;
    }
}
