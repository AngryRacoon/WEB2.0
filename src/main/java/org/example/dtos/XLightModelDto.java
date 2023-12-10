package org.example.dtos;

import org.example.models.enums.Category;

import java.util.UUID;

public class XLightModelDto {
    private UUID id;
    private String name;
    private Category category;

    private LightBrandDto brand;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public LightBrandDto getBrand() {
        return brand;
    }

    public void setBrand(LightBrandDto brand) {
        this.brand = brand;
    }

    public XLightModelDto(){}
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }





}
