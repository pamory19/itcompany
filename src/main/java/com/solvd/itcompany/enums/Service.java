package com.solvd.itcompany.enums;

public enum Service {
    APP_DEVELOPMENT(1000.00, "create an application for your business."),
    WEB_DEVELOPMENT(1500.00, "Create a website for your business."),
    E_COMMERCE(2000, "Create an e-commerce website.");

    private double price;
    private String description;

    Service(double price, String description){
        this.price = price;
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
