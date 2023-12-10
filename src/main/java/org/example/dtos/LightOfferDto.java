package org.example.dtos;

import java.math.BigDecimal;
import java.util.UUID;

public class LightOfferDto {
    private UUID id;
    private String imageUrl;
    private BigDecimal price;
    private int year;
    private XLightModelDto model;
    private LightUserDto user;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public XLightModelDto getModel() {
        return model;
    }

    public void setModel(XLightModelDto model) {
        this.model = model;
    }

    public LightUserDto getUser() {
        return user;
    }

    public void setUser(LightUserDto user) {
        this.user = user;
    }
}
