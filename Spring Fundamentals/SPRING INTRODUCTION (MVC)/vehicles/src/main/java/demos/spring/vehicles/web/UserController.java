package demos.spring.vehicles.web;

import demos.spring.vehicles.model.binding.UserRegisterBindingModel;
import demos.spring.vehicles.model.entity.User;
import demos.spring.vehicles.service.UserService;
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
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public ModelAndView registerConfirm(@Valid @ModelAttribute("userRegisterBindingModel")
                                                UserRegisterBindingModel userRegisterBindingModel,
                                        BindingResult bindingResult, ModelAndView modelAndView) {
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("redirect:/users/register");

        } else {
            modelAndView.setViewName("redirect:/");
            User user = this.modelMapper.map(userRegisterBindingModel,User.class);
            user.setPassword(user.getUsername());

            userService.createUser(user);
        }
        return modelAndView;
    }

}
