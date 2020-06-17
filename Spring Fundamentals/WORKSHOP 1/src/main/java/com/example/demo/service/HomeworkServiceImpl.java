package com.example.demo.service;

import com.example.demo.model.entity.Homework;
import com.example.demo.model.service.HomeworkServiceModel;
import com.example.demo.repository.HomeworkRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeworkServiceImpl implements HomeworkService {
    private final HomeworkRepository homeworkRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public HomeworkServiceImpl(HomeworkRepository homeworkRepository, ModelMapper modelMapper) {
        this.homeworkRepository = homeworkRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addHomework(HomeworkServiceModel homeworkServiceModel) {
        Homework homework = this.modelMapper.map(homeworkServiceModel,Homework.class);
        this.homeworkRepository.saveAndFlush(homework);
    }
}
