package com.example.demo.service.impl;

import com.example.demo.model.entity.Category;
import com.example.demo.model.entity.CategoryName;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void checkIfEmpty() {
        if (this.categoryRepository.count() == 0) {
            Arrays.stream(CategoryName.values()).forEach(name -> {
                this.categoryRepository.save(new Category(name, String.format("%s description.", name.name())));

            });

        }
    }

    @Override
    public Category find (CategoryName categoryName) {
        return this.categoryRepository.findByCategoryName(categoryName).orElse(null);
    }
}
