package com.example.springmvc.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.Date;

@Entity
@Table(name = "offer")
public class Offer extends BaseEntity {
    private String description;
    private Engine engine;
    private String imageUrl;
    private Double mileage;
    private BigDecimal price;
    private Transmission transmission;
    private Year year;
    private LocalDateTime created;
    private LocalDateTime modified;
    private Model model;
    private User seller;

    public Offer() {
    }
    @Column(name = "description",columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Enumerated
    @Column(name="engine")
    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    @Column(name="image_Url")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    @Column(name="mileage")
    public Double getMileage() {
        return mileage;
    }

    public void setMileage(Double mileage) {
        this.mileage = mileage;
    }
    @Column(name="price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    @Enumerated
    @Column(name="transmission")
    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }
    @Column(name="year")
    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }
    @Column(name="created")
    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
    @Column(name="modified")
    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }
    @ManyToOne
    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
    @ManyToOne
    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }
    //•	id – uuid or number.
    //•	description – some text.
    //•	engine – enumerated value.
    //•	imageUrl – the url of image.
    //•	mileage – a number.
    //•	price – the price of the offer.
    //•	transmission – enumerated value.
    //•	year – the year of offered car.
    //•	created – a date and time.
    //•	modified – a date and time.
    //•	model – the model of a car.
    //•	seller – a user that sells the car.

}
