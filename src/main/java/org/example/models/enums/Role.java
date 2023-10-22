package org.example.models.enums;

public enum Role{
    USER("User"), ADMIN("Admin");
    private final String description;

    private Role(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}