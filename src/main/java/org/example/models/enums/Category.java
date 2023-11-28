package org.example.models.enums;

public enum Category {
    Car(1), Bus(2), Truck(3), Motorcycle(4);

    private final int description;

    private Category(int description){
        this.description = description;
    }

    public int getDescription() {
        return description;
    }
};