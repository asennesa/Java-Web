package app.web;

import app.model.binding.HeroAddBindingModel;
import app.model.service.HeroServiceModel;
import app.service.HeroService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/heroes")
public class HeroController {
    private final HeroService heroService;
    private final ModelMapper modelMapper;

    @Autowired
    public HeroController(HeroService heroService, ModelMapper modelMapper) {
        this.heroService = heroService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/create")
    public String add(Model model) {
        if (!model.containsAttribute("heroAddBindingModel")) {
            model.addAttribute("heroAddBindingModel", new HeroAddBindingModel());
        }
        return "create-hero";
    }

    @PostMapping("/create")
    public String addPost(@Valid @ModelAttribute("heroAddBindingModel")
                                  HeroAddBindingModel heroAddBindingModel,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("heroAddBindingModel", heroAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.heroAddBindingModel", bindingResult);
            return "redirect:create";
        }
        HeroServiceModel heroServiceModel = this.modelMapper.map(heroAddBindingModel, HeroServiceModel.class);
        heroServiceModel.setaHeroClass(heroAddBindingModel.getHeroClass());
        this.heroService.addHero(heroServiceModel);

        return "redirect:/";

    }

    @GetMapping("/details")
    public ModelAndView details(@RequestParam("id") String id, ModelAndView modelAndView) {
        modelAndView.addObject("hero", this.heroService.findById(id));
        modelAndView.setViewName("details-hero");

        return modelAndView;

    }
    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam("id") String id, ModelAndView modelAndView) {
        modelAndView.addObject("hero", this.heroService.findById(id));
        modelAndView.setViewName("delete-hero");

        return modelAndView;

    }

    @GetMapping("/delete/{id}")
    public String deleteConfirm(@PathVariable("id") String id){
        this.heroService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:/";
    }

}
