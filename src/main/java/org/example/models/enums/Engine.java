package org.example.models.enums;

public enum Engine{
    GASOLINE("Gasoline"), DIESEL("Disel"), ELECTRIC("Electric"), HYBRID("Hybrid");
    private final String description;

    private Engine(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
};