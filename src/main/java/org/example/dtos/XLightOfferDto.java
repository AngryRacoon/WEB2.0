package org.example.dtos;

import java.math.BigDecimal;
import java.util.UUID;

public class XLightOfferDto {
    private UUID id;
    private String imageUrl;
    private BigDecimal price;
    private XLightModelDto model;

    public XLightOfferDto() {
    }

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

    public XLightModelDto getModel() {
        return model;
    }

    public void setModel(XLightModelDto model) {
        this.model = model;
    }
}
