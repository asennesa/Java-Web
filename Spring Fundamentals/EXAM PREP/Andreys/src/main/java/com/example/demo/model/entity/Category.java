package com.example.demo.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Category extends BaseEntity {
    private Name name;
    private String description;

    public Category() {
    }
    @Column(name ="name")
    @Enumerated
    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
