package com.example.demo.web;

import com.example.demo.service.HomeworkService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/homework")
public class HomeworksController {

    private final HomeworkService homeworkService;
    private final ModelMapper modelMapper;

    @Autowired
    public HomeworksController(HomeworkService homeworkService, ModelMapper modelMapper) {
        this.homeworkService = homeworkService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String addHomework(){
        return "homework-add";
    }

//    @PostMapping("/add")
//    public String addHomeworkConfirm(@Valid @ModelAttribute)
//
//

}
