package org.example.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "brands")
public class Brand extends BaseEntity{
    @Column(name = "brand", nullable = false)
    private String name;

    @Column(name = "created")
    private Date created;

    @Column(name = "modified")
    private Date modified;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "brand", cascade = CascadeType.REMOVE)
    private Set<Model> models;

    public Brand(){}
    public Brand(String name, Set<Model> models){
        this.name = name;
        this.models = models;
    }

    public String getBrand() {
        return name;
    }

    public void setBrand(String brand) {
        this.name = brand;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Set<Model> getModels() {
        return models;
    }

    public void setModels(Set<Model> models) {
        this.models = models;
    }
}
