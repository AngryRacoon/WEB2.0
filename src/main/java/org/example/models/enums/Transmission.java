package org.example.models.enums;

public enum  Transmission {
    MANUAL("Manual"), AUTOMATIC("Auto");

    private final String description;

    private Transmission(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}