package com.example.demo.web;

import com.example.demo.model.binding.ExerciseAddBindingModel;
import com.example.demo.model.service.ExerciseServiceModel;
import com.example.demo.service.ExerciseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/exercises")
public class ExercisesController {
    private final ExerciseService exerciseService;
    private final ModelMapper modelMapper;

    @Autowired
    public ExercisesController(ExerciseService exerciseService, ModelMapper modelMapper) {
        this.exerciseService = exerciseService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add(@Valid @ModelAttribute("exerciseAddBindingModel") ExerciseAddBindingModel exerciseAddBindingModel,
                      BindingResult bindingResult) {
        return "exercise-add";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid @ModelAttribute("exerciseAddBindingModel") ExerciseAddBindingModel exerciseAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("exerciseAddBindingModel", exerciseAddBindingModel);
            return "redirect:/exercises/add";
        } else {
            if (!exerciseAddBindingModel.getDueDate().isBefore(exerciseAddBindingModel.getStartedOn()) ||
                    !exerciseAddBindingModel.getStartedOn().isAfter(exerciseAddBindingModel.getDueDate())) {
                this.exerciseService.addEx(this.modelMapper.map(exerciseAddBindingModel, ExerciseServiceModel.class));
            }

            return "redirect:/";
        }

    }
}
