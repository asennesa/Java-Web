package com.example.demo.service;

import com.example.demo.model.entity.Role;
import com.example.demo.model.entity.User;
import com.example.demo.model.service.UserServiceModel;
import com.example.demo.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleService roleService, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {
        userServiceModel.setRole(this.roleService.findByName(this.userRepository.count() == 0 ? "ADMIN" : "USER"));
        User user = this.modelMapper.map(userServiceModel, User.class);

        return this.modelMapper.map(this.userRepository.saveAndFlush(user), UserServiceModel.class);
    }

    @Override
    public UserServiceModel findByUsername(String username) {
        return this.userRepository.findByUsername(username)
                .map(user -> this.modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public List<String> findAllUsernames() {
        return this.userRepository.findAll()
                .stream().map(user -> user.getUsername()).collect(Collectors.toList());
    }

    @Override
    public void addRoleToUser(String username, String role) {
        User user = this.userRepository.findByUsername(username).orElse(null);
        if (!user.getRole().getName().equals(role)) {
            Role roleEntity = this.modelMapper.map(this.roleService.findByName(role), Role.class);

            user.setRole(roleEntity);
            this.userRepository.saveAndFlush(user);

        }
    }
}
