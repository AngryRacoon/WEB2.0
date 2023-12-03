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

public class LightModelDto {
    private String name;
    private Category category;

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



    public LightModelDto(){}


}
