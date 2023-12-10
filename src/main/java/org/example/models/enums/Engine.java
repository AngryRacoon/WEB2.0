package org.example.models.enums;

public enum Engine{
    GASOLINE(1), DIESEL(2), ELECTRIC(3), HYBRID(4);
    private final int description;

    private Engine(int description){
        this.description = description;
    }

    public int getDescription() {
        return description;
    }
};