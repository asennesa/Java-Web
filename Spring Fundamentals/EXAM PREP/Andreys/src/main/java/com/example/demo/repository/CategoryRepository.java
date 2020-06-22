package com.example.demo.repository;

import com.example.demo.model.entity.Category;
import com.example.demo.model.entity.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,String> {

    Optional<Category> findByCategoryName(CategoryName categoryName);



}
