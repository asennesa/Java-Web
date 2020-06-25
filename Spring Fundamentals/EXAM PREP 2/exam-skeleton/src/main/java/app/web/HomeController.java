package app.web;

import app.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    private final HeroService heroService;

    @Autowired
    public HomeController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping
    private ModelAndView index(HttpSession httpSession, ModelAndView modelAndView) {
        if (httpSession.getAttribute("user") == null) {
            modelAndView.setViewName("index");
        } else {
            modelAndView.addObject("items", this.heroService.findAllItems());
            modelAndView.setViewName("home");
        }

        return modelAndView;
    }


}
