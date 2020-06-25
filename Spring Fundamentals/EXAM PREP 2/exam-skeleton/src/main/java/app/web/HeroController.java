package app.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/heroes")
public class HeroController {

    @GetMapping("/details")
    public String detiles(){
        return "details-hero";
    }
}
