package org.example.dtos;


import org.example.models.enums.Engine;
import org.example.models.enums.Transmission;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

public class OfferDto {

    private UUID id;
    private String description;
    private Engine engine;
    private String imageUrl;
    private int mileage;
    private BigDecimal price;
    private Transmission transmission;


    private Date created;
    private Date modified;
    private int year;
    private XLightModelDto model;

    private LightUserDto user;

    public OfferDto (){}

    public Date getCreated() {
        return created;
    }

    public Date getModified() {
        return modified;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public LightUserDto getUser() {
        return user;
    }

    public void setUser(LightUserDto user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public XLightModelDto getModel() {
        return model;
    }

    public void setModel(XLightModelDto model) {
        this.model = model;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }
}
