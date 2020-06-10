package demos.spring.vehicles.web;

import demos.spring.vehicles.model.binding.ModelAddBindingModel;
import demos.spring.vehicles.model.entity.Model;
import demos.spring.vehicles.model.entity.User;
import demos.spring.vehicles.service.ModelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/models")
public class ModelController {
    private final ModelService modelService;
    private final ModelMapper modelMapper;

    @Autowired
    public ModelController(ModelService modelService, ModelMapper modelMapper) {
        this.modelService = modelService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String modelsGetRequest() {
        return "model-add";
    }

    @GetMapping
    public String getModels(Model models) {
        models.addAttribute("models", offerService.getOffers()); // set model data
        return "offers";
    }

    @PostMapping("/add")
    public ModelAndView modelsAdd(@Valid @ModelAttribute("modelAddBindingModel")
                                          ModelAddBindingModel modelAddBindingModel, BindingResult bindingResult, ModelAndView modelAndView) {
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("redirect:/models/add");

        } else {
            modelAndView.setViewName("redirect:/");
            Model model = this.modelMapper.map(modelAddBindingModel, Model.class);


            modelService.addModel(model);
        }
        return modelAndView;

    }

}
