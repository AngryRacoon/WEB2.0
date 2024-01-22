package org.example.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.example.models.enums.Engine;
import org.example.models.enums.Transmission;

import java.math.BigDecimal;
import java.util.UUID;

public class EditOfferDto {
        private UUID id;
        private String description;
        private Engine engine;
        private String imageUrl;
        private int mileage;
        private BigDecimal price;
        private Transmission transmission;
        private int year;
        private UUID model;
        private UUID user;

    public EditOfferDto() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @NotEmpty(message = "Description cannot be empty")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
@NotNull(message = "Engine cannot be null")
    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
@NotEmpty(message = "Image URL cannot be empty")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
@NotNull(message = "Mileage cannot be null")
    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
@NotNull(message = "Price cannot be null")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
@NotNull(message = "Transmission cannot be null")
    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }
@NotNull(message = "Year cannot be null")
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
@NotNull(message = "Model cannot be null")
    public UUID getModel() {
        return model;
    }

    public void setModel(UUID model) {
        this.model = model;
    }
@NotNull(message = "User cannot be null")
    public UUID getUser() {
        return user;
    }

    public void setUser(UUID user) {
        this.user = user;
    }
}
