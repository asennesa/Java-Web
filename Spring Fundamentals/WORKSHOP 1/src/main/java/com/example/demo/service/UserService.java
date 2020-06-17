package com.example.demo.service;

import com.example.demo.model.service.UserServiceModel;

import java.util.List;

public interface UserService {
    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsername(String username);

    List<String> findAllUsernames();

    void addRoleToUser(String username, String role)    ;
}
