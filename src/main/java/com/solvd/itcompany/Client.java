package com.solvd.itcompany;

import com.solvd.itcompany.exceptions.InvalidClientException;

import java.util.Objects;

public class Client {

    private String name;
    private String idea;
    private int yearsInBusiness;

    public Client(String name, String idea, int yearsInBusiness) {
        this.name = name;
        this.idea = idea;
        this.yearsInBusiness = yearsInBusiness;
    }

    public Client(String name, String idea) throws InvalidClientException {
        if ((name == null) && (idea == null)){
            throw new InvalidClientException();
        }
        this.name = name;
        this.idea = idea;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdea() {
        return idea;
    }

    public void setIdea(String idea) {
        this.idea = idea;
    }

    public int getYearsInBusiness() {
        return yearsInBusiness;
    }

    public void setYearsInBusiness(int yearsInBusiness) {
        this.yearsInBusiness = yearsInBusiness;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.name, this.idea);
    }

    @Override
    public boolean equals(Object obj){
        if (obj == this){
            return true;
        }
        if (obj == null){
            return false;
        }
        if (!(obj instanceof Client)){
            return false;
        }
        Client client = (Client) obj;
        return idea == client.idea;
    }


}
