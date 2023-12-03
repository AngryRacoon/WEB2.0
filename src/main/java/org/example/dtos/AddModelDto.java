package org.example.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.example.models.Model;
import org.example.models.enums.Category;

import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.UUID;

public class AddModelDto {
    private String name;
    private Category category;
    private String imageUrl;
    private int startYear;
    private int endYear;
    private String brandName;


@NotEmpty(message = "Model name must not be null or empty!")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
@NotNull(message = "Category must not be null or empty!")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @NotNull(message = "Image URL must not be null or empty!")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    @Min(value = 1, message = "End year must be a positive number!")
    @NotNull(message = "End year must not be null or empty!")
    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }
    @Min(value = 1, message = "End year must be a positive number!")
    @NotNull(message = "End year must not be null or empty!")
    public int getEndYear() {
        return endYear;
    }


    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }
    @NotEmpty(message = "Brand name must not be null or empty!")
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public AddModelDto(){}

}
