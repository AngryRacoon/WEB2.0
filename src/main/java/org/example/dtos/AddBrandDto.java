package org.example.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.example.models.Model;
import org.example.util.UniqueBrandName;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

public class AddBrandDto {

    @UniqueBrandName
    private String  name;

    public AddBrandDto(){}

    public AddBrandDto(String name){
        this.name = name;
    }

    @NotEmpty(message = "Brand name must not be null or empty!")
    @Size(min = 2, max = 10, message = "Brand name must be between 2 and 10 characters!")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
