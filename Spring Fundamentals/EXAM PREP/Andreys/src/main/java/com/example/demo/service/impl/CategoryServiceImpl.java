package com.example.demo.service.impl;

import com.example.demo.model.entity.Category;
import com.example.demo.model.entity.Name;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void checkIfEmpty() {
        if (this.categoryRepository.count() == 0) {
            Category shirt = new Category();
            shirt.setName(Name.Shirt);
            shirt.setDescription("Very nice shirts.");
            this.categoryRepository.saveAndFlush(shirt);
            Category denim = new Category();
            denim.setName(Name.Denim);
            denim.setDescription("Very nice denim.");
            this.categoryRepository.saveAndFlush(denim);
            Category shorts = new Category();
            shorts.setName(Name.Shorts);
            shorts.setDescription("Very nice shorts.");
            this.categoryRepository.saveAndFlush(shorts);
            Category jacket = new Category();
            jacket.setName(Name.Jacket);
            jacket.setDescription("Very nice jacket.");
            this.categoryRepository.saveAndFlush(jacket);
        }
    }
}
