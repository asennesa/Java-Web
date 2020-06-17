package com.example.demo.model.service;

import com.example.demo.model.entity.Exercise;
import com.example.demo.model.entity.User;

import java.time.LocalDateTime;

public class HomeworkServiceModel extends BaseServiceModel {
    private LocalDateTime addedOn;
    private String gitAddress;
    private UserServiceModel Author;
    private ExerciseServiceModel exercise;

    public HomeworkServiceModel() {
    }

    public LocalDateTime getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(LocalDateTime addedOn) {
        this.addedOn = addedOn;
    }

    public String getGitAddress() {
        return gitAddress;
    }

    public void setGitAddress(String gitAddress) {
        this.gitAddress = gitAddress;
    }

    public UserServiceModel getAuthor() {
        return Author;
    }

    public void setAuthor(UserServiceModel author) {
        Author = author;
    }

    public ExerciseServiceModel getExercise() {
        return exercise;
    }

    public void setExercise(ExerciseServiceModel exercise) {
        this.exercise = exercise;
    }
}
