package app.service;

import app.model.service.HeroServiceModel;
import app.model.view.HeroViewModel;
import org.springframework.stereotype.Service;

import java.util.List;


public interface HeroService {
    List<HeroViewModel> findAllHeroes();

    void addHero(HeroServiceModel heroServiceModel);

    HeroViewModel findById(String id);

    void delete(String id);
}
