package com.example.demo.service;

import com.example.demo.model.entity.Category;
import com.example.demo.model.entity.CategoryName;

public interface CategoryService {
    void checkIfEmpty();
    Category find(CategoryName categoryName);
}
