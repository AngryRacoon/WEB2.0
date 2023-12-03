package org.example.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.example.util.UniqueBrandName;

import java.util.UUID;

public class LightBrandDto {
    private UUID id;
    @UniqueBrandName
    private String  name;

    public LightBrandDto(){}

    public LightBrandDto(String name){
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
