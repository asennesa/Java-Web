package com.example.demo.model.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import java.math.BigDecimal;

@Entity
@Table(name ="users")
public class User extends BaseEntity {
    private String username;
    private String password;
    private String email;
    private BigDecimal budget;

    public User() {
    }
    @Column(name ="username",unique = true)
    @Length(min=3,message = "Username length must be more than two characters")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Column(name ="password")
    @Length(min=3,message = "Password length must be more than two characters")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Column(name = "email")
    @Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Column(name = "budget")
    @DecimalMin(value = "0",message = "Must be a positive number")
    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }
}
