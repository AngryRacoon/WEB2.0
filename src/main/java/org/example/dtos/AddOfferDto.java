package org.example.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.example.models.enums.Engine;
import org.example.models.enums.Transmission;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class AddOfferDto {
        private String description;
        private Engine engine;
        private String imageUrl;
        private int mileage;
        private BigDecimal price;
        private Transmission transmission;
        private int year;
        private UUID model;
        private String user;
        public AddOfferDto() {
        }

    public AddOfferDto(String description, Engine engine, String imageUrl, int mileage, BigDecimal bigDecimal, Transmission transmission, int year, String model, String user) {
        this.description = description;
        this.engine = engine;
        this.imageUrl = imageUrl;
        this.mileage = mileage;
        this.price = bigDecimal;
        this.transmission = transmission;
        this.year = year;
        this.model = UUID.fromString(model);
        this.user = user;
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
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
