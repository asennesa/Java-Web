package com.example.demo.service;

import com.example.demo.model.service.UserServiceModel;

public interface UserService {
    UserServiceModel findByUsername(String username);
    UserServiceModel register(UserServiceModel userServiceModel);
}
