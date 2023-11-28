package org.example.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "brands")
public class Brand extends BaseEntity{

    private String name;


    private Date created;


    private Date modified;


    private Set<Model> models;

    public Brand(){}
    public Brand(String name, Set<Model> models){
        this.name = name;
        this.models = models;
    }

    @Column(name = "brand", nullable = false)
    public String getBrand() {
        return name;
    }

    public void setBrand(String brand) {
        this.name = brand;
    }
    @Column(name = "modified")
    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    @Column(name = "created")
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "brand", cascade = CascadeType.REMOVE)
    public Set<Model> getModels() {
        return models;
    }

    public void setModels(Set<Model> models) {
        this.models = models;
    }
}
