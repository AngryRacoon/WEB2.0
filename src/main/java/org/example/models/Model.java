package org.example.models;

import jakarta.persistence.*;
import org.example.models.enums.Category;
import org.hibernate.annotations.Cascade;

import java.util.Date;
import java.util.Set;
@Entity

@Table(name = "models")
public class Model extends BaseEntity{
    @Column (name = "name", length = 255, nullable = false)
    private String name;


    @Enumerated(EnumType.ORDINAL)
    @Column(name = "category")
    private Category category;
    @Column(name = "imageUrl", length = 255, nullable = false)
    private String imageUrl ;

    @Column(name = "startYear")
    private int startYear;

    @Column(name = "endYear")
    private int endYear;

    @Column(name = "created")
    private Date created;

    @Column(name = "modified")
    private Date modified;

    @ManyToOne(optional = false)
    @JoinColumn(name = "brand_id", referencedColumnName = "id", nullable=false)
    private Brand brand;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "model", cascade = CascadeType.REMOVE)
    Set<Offer> offers;

    public Model(){}
    public Model(String name, Category category, String imageUrl, int startYear, int endYear, Date created, Date modified,
                 Brand brand, Set<Offer> offers){
        this.name = name;
        this.category = category;
        this.imageUrl = imageUrl;
        this.startYear = startYear;
        this.endYear = endYear;
        this.created = created;
        this.modified = modified;
        this.brand = brand;
        this.offers = offers;

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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
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

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }
}
