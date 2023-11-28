package org.example.models;

import jakarta.persistence.*;
import org.example.models.enums.Engine;
import org.example.models.enums.Transmission;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity
{
    private String description ;
    private Engine engine;
    private String imageUrl;
    private int mileage;
    private BigDecimal price;
    private Transmission transmission;
    private int year;
    private Date modified;
    private Date created;
    private Model model;
    private User user;
    public Offer(){}

    public Offer(String description,Engine engine, String imageUrl, int mileage, BigDecimal price,
                 Transmission transmission,int year, Model model, User user, Date modified, Date created){
        this.description = description;
        this.engine = engine;
        this.imageUrl = imageUrl;
        this.mileage = mileage;
        this.price = price;
        this.transmission = transmission;
        this.year = year;
        this.model = model;
        this.user = user;
        this.created = created;
        this.modified = modified;
    }
    @Column(name = "description", length = 255, nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Enumerated(EnumType.ORDINAL) // Сообщает JPA использовать строковое представление перечислений.
    @Column(name = "engine")
    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    @Column(name = "imageUrl", length = 255, nullable = false)
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    @Column(name = "mileage")
    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Column(name = "year")
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "model_id", referencedColumnName = "id", nullable=false)
    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "transmission")
    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable=false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "created")
    public Date getCreated() {
        return created;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    @Column(name = "modified")
    public Date getModified() {
        return modified;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
