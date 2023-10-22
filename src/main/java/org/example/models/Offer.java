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
    @Column(name = "description", length = 255, nullable = false)
    private String description ;

    @Enumerated(EnumType.ORDINAL) // Сообщает JPA использовать строковое представление перечислений
    @Column(name = "engine")
    private Engine engine;

    @Column(name = "imageUrl", length = 255, nullable = false)
    private String imageUrl;

    @Column(name = "mileage")
    private int mileage;

    @Column(name = "price")
    private BigDecimal price;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "transmission")
    private Transmission transmission;


    @Column(name = "year")
    private int year;

    @Column(name = "modified")
    private Date modified;

    @Column(name = "created")
    private Date created;

    @ManyToOne(optional = false)
    @JoinColumn(name = "model_id", referencedColumnName = "id", nullable=false)
    private Model model;


    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable=false)
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreated() {
        return created;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Date getModified() {
        return modified;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
