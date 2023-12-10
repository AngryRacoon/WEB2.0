package org.example.dtos;

import org.example.models.Model;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

public class BrandDto {
    private UUID id;
    private String  name;
    private Date created;
    private Date modified;
    private Set<LightModelDto> models;

    public BrandDto(){}

    public BrandDto(String name){
        this.name = name;
        this.created = new Date();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Set<LightModelDto> getModels() {
        return models;
    }

    public void setModels(Set<LightModelDto> models) {
        this.models = models;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
