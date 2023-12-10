package org.example.models.enums;

public enum  Transmission {
    MANUAL(1), AUTOMATIC(2);

    private final int description;

    private Transmission(int description) {
        this.description = description;
    }

    public int getDescription() {
        return description;
    }
}