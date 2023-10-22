package org.example.dtos;

import org.example.models.Model;
import org.example.models.enums.Category;

import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;

public class ModelDto {
        private UUID id;
        private String name;
        private Category category;
        private String imageUrl;
        private int startYear;
        private int endYear;
        private Date created;

        private  Date modified;
        private BrandDto brand;
        private Set<OfferDto> offer;

        public ModelDto(){}

        public  ModelDto(String name, Category category, String imageUrl, int startYear, int endYear,
         BrandDto brand){
            this.name = name;
            this.category = category;
            this.imageUrl = imageUrl;
            this.startYear = startYear;
            this.endYear = endYear;
            this.created = new Date();
            this.brand = brand;
        }

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

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public BrandDto getBrand() {
        return brand;
    }

    public void setBrand(BrandDto brand) {
        this.brand = brand;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public Set<OfferDto> getOffer() {
        return offer;
    }

    public void setOffer(Set<OfferDto> offer) {
        this.offer = offer;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
