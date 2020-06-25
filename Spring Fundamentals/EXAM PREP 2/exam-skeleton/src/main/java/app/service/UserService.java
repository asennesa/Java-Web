package app.service;

import app.model.service.UserServiceModel;
import org.springframework.stereotype.Service;


public interface UserService {
    UserServiceModel register(UserServiceModel userServiceModel);

    UserServiceModel findByUsername(String username);
}
