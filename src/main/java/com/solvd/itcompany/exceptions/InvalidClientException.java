package com.solvd.itcompany.exceptions;

public class InvalidClientException extends Exception {
    public InvalidClientException(){
        super("The information for the client is invalid.");
    }
}
