package com.example.demo.repository;

import com.example.demo.model.entity.User;
import com.example.demo.model.service.UserServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {


}
