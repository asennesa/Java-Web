package com.example.demo.model.service;

import com.example.demo.model.entity.Category;
import com.example.demo.model.entity.Gender;

import java.math.BigDecimal;

public class ItemServiceModel extends BaseServiceModel {
    private String name;
    private String description;
    private BigDecimal price;
    private Category category;
    private Gender gender;

    public ItemServiceModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
