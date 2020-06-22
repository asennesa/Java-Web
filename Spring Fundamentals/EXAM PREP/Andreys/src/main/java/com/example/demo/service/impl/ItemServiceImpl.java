package com.example.demo.service.impl;

import com.example.demo.model.entity.Item;
import com.example.demo.model.service.ItemServiceModel;
import com.example.demo.repository.ItemRepository;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;


    public ItemServiceImpl(ItemRepository itemRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    @Override
    public void addItem(ItemServiceModel itemServiceModel) {

        Item item = this.modelMapper.map(itemServiceModel,Item.class);
        item.setCategory(this.categoryService.find(itemServiceModel.getCategory().getCategoryName()));
        this.itemRepository.saveAndFlush(item);


    }
}
