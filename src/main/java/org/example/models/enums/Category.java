package org.example.models.enums;

public enum Category {
    Car("Car"), Bus("Bus"), Truck("Truck"), Motorcycle("Motorcycle");

    private final String description;

    private Category(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
};