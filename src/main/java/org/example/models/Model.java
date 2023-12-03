package org.example.models;

import jakarta.persistence.*;
import org.example.models.enums.Category;
import org.hibernate.annotations.Cascade;

import java.util.Date;
import java.util.Set;
@Entity

@Table(name = "models")
public class Model extends BaseEntity{
    private String name;
    private Category category;
    private String imageUrl ;
    private int startYear;
    private int endYear;
    private Date created;
    private Date modified;
    private Brand brand;
    Set<Offer> offers;

    public Model(){}
    public Model(String name, Category category, String imageUrl, int startYear, int endYear, Date created, Date modified,
                 Brand brand, Set<Offer> offers){
        this.name = name;
        this.category = category;
        this.imageUrl = imageUrl;
        this.startYear = startYear;
        this.endYear = endYear;
        this.created = new Date();
        this.modified = modified;
        this.brand = brand;
        this.offers = offers;

    }

    @Column (name = "name", length = 255, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "category")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Column(name = "imageUrl", length = 255, nullable = false)

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    @Column(name = "startYear")
    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    @Column(name = "endYear")
    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
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

    @ManyToOne(optional = false)
    @JoinColumn(name = "brand_id", referencedColumnName = "id", nullable=false)
    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "model", cascade = CascadeType.REMOVE)
    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }
}
